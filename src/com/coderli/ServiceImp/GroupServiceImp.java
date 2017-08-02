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
	//�����û���ѧ�Ż�ȡ�û���ǩ����Ϣ
	@Override
	public List<Sign> getSignInfoService(String unumber, String page) {
		return dao.getSignInfo(unumber,page);
	}
	//����ѧ����ѧ�Ż�ȡѧ��ǩ����Ϣ����
	@Override
	public long getSignCountService(String unumber) {
		return dao.getSignCount(unumber);
	}

}
