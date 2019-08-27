package com.slcupc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slcupc.Dao.UserDao;
import com.slcupc.util.MD5;

/**
 * Servlet implementation class RegistServlets
 */
@WebServlet("/RegistServlets")
public class RegistServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("success");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 得到表单输入的内容
		String username = request.getParameter("username");
		String password = MD5.getMD5(request.getParameter("password"));
		String rpsw = MD5.getMD5(request.getParameter("rpsw"));
		// String psw =new UserDao().findUsername(username);
		// 逻辑
		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("msg", "帐号不能为空");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		/*
		 * if(psw.equals(username)) { request.setAttribute("msg", "用户名已经存在");
		 * request.getRequestDispatcher("/register.jsp").forward(request, response);
		 * return; }
		 */
		if (password == null || password.trim().isEmpty()) {
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (!password.equals(rpsw)) {
			request.setAttribute("msg", "两次输入的密码不同");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		// dao类
		UserDao u = new UserDao();
		u.addUser(username, password);// 调用addUser（）方法
		request.setAttribute("msg", "注册成功");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
