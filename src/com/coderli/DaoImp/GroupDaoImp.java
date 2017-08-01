package com.coderli.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderli.Dao.GroupDao;
import com.coderli.entry.Sign;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

public class GroupDaoImp implements GroupDao {
	// �������ݿ���ص�˽��ȫ�ֱ���
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// �����鳤number��ȡ������Ա��Ϣ
	@Override
	public List<User> getGroupInfo(int unumber) {
		// �����Ա��Ϣ������
		List<User> list = null;
		try {
			// ��ֵ
			conn = DBUtils.getConnection();
			String sql = "select * from user where pnumber=?";
			ps = DBUtils.getPreparedStatement(sql, conn);
			DBUtils.bindParams(ps, unumber);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
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
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<Sign> getSignInfo(String unumber, String page) {
		// ���ǩ����Ϣ������
		List<Sign> list = null;
		try {
			// ��ֵ
			conn = DBUtils.getConnection();
			String sql = "select * from sign  where unumber=? order by sdate desc limit ?,5";
			ps = DBUtils.getPreparedStatement(sql, conn);
			int pageCount=(Integer.parseInt(page)-1)*5;
			DBUtils.bindParams(ps, unumber,pageCount);
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Sign s = new Sign();
				s.setSid(rs.getInt("sid"));
				s.setSdate(rs.getString("sdate"));
				s.setSinstatus(rs.getString("sinstatus"));
				s.setSintime(rs.getString("sintime"));
				s.setSoutstatus(rs.getString("soutstatus"));
				s.setSouttime(rs.getString("souttime"));
				s.setUnumber(rs.getInt("unumber"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}
	//����ѧ����ѧ�Ż�ȡѧ����ǩ������
	@Override
	public int getSignCount(String unumber) {
		try {
			//��������ֵ
			conn=DBUtils.getConnection();
			//��дsql���
			String sql="select count(*) from sign where unumber=?";
			ps=DBUtils.getPreparedStatement(sql, conn);
			//��ռλ����ֵ
			DBUtils.bindParams(ps, unumber);
			//��ʼ��ѯ
			rs=ps.executeQuery();
			//�����ѯ���
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
