package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practices", "root", "shruti5");

		System.out.println("successfully insert");
		Statement st = con.createStatement();

		int i = st.executeUpdate("insert into employee values (17,'sandeep','TCS','pune',7888,1)");
		System.out.println(i + " row affected");

		con.close();
	}

}
