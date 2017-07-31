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
	//�������ݿ���ص�˽��ȫ�ֱ���
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//�����鳤number��ȡ������Ա��Ϣ
	@Override
	public List<User> getGroupInfo(int unumber) {
		//�����Ա��Ϣ������
		List<User> list = null;
		try {
			//��ֵ
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
