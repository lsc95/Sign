package com.coderli.Service;

import java.util.List;

import com.coderli.entry.Sign;
import com.coderli.entry.User;

public interface GroupService {

	List<User> getGroupInfoService(int unumber);
	//根据用户的number获取用户签到信息
	List<Sign> getSignInfoService(String unumber, String page);
	//根据学生学号获取学生的签到信息数
	long getSignCountService(String unumber);

}
