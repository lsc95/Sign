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
	//插入用户签到信息
	@Override
	public int insertSign(String unumber, String inDate, String inTime,String inStatus) {
		return userDao.insertSign(unumber,inDate,inTime,inStatus);
	}
	//查询用户是否已经签到
	@Override
	public boolean checkInInfoService(String unumber, String inDate) {
		return userDao.checkInInfo(unumber,inDate);
	}

	@Override
	public int updateSignOutInfoService(String unumber, String outTime,
			String outDate,String outStatus) {
		return userDao.updateSignOutInfo(unumber,outTime,outDate,outStatus);
	}
	//修改用户的密码
	@Override
	public int updateUserNewPwdInfoService(String newPwd, int unumber) {
		return userDao.updateUserNewPwdInfo(newPwd,unumber);
	}
	//获取角色名
	@Override
	public String getRnameInfoService(String rid) {
		return userDao.getRnameInfo(rid);
	}
	//获取上级的名字
	@Override
	public String getPnameInfoService(String pnumber) {
		return userDao.getPnameInfo(pnumber);
	}

}
