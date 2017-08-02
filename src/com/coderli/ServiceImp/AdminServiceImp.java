package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.AdminDao;
import com.coderli.DaoImp.AdminDaoImp;
import com.coderli.Service.AdminService;
import com.coderli.entry.Role;

public class AdminServiceImp implements AdminService{
	private AdminDao dao = new AdminDaoImp();
	//获取所有的角色信息
	@Override
	public List<Role> getRoleInfoService() {
		return dao.getRoleInfo();
	}
	//更新用户的信息
	@Override
	public int updateUserInfoService(String unumber, String rid, String pnumber) {
		return dao.updateUserInfo(unumber,rid,pnumber);
	}
	//删除用户信息
	@Override
	public int deleteUserInfoService(String unumber) {
		return dao.deleteUserInfo(unumber);
	}
	//添加用户信息
	@Override
	public int addUserInfoService(String[] params) {
		return dao.addUserInfo(params);
	}

}
