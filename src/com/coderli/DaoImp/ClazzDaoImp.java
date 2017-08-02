package com.coderli.DaoImp;

import java.util.List;
import com.coderli.Dao.ClazzDao;
import com.coderli.entry.User;

@SuppressWarnings("all")
public class ClazzDaoImp extends BaseDaoImp implements ClazzDao {

	// 获取全班的学生信息
	@Override
	public List<User> getClazzInfo(String rid) {
		if (rid == null) {
			String sql = "select u.*,u1.uname 'pname',r.rname from user u,user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid";
			return (List<User>) queryAll(sql, User.class, null);
		} else {
			String sql = "select u.*,u1.uname 'pname',r.rname from user u,user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid and u.rid=?";
			return (List<User>) queryAll(sql, User.class, new Object[] { rid });
		}

	}

}
