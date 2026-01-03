package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testCallable {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		
		CallableStatement cs=con.prepareCall("{CALL searchById()}");
		
		ResultSet rs=cs.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getInt(5));
			System.out.println(rs.getInt(6));
			System.out.println("-------------------------------------");
		}
		
		cs.close();
		con.close();
	}

}
