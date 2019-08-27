package com.slcupc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String encoding = config.getInitParameter("encoding");
		if (null == encoding) {
			request.setCharacterEncoding("UTF-8");
		} else {
			request.setCharacterEncoding(encoding);
		}
		String username = (String) request.getSession().getAttribute("username");

		String exceptPage = config.getInitParameter("exceptPage");
		if (null != exceptPage && !"".equals(exceptPage.trim())) {
			String[] exceptPages = exceptPage.split(";");
			for (String except : exceptPages) {
				if (request.getRequestURI().indexOf(except) != -1) {
					arg2.doFilter(arg0, arg1);
					return;
				}

			}
		}

		if (null != username) {
			arg2.doFilter(arg0, arg1);
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}
