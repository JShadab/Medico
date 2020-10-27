package com.medico.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/medico", "root", "root");

			return connection;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

	}

}
