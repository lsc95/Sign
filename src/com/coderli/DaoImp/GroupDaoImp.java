package com.coderli.DaoImp;

import java.util.List;

import com.coderli.Dao.GroupDao;
import com.coderli.entry.Sign;
import com.coderli.entry.User;
@SuppressWarnings("all")
public class GroupDaoImp extends BaseDaoImp implements GroupDao {

	// 根据组长number获取所有组员信息
	@Override
	public List<User> getGroupInfo(int unumber) {
		String sql = "select * from user where pnumber=?";
		return (List<User>) queryAll(sql, User.class, new Object[]{unumber});
		
	}

	public List<Sign> getSignInfo(String unumber, String page) {
		String sql = "select * from sign  where unumber=? order by sdate desc limit ?,5";
		int pageCount=(Integer.parseInt(page)-1)*5;
		return (List<Sign>) queryAll(sql, Sign.class, new Object[]{unumber,pageCount});
	}
	//根据学生的学号获取学生的签到总数
	@Override
	public long getSignCount(String unumber) {
		String sql="select count(*) from sign where unumber=?";
		return (long) queryOneValue(sql, new Object[]{unumber});
	}

}
