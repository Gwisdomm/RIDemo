package com.slcupc.Service;

import java.sql.SQLException;

import com.slcupc.Dao.UserDao;
import com.slcupc.entity.UserBean;

public class userService {
	private static UserDao dao = new UserDao();

	public static UserBean login(String username,String password) throws SQLException {
		//System.out.println("In service " + password);
		UserBean user = dao.login(username, password);
		return user;
	}

}
