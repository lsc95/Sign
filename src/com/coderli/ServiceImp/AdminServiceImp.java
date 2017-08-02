package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.AdminDao;
import com.coderli.DaoImp.AdminDaoImp;
import com.coderli.Service.AdminService;
import com.coderli.entry.Role;

public class AdminServiceImp implements AdminService{
	private AdminDao dao = new AdminDaoImp();
	//��ȡ���еĽ�ɫ��Ϣ
	@Override
	public List<Role> getRoleInfoService() {
		return dao.getRoleInfo();
	}
	//�����û�����Ϣ
	@Override
	public int updateUserInfoService(String unumber, String rid, String pnumber) {
		return dao.updateUserInfo(unumber,rid,pnumber);
	}
	//ɾ���û���Ϣ
	@Override
	public int deleteUserInfoService(String unumber) {
		return dao.deleteUserInfo(unumber);
	}
	//����û���Ϣ
	@Override
	public int addUserInfoService(String[] params) {
		return dao.addUserInfo(params);
	}

}
