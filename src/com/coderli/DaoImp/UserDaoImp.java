package com.coderli.DaoImp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.UserDao;
import com.coderli.entry.Menu;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;


@SuppressWarnings("all")
public class UserDaoImp extends BaseDaoImp implements UserDao {
	@Override
	public User getUserByNumberAndPwd(String unumber, String upwd) {
		String sql = "select * from user where unumber = ? and upwd = ?";
		return (User) quertyOneRow(sql, User.class, new Object[]{unumber,upwd});
	}

	@Override
	public List<Menu> getMenuInfoByRid(int rid) {
		String sql="select m.mid,m.mname,m.murl from rm r,menu m where r.mid=m.mid and r.rid=?";
		return (List<Menu>) queryAll(sql, Menu.class, new Object[]{rid});
	}
	//�����û�ǩ����Ϣ
	@Override
	public int insertSign(String unumber, String inDate, String inTime,String inStatus) {
		String sql = "insert into sign(unumber,sintime,sdate,sinstatus) values(?,?,?,?)";
		return DBUtils.executeDML(sql,unumber,inDate,inTime,inStatus);
	}
	//��ѯ�û��Ƿ��Ѿ�ǩ��
	@Override
	public boolean checkInInfo(String unumber, String inDate) {
		String sql="select sintime from sign where unumber=? and sdate=?";
		return (boolean) QueryTemplate(sql, null, new Object[]{unumber,inDate}, new Callback(){

			@Override
			public Object callback(Connection conn, PreparedStatement ps,
					ResultSet rs, Class clazz) {
				try {
					if(rs.next()){
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
		});
	}
	//�����û���ǩ����Ϣ
	public int updateSignOutInfo(String unumber, String outTime,
			String outDate, String outStatus) {
		//����Sql
		String sql="update sign set souttime=?,soutstatus=? where unumber=? and sdate=?";
		return DBUtils.executeDML(sql, outTime,outStatus,unumber,outDate);
	}

	@Override
	public int updateUserNewPwdInfo(String newPwd, int unumber) {
		String sql="update user set upwd=? where unumber=?";
		return DBUtils.executeDML(sql, newPwd,unumber);
	}
	//��ȡȨ����
	@Override
	public String getRnameInfo(String rid) {
		String sql="select rname from role where rid=?";
		return (String) queryOneValue(sql, new Object[]{rid});
	}

	@Override
	public String getPnameInfo(String pnumber) {
		String sql="select uname from user where unumber=?";
		return (String) queryOneValue(sql, new Object[]{pnumber});
	}

}
