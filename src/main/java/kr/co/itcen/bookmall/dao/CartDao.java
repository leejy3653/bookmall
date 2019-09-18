package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {

	public Boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getUserNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getAmount());

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

	public List<CartVo> getList(Long userNo) {
		List<CartVo> result = new ArrayList<CartVo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		try {

			conn = getConnection();
			String sql = "select b.title, c.amount, b.price * c.amount as price \n" + "from book b, cart c, user m\n"
					+ "where c.user_no = m.no\n" + "and c.book_no = b.no\n" + "and m.no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String bookTitle = rs.getString(1);
				int amount = rs.getInt(2);
				int price = rs.getInt(3);

				CartVo vo = new CartVo();
				vo.setBookTitle(bookTitle);
				vo.setAmount(amount);
				vo.setPrice(price);

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
