package preparedStatement;

public class TestMarksheetModel {
public static void main(String[] args) throws Exception {
	//testAdd();
//	testUpdate();
	//testDelete();
	//testName();
	//testPk();
	
	testAuthenticate();
}


public static void testAdd() throws Exception {
	
	
	MarksheetModel model =new MarksheetModel();
	MarksheetBean bean = new MarksheetBean();
	
	
	bean.setId(4);
	bean.setRollNo(104);
	bean.setName("Sandeep");
	bean.setPhy(19);
	bean.setChem(89);
	bean.setMaths(80);
	model.add(bean);
	
	
	
	
	
}


public static void testUpdate() throws Exception {
	
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean = new MarksheetBean();
	
	bean.setPhy(89);
	bean.setChem(34);
	bean.setMaths(66);
	bean.setId(3);
	model.update(bean);
}


public static void testDelete() throws Exception {
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean =new MarksheetBean();
	
	bean.setId(4);
	
	model.delete(bean);
}

public static void testName() throws Exception {
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean =new MarksheetBean();
	
	bean=model.findByName("Shruti");
	if(bean==null) {
		System.out.println("user not found");
	}
	
	else {
		
		System.out.println(bean.getId());

		System.out.println(bean.getRollNo());

		System.out.println(bean.getName());

		System.out.println(bean.getPhy());

		System.out.println(bean.getChem());

		System.out.println(bean.getMaths());
	}
}


public static void testPk() throws Exception {
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean =new MarksheetBean();
	
	bean=model.findByPk(3);
	
	if(bean==null) {
		System.out.println("user not found");
	}
	
	else {
		
		System.out.println(bean.getId());

		System.out.println(bean.getRollNo());

		System.out.println(bean.getName());

		System.out.println(bean.getPhy());

		System.out.println(bean.getChem());

		System.out.println(bean.getMaths());
	}
	
}


public static void testAuthenticate() throws Exception {
	MarksheetModel model=new MarksheetModel();
	MarksheetBean bean =new MarksheetBean();
	
	bean=model.authenticate(102,"Varun");
	
	if(bean==null) {
		System.out.println("user not found");
	}
	
	else {
		
		System.out.println(bean.getId());

		System.out.println(bean.getRollNo());

		System.out.println(bean.getName());

		System.out.println(bean.getPhy());

		System.out.println(bean.getChem());

		System.out.println(bean.getMaths());
	}
	
}
}
