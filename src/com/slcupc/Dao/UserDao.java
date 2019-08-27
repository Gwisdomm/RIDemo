package com.slcupc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.slcupc.entity.UserBean;

public class UserDao {
	Connection conn = JDBCConnection.getConnection();

	public String findUsername(String username) {
		String psw = null;
		// Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from custname where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				psw = rs.getString("pwd");
			} else {
				psw = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return psw;
	}

	public void addUser(String username, String psw) {

		PreparedStatement pstmt = null;
		try {

			String sql = "insert into custname(username,pwd)values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, psw);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public UserBean login(String username, String password) throws SQLException {
		UserBean userBean = new UserBean(username,password);
		Connection conn = JDBCConnection.getConnection();
		String sql = "select * from custname where username=? and pwd=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		// int row = 0;
		// System.out.println("dao" + password);
		while (rs.next()) {
			// user.setUsername(rs.getString("username"));
			// user.setPassWord(rs.getString("password"));
			userBean.setPwd(rs.getString("pwd"));
			userBean.setUsername(rs.getString("username"));
		}

		return userBean;
	}
}