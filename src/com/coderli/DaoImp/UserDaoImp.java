package com.coderli.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.UserDao;
import com.coderli.entry.Menu;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

public class UserDaoImp implements UserDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public User getUserByNumberAndPwd(String unumber, String upwd) {
		User user = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from user where unumber = ? and upwd = ?";
			ps = DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, unumber, upwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				user=new User();
				user.setPnumber(rs.getInt("pnumber"));
				user.setRid(rs.getInt("rid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUage(rs.getInt("uage"));
				user.setUname(rs.getString("uname"));
				user.setUnumber(rs.getInt("unumber"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getString("usex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
//		System.out.println(user);
		return user;
	}

	@Override
	public List<Menu> getMenuInfoByRid(int rid) {
		List<Menu> list=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select m.mid,m.mname,m.murl from rm r,menu m where r.mid=m.mid and r.rid=?";
			ps=DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, rid);
			rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
		
		return list;
	}
	//插入用户签到信息
	@Override
	public int insertSign(String unumber, String inDate, String inTime,String inStatus) {
		String sql = "insert into sign(unumber,sintime,sdate,sinstatus) values(?,?,?,?)";
		return DBUtils.executeDML(sql,unumber,inDate,inTime,inStatus);
	}

	@Override
	public boolean checkInInfo(String unumber, String inDate) {
		//声明标记
		boolean flag=false;
		try {
			//给变量赋值
			conn=DBUtils.getConnection();
			String sql="select sintime from sign where unumber=? and sdate=?";
//			System.out.println(sql+":"+unumber+":"+inDate);
			ps=DBUtils.getPreparedStatement(sql, conn);
			//给占位符赋值
			DBUtils.bindParams(ps, unumber,inDate);
			//开始查询
			rs = ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//插入用户的签退信息
	public int updateSignOutInfo(String unumber, String outTime,
			String outDate, String outStatus) {
		//创建Sql
		String sql="update sign set souttime=?,soutstatus=? where unumber=? and sdate=?";
		return DBUtils.executeDML(sql, outTime,outStatus,unumber,outDate);
	}

	@Override
	public int updateUserNewPwdInfo(String newPwd, int unumber) {
		String sql="update user set upwd=? where unumber=?";
		return DBUtils.executeDML(sql, newPwd,unumber);
	}

	@Override
	public String getRnameInfo(String rid) {
		String rname=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select rname from role where rid=?";
			ps=DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, rid);
			rs=ps.executeQuery();
			if(rs.next()){
				rname=rs.getString("rname");
			}
		} catch (Exception e) {
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
		return rname;
	}

	@Override
	public String getPnameInfo(String pnumber) {
		String pname=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select uname from user where unumber=?";
			ps=DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, pnumber);
			rs=ps.executeQuery();
			if(rs.next()){
				pname=rs.getString("uname");
			}
		} catch (Exception e) {
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
		return pname;
	}

}
