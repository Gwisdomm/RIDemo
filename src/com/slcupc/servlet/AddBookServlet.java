package com.slcupc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slcupc.Dao.BookDao;
import com.slcupc.Dao.JDBCConnection;
import com.slcupc.entity.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// Connection conn = JDBCConnection.getConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集
		response.setCharacterEncoding("UTF-8");
		//
		request.setCharacterEncoding("UTF-8");
		//初始化id
		String id =request.getParameter("id");
		// 初始化name属性
		String name = request.getParameter("name");
		// 初始化price属性
		String price = request.getParameter("price");
		// 初始化bookCount属性
		String bookCount = request.getParameter("bookCount");
		// 初始化author属性
		String author = request.getParameter("author");
		//初始化category属性
		
		String category=request.getParameter("category");
		// 初始化Book实体
		Book book = new Book(Integer.parseInt(id), name,Double.parseDouble(price), Integer.parseInt(bookCount), author);
		// 实例化dao类

		BookDao dao = new BookDao();
		int row = dao.addBook(book);
		if (row > 0) {
			System.out.print("sucess" + row + "data");
		}

	}

}
