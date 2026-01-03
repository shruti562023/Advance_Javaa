package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class testDelete {
	
	public static void main(String[] args) throws Throwable {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root" ,"shruti5");
		 CallableStatement cs=con.prepareCall("{CALL valueDelete()}");
		 
		 int i=cs.executeUpdate();
		 
		 System.out.println(i + "row affected");
		 
		 cs.close();
		 con.close();
	}

}
