<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>用户管理员</title>
<link type="text/css" rel="stylesheet" href="fontsawesome/css/font-awesome.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="header">
	<div class="logo">
		<a href="Javascript:void(0)"><img src="images/logo.png"/></a>
	</div>
	<div class="nav">
		<ul class="clearfix">
			<li class="curr">
				<i class="fa fa-user font_lager"></i>
				<p data-fast="show_lmz.do">用户列表</p>
			</li>

		</ul>
	</div>
	<ul class="login_msg">
    <li>欢迎您：${u.user_loginName } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href = "login.jsp">退出</a>
      
	</ul>
</div>

<!--left end-->
<div class="main_right">
	<div class="loading">
		<div class="spinner">
			<div class="rect1"></div>
			<div class="rect2"></div>
			<div class="rect3"></div>
			<div class="rect4"></div>
			<div class="rect5"></div>
		</div>
		<p>加载中，请稍后</p>
	</div>
	<iframe src="show_lmz.do" name="cont_box" frameborder="0" id="iframe-id" width="100%" height="100%" seamless></iframe>
</div>
<!--desktop end-->
<!--javascript include-->
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/tipSuppliers_y.js" type="text/javascript" charset="utf-8"></script>
<script>
	moreMenu()//显示子菜单
	function moreMenu(){
		var t = null ;
		var $_this = "";
		$(".nav >ul >li").mouseover(function(){
			$_this= $(this);
			$_this.children('ul').show();
			$_this.siblings().children('ul').hide();
			clearTimeout(t);
		})
		$(".nav >ul >li").mouseleave(function(){
			$_this.children('ul').show();
		 	t =setTimeout(function(){
			$_this.children('ul').hide();
		},1000);

		});

	}
	$(".nav >ul >li >ul >li >a").click(function() {
		$(this).parent().parent().parent().addClass('curr');
		$(this).parent().parent().parent().siblings().removeClass('curr')
		$(this).parent().addClass('action');
		$(this).parent().siblings().removeClass("action");
		var getThisHref = $(this).attr("href");
		$("iframe[name='cont_box']").attr("src",getThisHref)
	});
	$("iframe[name='cont_box']").on("load",function(){
		$(".loading").hide();
		setTimeout(function(){$("iframe[name='cont_box']").css("opacity","1");},1000);
	});
	$(function(){
		$(".loading").hide();
		setTimeout(function(){$("iframe[name='cont_box']").css("opacity","1");},1000);
		$(".nav li:first").trigger("click");
	});
	jQuery("body").jrdek({Mtop:".header",Mleft:".main_left",Mright:".main_right",foldCell:".main_left h2"});
// 	$(".logo").click(function(){
// 		$("iframe[name='cont_box']").prop("src","firstPage.html");
// 	});
</script>
</body>
</html>
