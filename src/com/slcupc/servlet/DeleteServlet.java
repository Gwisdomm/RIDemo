package com.slcupc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slcupc.Dao.BookDao;
import com.slcupc.entity.Book;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取图书id
		int id = Integer.valueOf(request.getParameter("id"));
		Book book=new Book(id);
		BookDao dao =new BookDao();
		int row =dao.deldetBook(book);
		// 重定向到FindServlet
		System.out.println("error");
		response.sendRedirect("DeleteUpdate");
	}
}
