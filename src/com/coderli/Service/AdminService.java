package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Role;

public interface AdminService {
	//��ȡ���еĽ�ɫ��Ϣ
	List<Role> getRoleInfoService();
	//�����û�������
	int updateUserInfoService(String unumber, String rid, String pnumber);
	//ɾ���û���Ϣ
	int deleteUserInfoService(String unumber);
	//����û���Ϣ
	int addUserInfoService(String[] params);

}
