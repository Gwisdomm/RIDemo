<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

<script>
	$(function() {

		$(".i-text").focus(function() {
			$(this).addClass('h-light');
		});

		$(".i-text").focusout(function() {
			$(this).removeClass('h-light');
		});

		$("#username").focus(function() {
			var username = $(this).val();
			if (username == '输入账号') {
				$(this).val('');
			}
		});

		$("#username").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入账号');
			}
		});

		$("#password").focus(function() {
			var username = $(this).val();
			if (username == '输入密码') {
				$(this).val('');
			}
		});

		$("#yzm").focus(function() {
			var username = $(this).val();
			if (username == '输入验证码') {
				$(this).val('');
			}
		});

		$("#yzm").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入验证码');
			}
		});

		$(".registerform").Validform({
			tiptype : function(msg, o, cssctl) {
				var objtip = $(".error-box");
				cssctl(objtip, o.type);
				objtip.text(msg);
			},
			ajaxPost : true
		});

	});
</script>


</head>

<body>


	<div class="header">
		<h1 class="headerLogo">
			<a title="后台管理系统" target="_blank" href="http://www.freemoban.com/"><img
				alt="logo" src="images/logo.png"></a>
		</h1>

	</div>

	<div class="banner">

		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>

				<form action="./LoginServlet" method="post">
					<div class="fm-item">
						<label for="logonId" class="form-label">账号：</label> <input
							type="text" value="" maxlength="100" name="username"
							class="i-text" datatype="s6-18">
							<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label">密码：</label> <input
							type="password" value="" maxlength="100" name="password"
							class="i-text" datatype="*6-16" nullmsg="请设置密码！">
							<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label">验证码</label><input
							type="text" name="verifycode" class="i-text yzm" maxlength="70" />
						<img src="VerifyCodeServlet" id="verify"
							onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();"></td>

							<font color="red" size="2"> ${msg1 }</font>
						<div class="ui-form-explain"></div>
					</div>

					
					<div class="fm-item">
						<label for="logonId" class="form-label"></label> <input
							type="submit" value="" tabindex="4" id="send-btn"
							class="btn-login">
							<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<a href="register.jsp"><font size="4"><i>没有账号，点击注册</i></font></a> <font
							color="red" size="2"> ${msg }</font>
					</div>

				</form>



			</div>

		</div>

		<div class="bd">
			<ul>
				<li
					style="background: url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a
					target="_blank" href="http://www.freemoban.com/"></a></li>
				<li
					style="background: url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a
					target="_blank" href="http://www.freemoban.com/"></a></li>
			</ul>
		</div>

		<div class="hd">
			<ul></ul>
		</div>
	</div>
	<script type="text/javascript">
		jQuery(".banner").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "fold",
			autoPlay : true,
			autoPage : true,
			trigger : "click"
		});
	</script>


	<div class="banner-shadow"></div>

	<div class="footer">
		<p>
			Copyright &copy; 2014.Company name All rights reserved.<a
				target="_blank" href="http://www.freemoban.com/">www.freemoban.com</a>
		</p>
	</div>

</body>
</html>
