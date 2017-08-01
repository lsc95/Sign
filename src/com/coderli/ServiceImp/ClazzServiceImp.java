package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.ClazzDao;
import com.coderli.DaoImp.ClazzDaoImp;
import com.coderli.Service.ClazzService;
import com.coderli.entry.User;

public class ClazzServiceImp implements ClazzService{
	private ClazzDao dao = new ClazzDaoImp();
	//获取全班的请求信息
	@Override
	public List<User> getClazzInfoService(String rid) {
		return dao.getClazzInfo(rid);
	}

}
