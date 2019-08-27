<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="com.slcupc.entity.Book"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>


</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			
			<li>查看单车信息</li>
			<!--  <li><a href="#">基本内容</a></li>-->
		</ul>
	</div>
	<div class="rightinfo">

		<!--<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img src="images/t01.png" /></span>添加</li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
				<li><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>


			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>

		</div>  -->
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
					<!--  <th>用户名称</th>-->
					<th>投放时间</th>
					<th>使用次数</th>
					<!--  <th>保修状态</th>-->
					<th>使用状态</th>
				
					

				</tr>
			</thead>

			<tbody>
				<%
					//获取图书集合
					List<Book> list = (List<Book>) request.getAttribute("list");
					//判断集合是否为空
					if (list == null || list.size() < 1) {
						out.print("没有数据");
					} else {
						//遍历图书集合中的数据
						for (Book book : list) {
				%>
				<tr>
					<td><input name="" type="checkbox" value="" /></td>
					<td><%=book.getId()%></td>
					<!--  <td><%=book.getName()%></td>-->
					<td><%=book.getPrice()%></td>
					<td><%=book.getBookCount()%></td>
					<!--  <td><%=book.getAuthor()%></td>-->
					<td><%=book.getCategory()%></td>
					
				</tr>

				<%
					}
					}
				%>
			</tbody>

		</table>


		<div class="pagin">
			<div class="message">
				共<i class="blue">5</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						class="pagepre"></span></a></li>
				
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>




	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
