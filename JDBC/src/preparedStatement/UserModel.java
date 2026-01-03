package preparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

	public void add(UserBean bean) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practices", "root", "shruti5");

		PreparedStatement ps = con.prepareStatement("insert into st_user values(?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLogin());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = ps.executeUpdate();

		System.out.println(i + "  row affectedd");

	}
	
	
	public void update(UserBean bean) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices","root","shruti5");
		
		PreparedStatement ps=con.prepareStatement("update st_user set firstName=?, lastName=? where id=?");
		
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		
		ps.setInt(3, bean.getId());
		
		
		int i=ps.executeUpdate();
		System.out.println(i);
		ps.close();
		con.close();
		
		
		
	}
	
	public void delete(UserBean bean) throws ClassNotFoundException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices" ,"root" , "shruti5");
		
		PreparedStatement ps=con.prepareStatement("delete  from st_user where id=?");
		ps.setInt(1, bean.getId());
		int i=ps.executeUpdate();
		
		System.out.println(i +"row affected");
		
		con.close();
		ps.close();
		
		
	}
	public UserBean findByLogin(String login) throws  Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices","root","shruti5");
		PreparedStatement ps=con.prepareStatement("select * from st_user where login=?");
		
		ps.setString(1, login);
		
		ResultSet rs=ps.executeQuery();
		
		UserBean bean=null;
		
		while(rs.next()) {
			    bean=new UserBean();
			    
			    bean.setId(rs.getInt(1));
			    bean.setFirstName(rs.getString(2));
			    bean.setLastName(rs.getString(3));
			    bean.setLogin(rs.getString(4));
			    bean.setPassword(rs.getString(5));
			    bean.setDob(rs.getDate(6));
			
			
		}
		return bean;
		
		
	}

	
	
	public UserBean findByPK(int pk) throws SQLException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practices" , "root" , "shruti5");
		
		PreparedStatement ps=con.prepareStatement("select * from st_user where id=?");
		
		ps.setInt(1, pk);
		ResultSet rs=ps.executeQuery();

		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			

			
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
	
			
			
			
			
			
		}
		
		return bean;
		
		
	}
	
	public UserBean authenicate(String login ,String password) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/practices","root","shruti5");
		
		PreparedStatement st=con.prepareStatement("select * from st_user where login=? and password=?");
		
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		UserBean bean=null;
		
		while(rs.next()) {
			
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			
		}
		
		return bean;
		
	}
}
