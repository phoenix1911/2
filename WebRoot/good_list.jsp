<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  import="com.delivery.pojo.Good" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'good_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Table</title>
    <meta name="description" content="Free Admin Template Based On Twitter Bootstrap 3.x">
    <meta name="author" content="">
    <meta name="msapplication-TileColor" content="#5bc0de" />
    <meta name="msapplication-TileImage" content="assets/img/metis-tile.png" />
    <link rel="stylesheet" href="assets/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="assets/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/lib/metismenu/metisMenu.css">
    <link rel="stylesheet" href="assets/lib/onoffcanvas/onoffcanvas.css">
    <link rel="stylesheet" href="assets/lib/animate.css/animate.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

    <!--For Development Only. Not required -->
    <script>
        less = {
            env: "development",
            relativeUrls: false,
            rootpath: "/assets/"
        };
    </script>
    <link rel="stylesheet" href="assets/css/style-switcher.css">
    <link rel="stylesheet/less" type="text/css" href="assets/less/theme.less">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.7.1/less.js"></script>


  </head>
  
  <body>
  
  
  
 <div class="row">
  <div class="col-lg-12">
  <div class="box">
  <header><div class="icons"><i class="fa fa-table"></i></div><h5>管理派件信息</h5></header>
  <div id="collapse4" class="body">

   <table align="center" class="table table-bordered table-condensed table-hover table-striped">
		<tr bgcolor="white">
			<td align="center" colspan="11">
				<h2>全部派件信息</h2>
			</td>
		</tr>
		<tr align="center"  >
			 		<td><b>快件编号</b></td>
			        <td><b>快件名</b></td>
			        <td><b>收件地址</b></td>
			        <td><b>收件人名</b></td>
			        <td><b>派件员名</b></td>
			        <td><b>揽件时间</b></td>
			        <td><b>发件时间</b></td>
			        <td><b>到达时间</b></td>
			        <td><b>快件状态</b></td>
			        <td><b>删除</b></td>
			        <td><b>修改</b></td>
		</tr>
			<%
				// 获取图书信息集合
					List<Good> list = (List<Good>)request.getAttribute("list");
					// 判断集合是否有效
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						// 遍历图书集合中的数据
						for(Good good : list){
			%>
				<tr align="center" >
					<td><%=good.getGno()%></td>
					<td><%=good.getGname()%></td>
					<td><%=good.getGaddress()%></td>
					<td><%=good.getRname()%></td>
					<td><%=good.getCname()%></td>
					<td><%=good.getIntime()%></td>
					<td><%=good.getOuttime()%></td>
					<td><%=good.getEndtime()%></td>
					<td><%=good.getState()%></td>
					<td><a href="gooddelete.do?gno=<%=good.getGno()%>">删除</a></td>
					<td><a href="goodUpdate.jsp?gno=<%=good.getGno()%>&gname=<%=good.getGname()%>&gaddress=<%=good.getGaddress()%>&rname=<%=good.getRname()%>&cname=<%=good.getCname()%>&intime=<%=good.getIntime()%>&outtime=<%=good.getOuttime()%>&endtime=<%=good.getEndtime()%>&state=<%=good.getState()%>">修改</a></td>
				</tr>
			<%
					}
				}
			%>
	</table>
	    <form action="goodfindbyid.do" method="post" onsubmit="return check(this);">
			
			  <center>按编号查找：<input type="text" name="gno" /><input type="submit" value="查   找">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="goodAdd.jsp">添加快件信息</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="goodfindwei.do">查看未发货的快件</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="goodfindyi.do">查看已发货的快件</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="goodfindwan.do">查看完成派送的快件</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="goodfindyu.do">查看逾期未派送的快件</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="demo.html">返回主页</a>
				</center>
			
	       
	</form>  
	</div></div></div></div>
  </body>
</html>
