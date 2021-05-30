package br.com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() throws Exception {
		
		String driver = "org.postgresql.Driver";
		String senha = "1234";
		String url = "jdbc:postgresql://localhost:5432/sistema";
		String user = "postgres";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, senha);

		return con;
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
