package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Sign;
import com.coderli.entry.User;

public interface GroupService {

	List<User> getGroupInfoService(int unumber);
	//�����û���number��ȡ�û�ǩ����Ϣ
	List<Sign> getSignInfoService(String unumber, String page);
	//����ѧ��ѧ�Ż�ȡѧ����ǩ����Ϣ��
	long getSignCountService(String unumber);

}
