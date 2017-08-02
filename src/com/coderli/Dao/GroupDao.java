package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Sign;
import com.coderli.entry.User;

public interface GroupDao {

	List<User> getGroupInfo(int unumber);
	//根据学生的学号获取学生的签到信息
	List<Sign> getSignInfo(String unumber, String page);
	//根据学生的学号获取学生签到信息数量
	long getSignCount(String unumber);

}
