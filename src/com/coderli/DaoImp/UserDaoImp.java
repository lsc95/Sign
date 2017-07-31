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
	//�����û�ǩ����Ϣ
	@Override
	public int insertSign(String unumber, String inDate, String inTime) {
		String sql = "insert into sign(unumber,sintime,sdate) values(?,?,?)";
		return DBUtils.executeDML(sql,unumber,inDate,inTime);
	}

	@Override
	public boolean checkInInfo(String unumber, String inDate) {
		//�������
		boolean flag=false;
		try {
			//��������ֵ
			conn=DBUtils.getConnection();
			String sql="select sintime from sign where unumber=? and sdate=?";
//			System.out.println(sql+":"+unumber+":"+inDate);
			ps=DBUtils.getPreparedStatement(sql, conn);
			//��ռλ����ֵ
			DBUtils.bindParams(ps, unumber,inDate);
			//��ʼ��ѯ
			rs = ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//�����û���ǩ����Ϣ
	public static int updateSignOutInfo(String unumber, String outTime,
			String outDate) {
		//����Sql
		String sql="update sign set souttime=? where unumber=? and sdate=?";
		return DBUtils.executeDML(sql, outTime,unumber,outDate);
	}

}