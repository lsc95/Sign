package test;


import com.coderli.utils.DBUtils;

public class InsertDataTest {
	public static void main(String[] args) {

		String sql="insert into sign(unumber,sintime,sinstatus,souttime,soutstatus,sdate)values(?,?,?,?,?,?)";
		for (int i = 0; i <20; i++) {
			Object[] obs = {20170729,"9:12:34","1","18:23:12","0","2017-07-"+(10+i)};
			DBUtils.executeDML(sql,obs);
		}
	}
}
