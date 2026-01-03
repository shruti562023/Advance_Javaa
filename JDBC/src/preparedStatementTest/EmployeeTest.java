package preparedStatementTest;

public class EmployeeTest {
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		
		//testLogin();
		testPK();
	}
	
	public static void testAdd() throws Exception {
		
		EmployeeModel model=new EmployeeModel();
		EmployeeBean bean=new EmployeeBean();
		
		bean.setId(4);
		bean.setName("Darsh");
		bean.setSalary(40000);
		bean.setDepartment("QA");
		
	model.add(bean);
	}

	
	
	public static void testUpdate() throws Exception {
		EmployeeModel model=new EmployeeModel();
		EmployeeBean bean=new EmployeeBean();
		
		
		bean.setSalary(1200000);
		bean.setDepartment("IT");
		bean.setId(4);
		
		model.update(bean);
	}
	
	
	public static void testDelete() throws Exception {
		
		EmployeeModel model =new EmployeeModel();
		EmployeeBean bean =new EmployeeBean();
		bean.setId(3);
		model.delete(bean);
	}
	
	public static void testLogin() throws Exception {
		
		EmployeeModel model=new EmployeeModel();
		EmployeeBean bean=new EmployeeBean();
		bean=model.findByName("Shruti");
		if(bean==null) {
			System.out.println("user not found");
		}
		
		else {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getSalary());
			System.out.println(bean.getDepartment());
			
		}
		
		
	}
	
	public static void testPK() throws Exception {
		
		EmployeeModel model =new EmployeeModel();
		EmployeeBean bean = new EmployeeBean();
		bean=model.findByPK(4);
		
	
		
		if(bean==null) {
			
	          System.out.println("user not found");
		}
		
		else {

			System.out.println(bean.getId());

			System.out.println(bean.getName());

			System.out.println(bean.getSalary());
			System.out.println(bean.getDepartment());
		}
	}
	
}
