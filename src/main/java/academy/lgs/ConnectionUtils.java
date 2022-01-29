package academy.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static String USER_NAME = "nakhod";
	private static String USER_PASSWORD = "123456";
	private  static String URL = "jdbc:mysql://localhost/shop_with_magazines";	
		
	public static Connection  openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}	
}