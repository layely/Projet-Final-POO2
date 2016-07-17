package databaseDAOs;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection getConnection() {
		try {
			Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/orientation",
					"root", "");
			return connect;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

}
