<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>企业招聘管理</title>
<link type="text/css" rel="stylesheet"
	href="fontsawesome/css/font-awesome.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style type="text/css">
body {
	background: #fff;
	overflow-y: scroll;
}
</style>
</head>
<!-- <script type="text/javascript" >
	function istrue(){
	      if(confirm("活动创建之后将不能修改，确定创建吗？")){
 	      	  return true;
 	      	}else{
 	      	   window.location.href = "findType_lmz.do";
 	      	}
	   
 	 
	}
	
	
</script> -->
<body>
	<form action="add_lmz.do" method="post" id="tijiao"
		onsubmit="return sub()">
		<!--企业管理首页-->
		<div class="addRecitBox w1200">
			<div class="menushow">
				<span>当前页面：</span> <a href="show_lmz.do">用户列表/</a> <a>新增用户</a>
			</div>
			<div class="editBox clearfix">
				<div class="left">
					<ul>
						<li><label>用户名</label> <input type="text"
							placeholder="请输入用户名" name="username" id="username"/> <input type="hidden"
							name="user_id" value="${us.user_id }">
						</li>
						<li><label>登录名</label> <input type="text"
							placeholder="请输入登陆名" id="user_loginName" name="user_loginName"
							onblur="loginName_lmz()" /> <span id="sppp"></span>
						</li>

						<li><label>密码</label> <input type="text" placeholder="请输入密码"
							id="pwd" name="user_password" /><span id="spp"></span>
						</li>
						<input type="hidden" id="p" value="" />
						<li><label>类型</label>
							<p>
								<select name="user_type" id="choose">
									<option value="0">请选择</option>
									<c:forEach var="a" items="${list }">
										<option value="${a.id }">${a.rolename }</option>
									</c:forEach>
								</select> <span id="cc"></span>
							</p>
						</li>

					</ul>
					<input type="submit" name="" class="submitClick" value="保存">


				</div>

			</div>
		</div>
		<!-- 	
		<script src="js/jquery-2.2.1.min.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/jquery.form.min.js"></script>
		<script src="js/other.js"></script> -->


		<script type="text/javascript">
			function loginName_lmz() {
               
				var user_loginName = document.getElementById("user_loginName");
				var sp = document.getElementById("sppp");
				var p = document.getElementById("p");
				if (user_loginName.value != null && user_loginName.value != "") {

					//1.创建对象
					var xhr = new XMLHttpRequest();
					//2.提交方式   以get请求方式发送
					xhr.open("get", "only_lmz.do?user_loginName="
							+ user_loginName.value, true);//true代表异步  如果是false表示同步

					//3.发送数据
					xhr.send(null);
					//4.回调函数  预状态改变
					xhr.onreadystatechange = function() {
						//5.判断状态值 获取后台传来的参数    状态值200表示成功

						if (xhr.status == 200 && xhr.readyState == 4) {
							var str = xhr.responseText;

							if ("yes" == str) {
								sp.style.color = "green";
								sp.innerHTML = "可用";
                                p.value="";
							} else if ("no" == str) {
								

								sp.style.color = "red";
								sp.innerHTML = "登录名已存在";
								p.value = 2;

							}

						}
					}
				} else {

					sp.style.color = "red";
					sp.innerHTML = "登录名不能为空";
				}
			};
		</script>
	</form>
	<script type="text/javascript">
		function sub() {
		    var username = document.getElementById("username");
			var user_loginName = document.getElementById("user_loginName");
			var pwd = document.getElementById("pwd");
			var choose = document.getElementById("choose");
			var p = document.getElementById("p");
			
			if (username.value == "") {
				alert("用户名不能为空");
				return false;
			}

			if (user_loginName.value == "") {
				alert("登录名不能为空");
				return false;
			}
			if (pwd.value == "") {
				alert("密码不能为空");
				return false;
			}
			
			if (pwd.value.length < 6) {
                alert("密码长度不能小于6");
                return false;
			}
	
			if (p.value == 2) {
				alert("登录名已存在");
				return false;
			}
			if (choose.value == 0) {
				alert("请选择用户类型");
				return false;

			}

		}
	</script>
</body>

</html>
