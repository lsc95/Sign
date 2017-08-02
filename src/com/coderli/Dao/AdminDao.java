package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Role;

public interface AdminDao {
	//获取所有的角色信息
	List<Role> getRoleInfo();
	//更新用户的数据
	int updateUserInfo(String unumber, String rid, String pnumber);
	//删除用户信息
	int deleteUserInfo(String unumber);
	//添加用户信息
	int addUserInfo(String[] params);

}
