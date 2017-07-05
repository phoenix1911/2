<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>快递管理系统Login</title>

  
  
<link media="all" href="login/index.css" type="text/css" rel="stylesheet">
</head>
<body>

    <div class="container">

      <form class="form-signin" action="login.do" method="post">
        <h2 class="form-signin-heading">登陆</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
       
       
       
       <input type="text" id="username" class="form-control" name="username" placeholder="请输入用户名">
       
       
       
       <label for="inputPassword" class="sr-only">Password</label>
       <input type="password" id="password" class="form-control" name="password" placeholder="Password" required=""> 
        <div class="checkbox">
          <label>
            <input value="remember-me" type="checkbox"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <font color="red">${error}</font>
      </form>

    </div> 

</body>
</html>
