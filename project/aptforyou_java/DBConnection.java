package project.apt.foryou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private  Connection con;
	
	public  Connection getConnection() {
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "aptforyou", "aptforyou");
			
		} catch (Exception e) {
			System.out.println("연결에러");
			e.printStackTrace();
		}
		return con;
	}
	
}
