package com.pkm.test.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDetaiDB();
	}
	
	public static String testDetaiDB() {
		System.out.println("Hit");
		String data ="testDetaiDB";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://172.17.0.2:3306/my_db", "root", "pritam");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from author");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
						+ rs.getString(3));
			data=data+rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			data=e.getMessage();
		}

		return data;
	}

}
