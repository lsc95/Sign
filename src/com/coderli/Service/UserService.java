package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserService {
	User checkLoginInfo(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//�����û�ǩ����Ϣ
	int insertSign(String unumber, String inDate, String inTime);
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	boolean checkInInfoService(String unumber, String inDate);
	//�����û���ǩ����Ϣ
	int updateSignOutInfoService(String unumber, String outTime, String outDate);
}
