package com.slcupc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slcupc.Dao.JDBCConnection;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		int bookCount = Integer.valueOf(request.getParameter("bookCount")); 
		Connection conn=JDBCConnection.getConnection();
		try {
			//sql添加语句
			String sql = "update book_test set bookcount=? where id=?";
			//初始化 statemen"对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 修改第一个字段ֵ
			ps.setInt(1, bookCount);
			//ڶ���������ֵ修改第二个字段
			ps.setInt(2, id);
			// ִ 得到结果
			ps.executeUpdate();
			// 关闭资源
			ps.close();
			// 关闭conn连接
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//转发到FindServlet
		response.sendRedirect("FindServlet");
	}
}
