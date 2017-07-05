<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodAdd.jsp' starting page</title>
    
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


<script language="javascript">

	function check(){
		if(form2.gno.value==""){				//判断用户名是否为空
			alert("请输入快件编号！");form2.gno.focus();return;
		}else if(form2.gname.value==""){
		    alert("请输入快件名！");form2.gname.focus();return;
		}else if(form2.gaddress.value==""){
		    alert("请输入收件地址！");form2.gaddress.focus();return;
		}else if(form2.rname.value==""){
		    alert("请输入收件人名！");form2.rname.focus();return;
		}else if(form2.cname.value==""){
		    alert("请输入派件员名！");form2.cname.focus();return;
		}else if(form2.intime.value==""){
		    alert("请输入揽件时间！");form2.intime.focus();return;
		}else if(form2.state.value==""){
		    alert("请输入快件状态！");form2.state.focus();return;
		}else {
			form2.submit();					//提交表单
		}
	}
</script>

  </head>
  
  <body>
    <form name="form2" action="goodadd.do" method="post"  onsubmit="return check();">
		<div class="row">
  <div class="col-lg-12">
  <div class="box">
  <header><div class="icons"><i class="fa fa-table"></i></div><h5>管理派件信息</h5></header>
  <div id="collapse4" class="body">
    <table align="center" class="table table-bordered table-condensed table-hover table-striped">
			<tr>
				<td align="center" colspan="2">
					<h2>添加派件信息</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">快件编号</td>
				<td><input type="text" name="gno" /></td>
			</tr>
			<tr>
				<td align="right">快件名</td>
				<td><input type="text" name="gname" /></td>
			</tr>
			<tr>
				<td align="right">收件地址</td>
				<td><input type="text" name="gaddress" /></td>
			</tr>
			<tr>
				<td align="right">收件人名：</td>
				<td><input type="text" name="rname" /></td>
			</tr>
			<tr>
				<td align="right">派件员名</td>
				<td><input type="text" name="cname" /></td>
			</tr>
			<tr>
				<td align="right">揽件时间</td>
				<td><input type="text" name="intime" /></td>
				<td><input type="hidden" name="outtime" /></td>
				<td><input type="hidden" name="endtime" /></td>
			</tr>
			<tr>
				<td align="right">快件状态</td>
				<td><input type="text" name="state" value="已揽件"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input name="Button" type="button" value="添   加" onclick="check()">
					<input type="reset" value="重    置">
				</td>
			</tr>
		</table>
		</div></div></div></div>
	</form>
  </body>
</html>
