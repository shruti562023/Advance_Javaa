package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practices", "root", "shruti5");

		Statement st = con.createStatement();

		int i = st.executeUpdate("update employee set name = 'darsh'  where id = 9");

		System.out.println(i + " rows affected");

	}

}
