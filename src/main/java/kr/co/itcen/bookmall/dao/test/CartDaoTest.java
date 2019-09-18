package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		getListTest(1L);

	}

	public static void getListTest(Long userNo) {
		List<CartVo> list = new CartDao().getList(userNo);
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(Long userNo, Long bookNo, int amount) {
		CartVo vo = new CartVo();

		vo.setUserNo(userNo);
		vo.setBookNo(bookNo);
		vo.setAmount(amount);

		new CartDao().insert(vo);
	}

}
