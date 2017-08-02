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
public class AdminDaoImp extends BaseDaoImp implements AdminDao{

	//��ѯ���еĽ�ɫ��Ϣ
	public List<Role> getRoleInfo() {
		String sql="select * from role";
		return (List<Role>) queryAll(sql, Role.class, null);
	}
	//�����û�����Ϣ
	@Override
	public int updateUserInfo(String unumber, String rid, String pnumber) {
		String sql="update user set rid=?,pnumber=? where unumber=?";
		return DBUtils.executeDML(sql, rid,pnumber,unumber);
	}
	//ɾ���û���Ϣ
	@Override
	public int deleteUserInfo(String unumber) {
		//����sql
		String sql="delete from user where unumber=?";
		return DBUtils.executeDML(sql, unumber);
	}
	@Override
	public int addUserInfo(String[] params) {
		//����sql
		String sql="insert into user values(?,?,?,?,?,?,?,?)";
		return DBUtils.executeDML(sql, params);
	}

}
