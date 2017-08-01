package com.coderli.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.ClazzDao;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

public class ClazzDaoImp implements ClazzDao{
	//声明jdbc的变量
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//获取全班的学生信息
	@Override
	public List<User> getClazzInfo(String rid) {
		List<User> list=null;
		try {
			//赋值
			conn=DBUtils.getConnection();
			//创建sql语句
			if(rid==null){
				String sql="select u.*,u1.uname 'pname',r.rname from user u,user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid";
				ps=DBUtils.getPreparedStatement(sql, conn);
			}else{
				String sql="select u.*,u1.uname 'pname',r.rname from user u,user u1,role r where u.pnumber=u1.unumber and u.rid=r.rid and u.rid=?";
				ps=DBUtils.getPreparedStatement(sql, conn);
				DBUtils.bindParams(ps, rid);
			}
			rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				User user=new User();
				user.setPnumber(rs.getInt("pnumber"));
				user.setRid(rs.getInt("rid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUage(rs.getInt("uage"));
				user.setUname(rs.getString("uname"));
				user.setUnumber(rs.getInt("unumber"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getString("usex"));
				user.setPname(rs.getString("pname"));
				user.setRname(rs.getString("rname"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
