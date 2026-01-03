package resourcBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

public class testBundle {

	
	public static void main(String[] args) throws Exception {
		
		
	ResourceBundle rb=ResourceBundle.getBundle("resourcBundle.app");
	
	String driver=rb.getString("driver");
	String url=rb.getString("url");
		String username=rb.getString("username");
		String password=rb.getString("password");
	

		System.out.println(driver + "\n" + url + "\n" + username + "\n" + password);
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username , password);
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from st_marksheet");
		
	while(rs.next()) {
		
		
		System.out.println(rs.getInt(1));
		System.out.println(rs.getInt(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getInt(4));
		System.out.println(rs.getInt(5));	
		System.out.println(rs.getInt(6));
		System.out.println("------------------------");
		
		
	}
	
	
	ResourceBundle rs1=ResourceBundle.getBundle("resourcBundle.Hello",new Locale("hi"));
	System.out.println(rs1.getString("greeting"));
		
	
	ResourceBundle rs2=ResourceBundle.getBundle("resourcBundle.Hii",new Locale("sp"));
	System.out.println(rs2.getString("greeting"));
	}
}
