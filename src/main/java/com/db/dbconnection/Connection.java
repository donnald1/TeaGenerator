package com.db.dbconnection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.jdbi.v3.core.Jdbi;

public class Connection {
	private Jdbi dbi;
	private String host = "127.0.0.1";
	private static Connection conInstance = new Connection();
	public Connection() {
	
		buildCon();
		
	}
	
	public void buildCon() {
		
		DataSource dataSource = new DataSource();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://"+ host +"/test");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setValidationQuery("SELECT 1");
			dataSource.setTestOnBorrow(true);
			dataSource.setRemoveAbandoned(true);
			dataSource.setLogAbandoned(true);
			dataSource.setMaxActive(100);
			dataSource.setMaxIdle(100);
			
			this.dbi = Jdbi.create(dataSource);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection get() {
		return conInstance;
	}
	
	public Jdbi getDBI() {
		return this.dbi;
	}
}
