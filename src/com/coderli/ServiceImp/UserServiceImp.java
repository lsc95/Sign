package com.coderli.ServiceImp;

import java.util.List;

import com.coderli.Dao.UserDao;
import com.coderli.DaoImp.UserDaoImp;
import com.coderli.Service.UserService;
import com.coderli.entry.Menu;
import com.coderli.entry.User;

public class UserServiceImp implements UserService{
	private UserDao userDao=new UserDaoImp();
	@Override
	public User checkLoginInfo(String unumber, String upwd) {
		return userDao.getUserByNumberAndPwd(unumber, upwd);
	}

	@Override
	public List<Menu> getMenuInfoByRid(int rid) {
		return userDao.getMenuInfoByRid(rid);
	}
	//�����û�ǩ����Ϣ
	@Override
	public int insertSign(String unumber, String inDate, String inTime) {
		return userDao.insertSign(unumber,inDate,inTime);
	}
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	@Override
	public boolean checkInInfoService(String unumber, String inDate) {
		return userDao.checkInInfo(unumber,inDate);
	}

	@Override
	public int updateSignOutInfoService(String unumber, String outTime,
			String outDate) {
		return UserDaoImp.updateSignOutInfo(unumber,outTime,outDate);
	}

}
