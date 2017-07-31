package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserDao {
	User getUserByNumberAndPwd(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//插入用户签到信息
	int insertSign(String unumber, String inDate, String inTime);
	//查询用户是否已经签到
	boolean checkInInfo(String unumber, String inDate);
}
