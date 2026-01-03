package preparedStatementTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	
	//insert
	public void add(MarksheetBean bean) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		
		
		
		PreparedStatement ps=con.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");
		
		
		ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getRollNo());
		ps.setString(3,bean.getName());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChem());
		ps.setInt(6, bean.getMaths());
		
		
		int i=ps.executeUpdate();
		System.out.println(i + "row affected");
		con.close();
		ps.close();
		
		
		
		
		
	}
	
	
	
	//update
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		
		PreparedStatement ps=con.prepareStatement("update st_marksheet set phy=? , chem=? , maths=? where id=?");
		
		ps.setInt(1, bean.getPhy());
		ps.setInt(2, bean.getChem());
		ps.setInt(3, bean.getMaths());
		ps.setInt(4, bean.getId());
		
		
		int i= ps.executeUpdate();
		System.out.println(i + " row affected");
	ps.close();
	con.close();
		
		
		
		
	}
	
	//delete 
	
	public void delete(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		PreparedStatement ps=con.prepareStatement("delete from st_marksheet where id =?");
		
		
		ps.setInt(1, bean.getId());
		
		int i=ps.executeUpdate();
		
		System.out.println(i);
		con.close();
		ps.close();
		
	}
	//find by name
	
	public MarksheetBean findByName(String name) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		PreparedStatement ps=con.prepareStatement("select * from st_marksheet where name=?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		MarksheetBean bean=null;
		while(rs.next()){
			
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
		bean.setPhy(rs.getInt(4));
		bean.setChem(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
			
		}
		return bean;
		
	}
	
	//find by primary key
	
	public MarksheetBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		PreparedStatement ps=con.prepareStatement("select * from st_marksheet where id=?");	
		
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		MarksheetBean bean= null;
		
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
	}
	
	
	public MarksheetBean authenticate(int rollNo , String name) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","shruti5");
		PreparedStatement ps=con.prepareStatement("select * from st_marksheet where rollNo=? and name= ?");	
		
		ps.setInt(1, rollNo);
		ps.setString(2, name);
		
		ResultSet rs=ps.executeQuery();
		
		MarksheetBean bean =null;
		
		while(rs.next()) {
		bean=new MarksheetBean();
		
		bean.setId(rs.getInt(1));
		bean.setRollNo(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setPhy(rs.getInt(4));
		bean.setChem(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
		}
		
		return bean;
		
	}
	
	
	public List search(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root","shruti5");
		
		StringBuffer sql=new StringBuffer("select * from st_marksheet where 2=2");
		
		if(bean!=null) {
			if(bean.getRollNo()!= 0 ) {
				sql.append(" and RollNo like '" +bean.getRollNo() + "%'"); 
			}
			
		}
		
		System.out.println("sql==>" +sql.toString());
		PreparedStatement ps=con.prepareStatement(sql.toString());
		
		ResultSet rs=ps.executeQuery();
		
		List list=new ArrayList();
		
		while (rs.next()) {
			bean=new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
			
			
		}
		return list;
	}

}
