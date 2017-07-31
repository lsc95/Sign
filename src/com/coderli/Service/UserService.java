package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserService {
	User checkLoginInfo(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//插入用户签到信息
	int insertSign(String unumber, String inDate, String inTime);
	//查询用户是否已经签到
	boolean checkInInfoService(String unumber, String inDate);
	//插入用户的签退信息
	int updateSignOutInfoService(String unumber, String outTime, String outDate);
}
