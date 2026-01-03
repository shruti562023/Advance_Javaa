package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices","root","shruti5");
 
 Statement st=con.createStatement();
int i =st.executeUpdate("delete from employee where id = 6");
 System.out.println(i +"row affected");
 
	con.close();	
		
	}

}
