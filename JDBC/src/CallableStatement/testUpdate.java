package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;



public class testUpdate {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" ,"root","shruti5");
		CallableStatement cs=con.prepareCall("{CALL updateValue}");
		int i=cs.executeUpdate();
		System.out.println(i +"row affected ");
	}

}
