package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		getListTest();
	}

	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(String title, int price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);

		new BookDao().insert(vo);

		getListTest();
	}
}
