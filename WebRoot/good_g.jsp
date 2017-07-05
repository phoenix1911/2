<%@ page language="java" import="java.util.*" import="com.delivery.pojo.Good" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'good_g.jsp' starting page</title>
    
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
		
			<%
				    // 获取查询信息
					Good g = (Good)request.getAttribute("g");
					// 判断查询是否有效
					if(g == null){
						out.print("没有数据！");
					}else{

			%>
			    <tr >
			        <td align="center" colspan="11">
				    <h2>查询结果</h2>
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
				<tr align="center" >
					<td><%=g.getGno()%></td>
					<td><%=g.getGname()%></td>
					<td><%=g.getGaddress()%></td>
					<td><%=g.getRname()%></td>
					<td><%=g.getCname()%></td>
					<td><%=g.getIntime()%></td>
					<td><%=g.getOuttime()%></td>
					<td><%=g.getEndtime()%></td>
					<td><%=g.getState()%></td>
			        <td><a href="gooddelete.do?gno=<%=g.getGno()%>">删除</a></td>
					<td><a href="goodUpdate.jsp?gno=<%=g.getGno()%>&gname=<%=g.getGname()%>&gaddress=<%=g.getGaddress()%>&rname=<%=g.getRname()%>&cname=<%=g.getCname()%>&intime=<%=g.getIntime()%>&outtime=<%=g.getOuttime()%>&endtime=<%=g.getEndtime()%>&state=<%=g.getState()%>">修改</a></td>
				</tr>
			<%
					}
				
			%>
	</table>
	</div></div></div></div>
  </body>
</html>
