package databaseDAOs;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection getConnection() {
		try {
			Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/orientation",
					"orientation", "42c1c3");
			return connect;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

}
