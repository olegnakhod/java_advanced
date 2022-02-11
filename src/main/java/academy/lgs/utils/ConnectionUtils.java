package academy.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;


public class ConnectionUtils {
	
	private static String USER_NAME = "nakhod";
	private static String USER_PASSWORD = "123456";
	private  static String URL = "jdbc:mysql://localhost/shop_with_magazines?useUnicode=true&serverTimezone=UTC";	
		
	public static Connection  openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("loggerConfig.xml");	
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}	
}