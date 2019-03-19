package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() {
		Connection cons = null;

			
			String url = "jdbc:sqlserver://localhost:1433;databaseName=sqlshop";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				cons = DriverManager.getConnection(url,"sa","12345678");
				
			} catch (Exception e) {		
				e.printStackTrace();
			}
		
		return cons;		
	}
	
	public static void main(String[] args) {
 
			System.out.println(getConnection());
		
	}
}
