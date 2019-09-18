package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderBookVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {

	public Boolean insertOrderBook(List<OrderBookVo> list) {
		boolean result = false;
		Connection conn = null;
		int count = 0;

		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			String sql = "insert into orders_book values(?, ?, ?)";

			for (OrderBookVo vo : list) {
				pstmt = conn.prepareStatement(sql);

				pstmt.setLong(1, vo.getOrderNo());
				pstmt.setLong(2, vo.getBookNo());
				pstmt.setInt(3, vo.getAmount());

				count = pstmt.executeUpdate();
			}
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean insertOrder(OrderVo vo) {
		boolean result = false;
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			String sql = "insert into orders values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getUserNo());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getAddress());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<OrderBookVo> getOrderBookList(Long orderNo) {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		try {

			conn = getConnection();
			String sql = "select b.no, b.title, ob.count " + "from book b, orders_book ob " + "where b.no = ob.book_no "
					+ "and ob.order_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long bookNo = rs.getLong(1);
				String bookTitle = rs.getString(2);
				int amount = rs.getInt(3);
				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(bookNo);
				vo.setBookTitle(bookTitle);
				vo.setAmount(amount);

				result.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return result;
	}

	public List<OrderVo> getOrderList(Long userNo) {
		List<OrderVo> result = new ArrayList<OrderVo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		try {

			conn = getConnection();
			String sql = "select o.no, m.name, m.email, o.price, o.address " + "from orders o, user m "
					+ "where o.user_no = m.no " + "and m.no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String userName = rs.getString(2);
				String userEmail = rs.getString(3);
				int price = rs.getInt(4);
				String address = rs.getString(5);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setUserName(userName);
				vo.setUserEmail(userEmail);
				vo.setPrice(price);
				vo.setAddress(address);

				result.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {

			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.19:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}

		return conn;

	}
}
