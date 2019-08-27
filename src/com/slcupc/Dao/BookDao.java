package com.slcupc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slcupc.entity.Book;

public class BookDao {
	//初始化statement对象
	Connection conn = JDBCConnection.getConnection();
	//初始化prepareStatement对象
	PreparedStatement ps=null;
	public int addBook(Book book) {
		int row=0;
		try {
			String sql = "insert into book_test(category,id,name,price,bookCount,author)values(?,?,?,?,?,?)";
			// 初始化preparestatemnet对象
			PreparedStatement ps = conn.prepareStatement(sql);
			//添加图书类别
			ps.setString(1, book.getCategory());
			//添加图书编号
			ps.setInt(2, book.getId());
			//添加图书名称
			ps.setString(3, book.getName());
			//添加图书价格
			ps.setDouble(4, book.getPrice());
		
			//添加图书数量
			ps.setInt(5, book.getBookCount());
			//添加作者
			ps.setString(6,book.getAuthor());
			//得到数量
			row=ps.executeUpdate();
			//关闭资源
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public int deldetBook(Book book) {
		int row =0;
		try {
			//删除图书信息的sql语句
			String sql="delete from book_test where id=?";
			//初始化ps对象
			ps=conn.prepareStatement(sql);
			//对sql语句中的第一个占位符赋值
			ps.setInt(1,book.getId());
			//执行更新操作
			row=ps.executeUpdate();
			//关闭资源
			ps.close();
			//关闭conn连接
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	/*
	public int findBook(Book book) {
		//int row=0;
		try {
			Statement stmt=conn.createStatement();
			
			
			String sql = "select * from book_test";
			ResultSet rs=stmt.executeQuery(sql);
			List<Book> list=new ArrayList<Book>();
			while(rs.next()) {
				//Book book=new Book();
				book.setId(rs.getInt("id"));
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
		}
		return  list;
	}*/
	
			
}
