package com.helloqidi.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private String dbUrl="jdbc:mysql://localhost:3306/db_cityInfo";
	private String dbUserName="root";
	private String dbPassword="alexander";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	public void close(Connection con)throws Exception{
		if(con!=null){
			con.close();			
		}
	}
	
	
}