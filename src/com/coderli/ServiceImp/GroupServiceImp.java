package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.GroupDao;
import com.coderli.DaoImp.GroupDaoImp;
import com.coderli.Service.GroupService;
import com.coderli.entry.User;

public class GroupServiceImp implements GroupService{
	private GroupDao dao = new GroupDaoImp();
	@Override
	public List<User> getGroupInfoService(int unumber) {
		return dao.getGroupInfo(unumber);
	}

}
