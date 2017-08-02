package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.coderli.DaoImp.BaseDaoImp;
import com.coderli.entry.Role;
import com.coderli.entry.Sign;
import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

public class QueryTest {
	public static void main(String[] args) throws SQLException {
		BaseDaoImp bd = new BaseDaoImp();
		String sql="select count(*) from sign where unumber=?";
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(sql, connection);
		DBUtils.bindParams(ps, 666);
		ResultSet rs=ps.executeQuery();
//		 System.out.println((long)bd.queryOneValue(sql, new Object[]{20170729}));
		
	}
}
