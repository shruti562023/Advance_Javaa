package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class testInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root" ,"shruti5");
		
		CallableStatement st=con.prepareCall("{CALL valueInsert(5,105,'semi' , 78,88,88)}");
		
		int i=st.executeUpdate();
		
		System.out.println(i + "row affected");
		
		
	}

}
