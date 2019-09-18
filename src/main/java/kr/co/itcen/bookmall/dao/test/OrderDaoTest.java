package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {

		getOrderBookListTest(1L);
		getOrderListTest(2L);
	}

	public static void getOrderListTest(Long userNo) {
		List<OrderVo> list = new OrderDao().getOrderList(userNo);
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertOrderTest(OrderVo vo) {

		new OrderDao().insertOrder(vo);

		getOrderListTest(vo.getUserNo());
	}

	public static void getOrderBookListTest(Long orderNo) {
		List<OrderBookVo> list = new OrderDao().getOrderBookList(orderNo);
		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertOrderBookTest() {
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		OrderBookVo vo = new OrderBookVo(4L, 2L, 3);

		list.add(vo);

		vo = new OrderBookVo(4L, 1L, 4);

		list.add(vo);
		new OrderDao().insertOrderBook(list);

		getOrderBookListTest(4L);

	}
}
