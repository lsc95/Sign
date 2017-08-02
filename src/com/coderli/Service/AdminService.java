package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Role;

public interface AdminService {
	//获取所有的角色信息
	List<Role> getRoleInfoService();
	//更新用户的数据
	int updateUserInfoService(String unumber, String rid, String pnumber);
	//删除用户信息
	int deleteUserInfoService(String unumber);
	//添加用户信息
	int addUserInfoService(String[] params);

}
