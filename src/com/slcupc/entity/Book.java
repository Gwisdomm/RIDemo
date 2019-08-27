package com.slcupc.entity;

public class Book {
	
	private int bookid;// 图书主键
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private int id;// id
	private String name;// 书名
	private double price;// 价格
	private int bookCount;// 数量
	private String author;// 作者
	private String category;// 图书类别


	public Book() {

	}

	public Book(int id) {
		this.id = id;
	}

	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(int id, String name, double price) {
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public Book(int id, String name, double price, int bookCount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.bookCount = bookCount;

	}

	public Book(int id, String name, double price, int bookCount, String author) {
		this.name = name;
		this.price = price;
		this.bookCount = bookCount;
		this.author = author;
	}

	public Book(int id, String name, double price, int bookCount, String author, String category) {
		this.name = name;
		this.price = price;
		this.bookCount = bookCount;
		this.author = author;
		this.category = category;
		this.id = id;

	}

	public Book(int id, String name, double price, int bookCount, String author, String category, int bookid) {
		this.bookid = bookid;
		this.name = name;
		this.price = price;
		this.bookCount = bookCount;
		this.category = category;
		this.id = id;
	}

}
