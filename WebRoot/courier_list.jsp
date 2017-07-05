<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  import="com.delivery.pojo.Courier" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <!--IE Compatibility modes-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Mobile first-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Table</title>
    
    <meta name="description" content="Free Admin Template Based On Twitter Bootstrap 3.x">
    <meta name="author" content="">
    
    <meta name="msapplication-TileColor" content="#5bc0de" />
    <meta name="msapplication-TileImage" content="assets/img/metis-tile.png" />
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="assets/lib/bootstrap/css/bootstrap.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="assets/lib/font-awesome/css/font-awesome.css">
    
    <!-- Metis core stylesheet -->
    <link rel="stylesheet" href="assets/css/main.css">
    
    <!-- metisMenu stylesheet -->
    <link rel="stylesheet" href="assets/lib/metismenu/metisMenu.css">
    
    <!-- onoffcanvas stylesheet -->
    <link rel="stylesheet" href="assets/lib/onoffcanvas/onoffcanvas.css">
    
    <!-- animate.css stylesheet -->
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
            <header>
                <div class="icons"><i class="fa fa-table"></i></div>
                <h5>管理派件员信息</h5>
            </header>
            <div id="collapse4" class="body">
   <table align="center"  class="table table-bordered table-condensed table-hover table-striped">
			<tr ><td align="center" colspan="7">
				<h2>派件员信息表</h2>
			</td></tr>
  
		
		<tr align="center"  >
			<td><b>姓名</b></td>
			<td><b>性别</b></td>
			<td><b>年龄</b></td>
			<td><b>电话</b></td>
			<td><b>删除</b></td>
			<td><b>修改</b></td>
		</tr>
			<%
				// 获取图书信息集合
					List<Courier> list = (List<Courier>)request.getAttribute("list");
					// 判断集合是否有效
					if(list == null || list.size() < 1){
						out.print("没有数据！");
					}else{
						for(Courier courier : list){
			%>
				<tr align="center" bgcolor="white">
					<td><%=courier.getCname()%></td>
					<td><%=courier.getCsex()%></td>
					<td><%=courier.getCage()%></td>
					<td><%=courier.getCphone()%></td>
					<td><a href="courierdelete.do?cname=<%=courier.getCname()%>">删除</a></td>
					<td><a href="courierUpdate.jsp?cname=<%=courier.getCname()%>&csex=<%=courier.getCsex()%>&cage=<%=courier.getCage()%>&cphone=<%=courier.getCphone()%>">修改</a></td>
				</tr>
			<%
					}
				}
			%>
			<tbody>
	</table>
	 </div>
        </div>
    </div>
</div>
		    <form action="courierfindbyid.do" method="post" onsubmit="return check(this);">
			
			  <center>按姓名查找：<input type="text" name="cname" /><input type="submit" value="查   找">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="courierAdd.jsp">添加派件员信息</a></center>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="demo.html">返回主页</a>
				
	       
	</form> 
  </body>
</html>
