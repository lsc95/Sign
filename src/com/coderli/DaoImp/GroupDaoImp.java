package com.coderli.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.GroupDao;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

public class GroupDaoImp implements GroupDao{
	//定义数据库相关的私有全局变量
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//根据组长number获取所有组员信息
	@Override
	public List<User> getGroupInfo(int unumber) {
		//存放组员信息的容器
		List<User> list = null;
		try {
			//赋值
			conn=DBUtils.getConnection();
			String sql="select * from user where pnumber=?";
			ps= DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, unumber);
			rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				User user=new User();
				user.setRid(rs.getInt("rid"));
				user.setUaddress(rs.getString("uaddress"));
				user.setUage(rs.getInt("uage"));
				user.setUname(rs.getString("uname"));
				user.setUnumber(rs.getInt("unumber"));
				user.setUpwd(rs.getString("upwd"));
				user.setUsex(rs.getString("usex"));
				user.setPnumber(rs.getInt("pnumber"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs,ps,conn);
		}
		return list;
	}

}
