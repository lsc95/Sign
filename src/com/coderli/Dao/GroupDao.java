package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Sign;
import com.coderli.entry.User;

public interface GroupDao {

	List<User> getGroupInfo(int unumber);
	//����ѧ����ѧ�Ż�ȡѧ����ǩ����Ϣ
	List<Sign> getSignInfo(String unumber, String page);
	//����ѧ����ѧ�Ż�ȡѧ��ǩ����Ϣ����
	long getSignCount(String unumber);

}
