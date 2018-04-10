<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/WEB-INF/myTag.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <title>招聘岗位管理</title>
    <link type="text/css" rel="stylesheet" href="fontsawesome/css/font-awesome.css" />
    <link type="text/css" rel="stylesheet" href="css/paging.css" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <style type="text/css">
    body {
        background: #fff;
        overflow-y: scroll;
    }
    </style>
</head>
    <script type="text/javascript">
  function deluserById(id){
  	if(confirm("是否删除该用户")){
   	$.post("delUserInfo_lmz.do",{user_id:id},function(data){
    	if(data==1){
	    	alert("删除成功");
	    	window.location.href="show_lmz.do";
    	}
   	})
  	}
  }
  
 /*  function find(){
  
  var uname=document.getElementById("name").value
  alert(55555555555);
  window.location.href="find_lmz.do?user_name="+uname;
  
  } */
    </script>
<body>
    <!--企业管理首页-->
    <form action="show_lmz.do" method="post">
    <div class="recruitListbox w1200" >
        <div class="menushow">
            <span>当前页面：</span>
            <a href="show_lmz.do" title="">用户列表</a>
        </div>
        <div class="searchbox">
            <label>用户名</label>
            <input type="text" id="name" name="user_name" value="${user_name }">
            <input type="submit" name=""  value="搜索">
          
        </div>
        <p class="addBox"><a href="findType_lmz.do">新增用户</a></p>
             
         <div class="tableBox">
         <table cellspacing="0">
                <thead>                                     
                <tr>
                   <th>用户名</th>
                   <th>登录名</th>
                   <th>密码</th>
                   <th>用户类型</th>
				   <th>操作</th>
                </tr>
               </thead> 
<!--                 forEach整体循环用户 -->
<!--  循环lmz赋给变量a -->
				   <c:forEach var="a" items="${lmz }">
<!--  直接a打点调用  -->
						<tr align="center">
							<td>${a.user_name }</td>
							<td>${a.user_loginName }</td>
							<td>${a.user_password }</td>
							<c:forEach items="${a.list }" var="r">
								<td>${r.rolename }</td>
							</c:forEach>
														
							<td colgroup="2"><a href="update_lmz.do?user_id=${a.user_id}" title="">编辑</a>
							<a href="javascript:void(0)" title="" onclick="deluserById(${a.user_id})">删除</a></td>						   
						</tr>						
	 			  </c:forEach>	 
	 			  
             </table>			   
        </div>
     <div id="paging">
				<t:page url="show_lmz.do?user_name=${user_name }" page="${p}" />
	</div>
     </div>
      
    <!--javascript include-->
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="js/tipSuppliers.js"></script>

    </from>   
</body>

</html>
