<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.slcupc.entity.Book"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(form){
		with(form){
			if(name.value == ""){ 
				alert("图书名称不能为空");
				return false;
			}
			if(price.value == ""){
				alert("价格不能为空");
				return false;
			}
			if(author.value == ""){
				alert("作者不能为空");
				return false;
			}
			return true;
		}
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="list.jsp">首页</a></li>
			<li><a href="right.jsp">添加图书信息</a></li>
			<!--  <li><a href="#">基本内容</a></li>-->
		</ul>
	</div>
	<form action="AddBookServlet" method="get">
		<table align="center" width="450">
			<tr>
				<td align="center" colspan="2">
					<h2>添加图书信息</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">图书类别：</td>
				<td><input type="text" name="category" /></td>
			</tr>
			<tr>
				<td align="right">图书编号：</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td align="right">图书名称：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="right">图书价格：</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td align="right">图书数量：</td>
				<td><input type="text" name="bookCount" /></td>
			</tr>
			<tr>
				<td align="right">作 者：</td>
				<td><input type="text" name="author" /></td>
			</tr>
			
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添　加"></td>
			</tr>
		</table>
	</form>


</body>
</html>
