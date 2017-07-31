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
	public int insertSign(String unumber, String inDate, String inTime,String inStatus) {
		return userDao.insertSign(unumber,inDate,inTime,inStatus);
	}
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	@Override
	public boolean checkInInfoService(String unumber, String inDate) {
		return userDao.checkInInfo(unumber,inDate);
	}

	@Override
	public int updateSignOutInfoService(String unumber, String outTime,
			String outDate,String outStatus) {
		return userDao.updateSignOutInfo(unumber,outTime,outDate,outStatus);
	}
	//�޸��û�������
	@Override
	public int updateUserNewPwdInfoService(String newPwd, int unumber) {
		return userDao.updateUserNewPwdInfo(newPwd,unumber);
	}
	//��ȡ��ɫ��
	@Override
	public String getRnameInfoService(String rid) {
		return userDao.getRnameInfo(rid);
	}
	//��ȡ�ϼ�������
	@Override
	public String getPnameInfoService(String pnumber) {
		return userDao.getPnameInfo(pnumber);
	}

}
