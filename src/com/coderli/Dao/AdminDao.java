package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Role;

public interface AdminDao {
	//��ȡ���еĽ�ɫ��Ϣ
	List<Role> getRoleInfo();
	//�����û�������
	int updateUserInfo(String unumber, String rid, String pnumber);
	//ɾ���û���Ϣ
	int deleteUserInfo(String unumber);
	//����û���Ϣ
	int addUserInfo(String[] params);

}
