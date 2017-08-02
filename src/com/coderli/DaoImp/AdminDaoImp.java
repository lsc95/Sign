package com.coderli.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.AdminDao;
import com.coderli.entry.Role;
import com.coderli.utils.DBUtils;

@SuppressWarnings("all")
public class AdminDaoImp implements AdminDao{
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public List<Role> getRoleInfo() {
		List<Role> list =null;
		//赋值
		try {
			conn=DBUtils.getConnection();
			//创建sql语句
			String sql="select * from role";
			ps=DBUtils.getPreparedStatement(sql, conn);
			//开始查询
			rs=ps.executeQuery();
			list=new ArrayList<>();
			//开始遍历
			while(rs.next()){
				Role role  = new Role();
				role.setRid(rs.getInt("rid"));
				role.setRname(rs.getString("rname"));
				role.setRdesc(rs.getString("rdesc"));
				list.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
		return list;
	}
	//更新用户的信息
	@Override
	public int updateUserInfo(String unumber, String rid, String pnumber) {
		String sql="update user set rid=?,pnumber=? where unumber=?";
		return DBUtils.executeDML(sql, rid,pnumber,unumber);
	}
	//删除用户信息
	@Override
	public int deleteUserInfo(String unumber) {
		//创建sql
		String sql="delete from user where unumber=?";
		return DBUtils.executeDML(sql, unumber);
	}
	@Override
	public int addUserInfo(String[] params) {
		//创建sql
		String sql="insert into user values(?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, params);
	}

}
