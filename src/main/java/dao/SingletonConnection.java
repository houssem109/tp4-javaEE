package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_PC", "root", "");
=======
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_CAT", "root", "");
>>>>>>> 53407e9 ( tp4 complet)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
