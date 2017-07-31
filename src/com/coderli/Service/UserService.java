package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserService {
	User checkLoginInfo(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//�����û�ǩ����Ϣ
	int insertSign(String unumber, String inDate, String inTime, String inStatus);
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	boolean checkInInfoService(String unumber, String inDate);
	//�����û���ǩ����Ϣ
	int updateSignOutInfoService(String unumber, String outTime, String outDate, String outStatus);
	//�޸��û�������
	int updateUserNewPwdInfoService(String newPwd, int unumber);
	//��ȡ��ɫ��
	String getRnameInfoService(String rid);
	//��ȡ�ϼ��û�����
	String getPnameInfoService(String pnumber);
}
