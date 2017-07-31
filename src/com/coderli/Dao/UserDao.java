package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserDao {
	User getUserByNumberAndPwd(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//�����û�ǩ����Ϣ
	int insertSign(String unumber, String inDate, String inTime, String inStatus);
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	boolean checkInInfo(String unumber, String inDate);
	//�����û���ǩ����Ϣ
	int updateSignOutInfo(String unumber, String outTime, String outDate,String outStatus);
	//�޸��û�������
	int updateUserNewPwdInfo(String newPwd, int unumber);
	//��ȡ��ɫ��
	String getRnameInfo(String rid);
	//��ȡ��һ��������
	String getPnameInfo(String pnumber);
}
