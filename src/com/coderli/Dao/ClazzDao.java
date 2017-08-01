package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.User;

public interface ClazzDao {
	//获取全班的学生信息
	List<User> getClazzInfo(String rid);

}
