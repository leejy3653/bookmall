package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {
	public static void main(String[] args) {
		getListTest();

	}

	public static void getListTest() {
		List<UserVo> list = new UserDao().getList();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(String name, String passwd, String phone, String email) {
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setPhone(phone);
		vo.setEmail(email);

		new UserDao().insert(vo);

		getListTest();
	}
}
