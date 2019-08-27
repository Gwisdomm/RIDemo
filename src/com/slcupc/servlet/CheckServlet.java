package com.slcupc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slcupc.Service.userService;
import com.slcupc.entity.UserBean;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private UserBean user = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取表单数据

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		UserBean user = null;
		// UserBean user = new UserBean(username, password);
		try {
			System.out.println(username + "ceshi " + password);
			user = userService.login(username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user != null) {
			// 登录成功
			System.out.println("user not null");
			// session.getServletContext()得到时application对象
			ServletContext application = session.getServletContext();
			Map<String, String> loginMap = (Map<String, String>) application.getAttribute("loginMap");

			if (loginMap == null) {
				loginMap = new HashMap<>();
			}

			for (String key : loginMap.keySet()) {
				if (user.getUsername().equals(key)) {
					if (session.getId().equals(loginMap.get(key))) {
						System.out.println(username + "在同一地点多次登录！");
					} else {
						System.out.println(username + "异地登录被拒绝！");
						session.setAttribute("tip", "该用户已经异地登录！");
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}
				}
			}
			loginMap.put(user.getUsername(), session.getId());
			application.setAttribute("loginMap", loginMap);
			session.setAttribute("username", user.getUsername());
			System.out.println("登录成功！");
			resp.sendRedirect("index.jsp");
		}

		else {
			// 登录失败
			System.out.println("user is null");
			session.setAttribute("tip", "登录失败！");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
