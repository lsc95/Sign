package com.coderli.Dao;

import java.util.List;

import com.coderli.entry.Menu;
import com.coderli.entry.User;

public interface UserDao {
	User getUserByNumberAndPwd(String unumber,String upwd);

	List<Menu> getMenuInfoByRid(int rid);
	//插入用户签到信息
	int insertSign(String unumber, String inDate, String inTime, String inStatus);
	//查询用户是否已经签到
	boolean checkInInfo(String unumber, String inDate);
	//插入用户的签退信息
	int updateSignOutInfo(String unumber, String outTime, String outDate,String outStatus);
	//修改用户的密码
	int updateUserNewPwdInfo(String newPwd, int unumber);
	//获取角色名
	String getRnameInfo(String rid);
	//获取上一级的名字
	String getPnameInfo(String pnumber);
}
