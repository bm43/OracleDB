package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JavaOracleTest3 {
	public static void main(String[] args) {
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "ddd";
		
		try {
			// connect to database:
			Connection connection = DriverManager.getConnection(dbURL,username,password);
			
			String sql = "SELECT * FROM students";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while(result.next()) {
				count++;
				String name = result.getString("name");
				String email = result.getString("email");
				System.out.println("Student "+count+": "+name+" - "+ email);
			}
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		
		
	}
}
