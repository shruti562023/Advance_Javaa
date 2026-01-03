package preparedStatementTest;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class MainUser {
	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();

		// testDelete();
		// testLogin();

		// testPK();

		// testAuthenicate();
		testSearch();
	}

	public static void testAdd() throws ParseException, ClassNotFoundException, SQLException {

		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(6);
		bean.setFirstName("Yashwant");
		bean.setLastName("Maru");
		bean.setLogin("Yashwant@gmail.com");
		bean.setPassword("yashwant27");
		bean.setDob(s.parse("2001-08-27"));

		model.add(bean);

	}

	public static void testUpdate() throws ClassNotFoundException, SQLException {

		SimpleDateFormat sd = new SimpleDateFormat();

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Semi");
		bean.setLastName("Rathore");
		bean.setId(6);
		model.update(bean);

	}

	public static void testDelete() throws ClassNotFoundException, Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(3);

		model.delete(bean);

	}

	public static void testLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("shruti@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());

			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());

			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}
	}

	public static void testPK() throws SQLException, Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean = model.findByPK(4);

		if (bean == null) {
			System.out.println("user not find");
		}

		else {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testAuthenicate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenicate("Yashwant@gmail.com", "yashwant27");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testSearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		//bean.setFirstName("s");
		bean.setLastName("d");
		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

			System.out.println("-----------------------------");

		}

	}

}
