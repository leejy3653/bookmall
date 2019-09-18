package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserVo;

public class UserDao {

	public Boolean insert(UserVo vo) {
		boolean result = false;
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {

			conn = getConnection();

			String sql = "insert into user values(null, ?, PASSWORD(?), ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());

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

	public List<UserVo> getList() {
		List<UserVo> result = new ArrayList<UserVo>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		try {

			conn = getConnection();
			String sql = "select no, name, passwd, phone, email from user " + "order by no asc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String passwd = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);

				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPasswd(passwd);
				vo.setPhone(phone);
				vo.setEmail(email);
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
