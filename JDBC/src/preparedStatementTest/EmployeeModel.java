package preparedStatementTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeModel {
	
	
	ResourceBundle rs= ResourceBundle.getBundle("preparedStatementTest.employee");
	
	String driver=rs.getString("driver");
	String url=rs.getString("url");
	String username=rs.getString("username");
	String password=rs.getString("password");
	//String prepare=rs.getString("prepare");
	//String close=rs.getString("close");
	
	public void add(EmployeeBean bean) throws Exception {
		
		
	Class.forName(driver);
	Connection con=DriverManager.getConnection(url,username,password);
PreparedStatement ps=con.prepareStatement("insert into st_employee values(?,?,?,?)");
ps.setInt(1, bean.getId());
ps.setString(2, bean.getName());
ps.setInt(3, bean.getSalary());
ps.setString(4, bean.getDepartment());

int i =ps.executeUpdate();
System.out.println(i + " row affected");

con.close();
ps.close();
		
	}
	
	
	public void update(EmployeeBean bean) throws Exception {
     
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		
PreparedStatement ps=con.prepareStatement("update st_employee set salary= ? , department=? where id=?");

ps.setInt(1, bean.getSalary());
	ps.setString(2, bean.getDepartment());	
	ps.setInt(3, bean.getId());
	
	int  i=ps.executeUpdate();
	System.out.println(i +"row affected");
	
	con.close();
	ps.close();
	
	
		
}
	
	public void delete(EmployeeBean bean) throws Exception {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username , password);
		PreparedStatement ps=con.prepareStatement("delete from st_employee where id=?");
		ps.setInt(1, bean.getId());
		int i=ps.executeUpdate();
		System.out.println(i +" row affected");
		con.close();
		ps.close();
	}
	
	//name
	
	public EmployeeBean findByName(String name) throws Exception {
		Class.forName(driver);	
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement ps=con.prepareStatement("select * from st_employee where name=?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		EmployeeBean bean=null;
		while(rs.next()) {
			bean=new EmployeeBean();
bean.setId(rs.getInt(1));
bean.setName(rs.getString(2));
bean.setSalary(rs.getInt(3));
bean.setDepartment(rs.getString(4));
		}
		
		return bean;
	}
	
	//pk
	
	public EmployeeBean findByPK(int id) throws Exception {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement ps= con.prepareStatement("select * from st_employee where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		EmployeeBean bean=null;
		while(rs.next()) {
			bean=new EmployeeBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSalary(rs.getInt(3));
			bean.setDepartment(rs.getString(4));
		}
		return bean;
		
		
		
		
		
	}

}