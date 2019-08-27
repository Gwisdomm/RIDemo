package com.slcupc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slcupc.Dao.JDBCConnection;
import com.slcupc.entity.Book;

/**
 * Servlet implementation class DeleteUpdate
 */
@WebServlet("/DeleteUpdate")
public class DeleteUpdate extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = JDBCConnection.getConnection();

		try {
			//实例化Statement对象
			Statement stmt = conn.createStatement();
			// SQL语句
			String sql = "select * from book_test";
			//实例化数据库结果集ִ
			ResultSet rs = stmt.executeQuery(sql);
			//初始化
			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				//实体的初始化
				Book book=new Book();
				//拿到id
				book.setId(rs.getInt("id"));
				// 拿到name属性ֵ
				book.setName(rs.getString("name"));
				//拿到price
				book.setPrice(rs.getDouble("price")); 
				//拿到bookcountֵ
				book.setBookCount(rs.getInt("bookCount"));
				//拿到authorֵ
				book.setAuthor(rs.getString("author"));
				// book对象添加到list中
				list.add(book);
			}
			//传递list对象
			request.setAttribute("list", list);
			rs.close(); // 关闭rs对象
			stmt.close(); // 关闭statement
			conn.close(); // 关闭connection连接

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 重定向到这个页面
		request.getRequestDispatcher("Delete.jsp").forward(request, response);
	}

}
