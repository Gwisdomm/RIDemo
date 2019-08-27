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

import com.slcupc.Dao.UserDao;
import com.slcupc.Service.userService;
import com.slcupc.entity.UserBean;
import com.slcupc.util.MD5;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = MD5.getMD5(request.getParameter("password"));
		String checkcode = request.getParameter("checkCode");
		String psw = new UserDao().findUsername(username);
		
		
		String verifyc = request.getParameter("verifycode");
		String svc = (String) request.getSession().getAttribute("sessionverify");
		System.out.println(username);
		System.out.println(password);
		HttpSession session = request.getSession();
		UserBean user = null;
		try {
			System.out.print("初始化user");
			user = userService.login(username, password);

		} catch (SQLException e) {
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
						//alret.()
						session.setAttribute("tip", "该用户已经异地登录！");
						System.out.println("<script>alert(\"该用户已经异地登录\");</script>");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
			}
			
			if (!svc.equalsIgnoreCase(verifyc)) {
				request.setAttribute("msg", "验证码错误！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			if (psw == null) {
				// 设置属性变量
				request.setAttribute("msg", "没有这个用户！");
				// 转发页面
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			if (psw != null && !psw.equals(password)) {
				request.setAttribute("msg", "密码错误请重新输入！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			/*
			if (checkcode.equals("") || checkcode == null) {
				request.setAttribute("msg", "请输入验证码");
			}*/
			if (psw.equals(password)) {
				loginMap.put(user.getUsername(), session.getId());
				application.setAttribute("loginMap", loginMap);
				session.setAttribute("username", user.getUsername());
				System.out.println("登录成功！");
				request.setAttribute("msg", "用户：" + username + ",欢迎访问");
				request.getRequestDispatcher("/list.jsp").forward(request, response);
				// response.setHeader("Refresh","1;url=welcome.jsp");
			}
			/*
			 * loginMap.put(user.getUsername(), session.getId());
			 * application.setAttribute("loginMap", loginMap);
			 * session.setAttribute("username", user.getUsername());
			 * System.out.println("登录成功！"); //response.sendRedirect("index.jsp");
			 * 
			 */
		}

		else {
			// 登录失败
			System.out.println("user is null");
			session.setAttribute("tip", "登录失败！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}
