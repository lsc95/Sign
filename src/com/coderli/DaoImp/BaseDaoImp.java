package com.coderli.DaoImp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InterfaceAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.coderli.entry.User;
import com.coderli.utils.DBUtils;

@SuppressWarnings("all")
public class BaseDaoImp {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * ��ѯ�ĸ�������
	 * @param sql ִ�е�sql
	 * @param clazz ���ݶ�Ӧ��ʵ����
	 * @param params sql����Ҫ�Ĳ���
	 * @param back ��ѯ����Ļص�����
	 * @return ����Ҫ������
	 */
	public Object QueryTemplate(String sql, Class clazz, Object[] params,
			Callback back) {
		try {
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(sql, conn);
			// ��ռλ����ֵ
			if(params!=null){
				DBUtils.bindParams(ps, params);
			}
			// ��ʼ��ѯ
			try {
				rs = ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return back.callback(conn, ps, rs,clazz);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return null;
	}
	/**
	 * ����sql�Ͳ�����ѯ������������������
	 * @param sql ִ�е�sql
	 * @param clazz ���ݶ�Ӧ��ʵ����
	 * @param params sql����Ҫ�Ĳ���
	 * @return sql���ɸѡ�����ݼ�
	 */
	public Object queryAll(String sql, Class clazz, Object[] params) {
		return QueryTemplate(sql, clazz, params, new Callback() {

			@Override
			public Object callback(Connection conn, PreparedStatement ps,
					ResultSet rs,Class clazz) {
				List list = new ArrayList<>();
				// ��ʼ����
				// ������е��ֶ���
				Field[] fields = clazz.getDeclaredFields();
				// ��ȡ���еķ�����
				Method[] methods = clazz.getMethods();
				// ���set�����ļ���
				List<Method> lm = new ArrayList<>();
				// ɸѡ����set����
				for (Method method : methods) {
					if (method.getName().toLowerCase().startsWith("set")) {
						lm.add(method);
					}
				}
				try {
					while (rs.next()) {
						Object obj = clazz.newInstance();
						for (Field field : fields) {
							if (field.getName().equals("serialVersionUID"))
								continue;
							Method method = null;
							for (Method m : lm) {
								if (m.getName().toLowerCase()
										.equals("set" + field.getName())) {
									method = m;
								}
							}
							try {
								method.invoke(obj, rs.getObject(field.getName()));
							} catch (Exception e) {
							}
						}
						list.add(obj);
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return list;
			}

		});

	}
	/**
	 * ����sql����������ѯĳ����¼
	 * @param sql ִ�е�sql
	 * @param clazz ������������Ӧ��ʵ����
	 * @param params sql�Ĳ���
	 * @return ��Ҫ��ѯ����������
	 */
	public Object quertyOneRow(String sql,Class clazz,Object[] params){
		List list =(List) queryAll(sql, clazz, params);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * ����sql���Ͳ�����ѯĳ��ֵ
	 * @param sql ִ�е�sql
	 * @param params sql����Ҫ�Ĳ���
	 * @return ��Ҫ��ĳ���ֶε�ֵ
	 */
	public Object queryOneValue(String sql,Object[] params){
		return QueryTemplate(sql, null, params, new Callback(){

			@Override
			public Object callback(Connection conn, PreparedStatement ps,
					ResultSet rs, Class clazz) {
				try {
					if(rs.next()){
						return rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			
		});
		
	}

	interface Callback {
		Object callback(Connection conn, PreparedStatement ps, ResultSet rs,Class clazz);
	}
}
