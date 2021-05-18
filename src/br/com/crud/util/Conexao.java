package br.com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static Connection getConnectionPostgres() throws Exception {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:5432/engenharia";
		user = "postgres";
		password = "1234";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

}
