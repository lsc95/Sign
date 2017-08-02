package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.GroupDao;
import com.coderli.DaoImp.GroupDaoImp;
import com.coderli.Service.GroupService;
import com.coderli.entry.Sign;
import com.coderli.entry.User;

public class GroupServiceImp implements GroupService{
	private GroupDao dao = new GroupDaoImp();
	@Override
	public List<User> getGroupInfoService(int unumber) {
		return dao.getGroupInfo(unumber);
	}
	//根据用户的学号获取用户的签到信息
	@Override
	public List<Sign> getSignInfoService(String unumber, String page) {
		return dao.getSignInfo(unumber,page);
	}
	//根据学生的学号获取学生签到信息数量
	@Override
	public long getSignCountService(String unumber) {
		return dao.getSignCount(unumber);
	}

}
