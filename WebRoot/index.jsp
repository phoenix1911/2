<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 
		<table align="center" width="450">		
			<tr>
			    <td align="center" colspan="2">
			    <br>
			        <a href="courierfindall">管理派件员信息</a>
			    </td>
			</tr>
			<tr>
			    <td align="center" colspan="2">
			    <br>
			        <a href="receiverfindall">管理收件人信息</a>
			    </td>
			</tr>

			<tr>
			    <td align="center" colspan="2">
			    <br>
			       <p> <a href="goodfindall">管理快件信息</a></p>
			    </td>
			</tr> 
		</table>
	
	
  </body>
</html>
