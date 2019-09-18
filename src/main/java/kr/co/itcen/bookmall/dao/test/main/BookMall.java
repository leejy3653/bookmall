package kr.co.itcen.bookmall.dao.test.main;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.UserVo;
import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class BookMall {
	public static void main(String[] args) {

		insert();

		print();

	}

	public static void insert() {
		BookDao bookDao = new BookDao();
		CartDao cartDao = new CartDao();
		CategoryDao categoryDao = new CategoryDao();
		UserDao userDao = new UserDao();
		OrderDao orderDao = new OrderDao();

		userDao.insert(new UserVo("이종윤", "1513", "010-5464-1513", "leejy3653@naver.com"));
		userDao.insert(new UserVo("권형근", "1234", "010-1234-5678", "rnjsgudrms@naver.com"));

		categoryDao.insert(new CategoryVo("경제"));
		categoryDao.insert(new CategoryVo("소설"));
		categoryDao.insert(new CategoryVo("예술"));

		bookDao.insert(new BookVo("경제학개론", 12000, 1L));
		bookDao.insert(new BookVo("해리포터", 21500, 2L));
		bookDao.insert(new BookVo("그림 모음전", 30000, 3L));

		cartDao.insert(new CartVo(1L, 1L, 2));
		cartDao.insert(new CartVo(1L, 3L, 5));

		orderDao.insertOrder(new OrderVo(1L, 80000, "서울시 송파구 장지동 위례송파푸르지오APT"));

		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		list.add(new OrderBookVo(1L, 2L, 3));
		list.add(new OrderBookVo(1L, 3L, 1));
		orderDao.insertOrderBook(list);
		System.out.println("book, cart, category,user, order 데이터 insert 완료!!");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===============================리스트 출력===============================");
		System.out.println();
		System.out.println();

	}

	public static void print() {
		BookDao bookDao = new BookDao();
		CartDao cartDao = new CartDao();
		CategoryDao categoryDao = new CategoryDao();
		UserDao userDao = new UserDao();
		OrderDao orderDao = new OrderDao();

		List<UserVo> userList = userDao.getList();

		System.out.println("-------------------고객 리스트-------------------");
		for (UserVo vo : userList) {
			System.out.println("고객 [이름 : " + vo.getName() + ", 전화번호 : " + vo.getPhone() + ", 이메일 : " + vo.getEmail()
					+ ", 비밀번호 : " + vo.getPasswd() + "]");
		}
		System.out.println();

		List<CategoryVo> categoryList = categoryDao.getList();
		System.out.println("-------------------카테고리 리스트-----------------------");
		for (CategoryVo vo : categoryList) {
			System.out.println("카테고리 [1차 카테고리 : " + vo.getName() + "]");
		}
		System.out.println();

		List<BookVo> bookList = bookDao.getList();
		System.out.println("-------------------도서 리스트 -------------------");
		for (BookVo vo : bookList) {
			System.out.println("서적 [제목 : " + vo.getTitle() + ", 가격 : " + vo.getPrice() + "원]");
		}
		System.out.println();

		List<CartVo> cartList = cartDao.getList(1L);

		System.out.println("-------------------카트 리스트 -------------------");
		for (CartVo vo : cartList) {
			System.out.println("카트 [도서 제목 : " + vo.getBookTitle() + ", 수량 : " + vo.getAmount() + "개, 가격 : "
					+ vo.getPrice() + "원]");
		}
		System.out.println();

		List<OrderVo> orderList = orderDao.getOrderList(1L);

		System.out.println("-------------------주문 리스트-------------------");
		for (OrderVo vo : orderList) {
			System.out.println("주문 리스트 [주문 번호 :" + vo.getNo() + ", 주문자(이름 : " + vo.getUserName() + "/ 이메일 : "
					+ vo.getUserEmail() + "), 결제금액 : " + vo.getPrice() + "원, 배송지 : " + vo.getAddress() + "]");
		}
		System.out.println();

		List<OrderBookVo> orderBookList = orderDao.getOrderBookList(1L);

		System.out.println("-------------------주문 도서 리스트-------------------");
		for (OrderBookVo vo : orderBookList) {
			System.out.println("주문도서 [도서번호 :" + vo.getBookNo() + ", 도서제목 : " + vo.getBookTitle() + ", 수량 : "
					+ vo.getAmount() + "개]");
		}
		System.out.println();

	}
}
