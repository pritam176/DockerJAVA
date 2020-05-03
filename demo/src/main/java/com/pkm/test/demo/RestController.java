/**
 * 
 */
package com.pkm.test.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author RIKI
 *
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/test")
	public String testDetai() {
		return "Working from Docker DB Test Compose Git Hub  docker";
	}

	@GetMapping("/testDB")
	public String testDetaiDB() {
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
			data=data+rs.getString(2);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			data=e.getMessage();
		}

		return data;
	}

}
