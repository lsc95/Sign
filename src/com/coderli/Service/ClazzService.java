package com.coderli.Service;

import java.util.List;

import com.coderli.entry.User;

public interface ClazzService {
	//获取全班的数据信息
	List<User> getClazzInfoService(String rid);

}
