package transactionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testHandling {
	
public static void main(String[] args) throws Exception {
	Connection con=null;
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices" ,"root" ,"shruti5");
	
	con.setAutoCommit(false);
	Statement st=con.createStatement();
	

	int i = st.executeUpdate(
			"insert into st_user values(7, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-01')");

	i = st.executeUpdate(
			"insert into st_user values(8, 'Suresh', 'Yadav', 'suresh@gmail.com', 'sur', '2001-01-01')");
         
	i = st.executeUpdate(
			"insert into st_user values(9, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-03')");
	
	
	
	con.commit();
	System.out.println("transaction coplited");
	
	
	
	con.close();
st.close();
	}
	
	catch(Exception e) {
	
	con.rollback();
	e.printStackTrace();
	}
	
}

}
