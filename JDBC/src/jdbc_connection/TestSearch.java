package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practices", "root", "shruti5");
		System.out.println("Connection successfully");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from employee");

		while (rs.next()) {

			System.out.println("id " + rs.getInt(1));
			System.out.println("name " + rs.getString(2));
			System.out.println("company " + rs.getString(3));
			System.out.println("address" + rs.getString(4));
			System.out.println(" salary " + rs.getInt(5));
			System.out.println("depid " + rs.getInt(6));
			System.out.println();
		}
		con.close();
	}

}
