package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.User;

public interface ClazzDao {
	//��ȡȫ���ѧ����Ϣ
	List<User> getClazzInfo(String rid);

}
