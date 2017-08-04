package com.coderli.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.apache.log4j.Logger;

public class DBUtils {
	//��ȡ��־�������
	private static Logger logger = Logger.getLogger(DBUtils.class);
	private DBUtils() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			return DriverManager.getConnection("proxool.test");
		} catch (SQLException e) {
			logger.error(e.toString());
		} catch (ClassNotFoundException e) {
			logger.error("�ļ�û���ҵ�"+e.toString());
		}
		return null;
	}

	// ��ȡuuid
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	// ��ȡpreparedStatement
	public static PreparedStatement getPreparedStatement(String sql,
			Connection conn) {
		try {
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			logger.error("����preparedStatementʧ��:"+e.toString());
		}
		return null;
	}

	// ��ȡstatement����
	public static Statement getStatement(Connection conn) {
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			logger.error("����Statement�����쳣:"+e.toString());
		}
		return null;
	}

	// �󶨲���
	public static void bindParams(PreparedStatement ps, Object... objects) {
		for (int i = 0; i <objects.length; i++) {
			try {
				ps.setObject((i+1), objects[i]);
			} catch (SQLException e) {
				logger.error("���ݲ����󶨳����쳣:"+e.toString());
			}
		}
	}

	// �ر���Դ
	public static void closeAll(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			try {
				if (closeable != null)
					closeable.close();
			} catch (Exception e) {
				logger.error("��Դ�رճ����쳣:"+e.toString());
			}
		}
	}

	public static int executeDML(String sql,Object...objects ) {
		Connection conn=getConnection();
		PreparedStatement ps = getPreparedStatement(sql, conn);
		int i=-1;
		try {
			bindParams(ps, objects);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("ִ��DML���������쳣:"+e.toString());
		}finally{
			closeAll(ps,conn);
		}
		return i;
	}
}
