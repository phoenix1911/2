<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcourier.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
<script language="javascript">
	function check(){
		if(form1.cname.value==""){				
			alert("请输入姓名！");form1.cname.focus();return;
		}else if(form1.cage.value==""){
		    alert("请输入年龄！");form1.cage.focus();return;
		}else if(form1.cphone.value==""){
		    alert("请输入电话！");form1.cphone.focus();return;
		}else if(parseInt(form1.cage.value)!=form1.cage.value){
		    alert("年龄为数字！");form1.cage.focus();return;
		}else if(parseInt(form1.cage.value)>65||parseInt(form1.cage.value)<18){
		    alert("年龄应在18岁到65岁之间！");form1.cage.focus();return;
		}else if(parseInt(form1.cphone.value)!=form1.cphone.value){
		    alert("电话为数字！");form1.cphone.focus();return;
		}else if(form1.cphone.value.length!=11){
		    alert("电话位数应为11位！");form1.cphone.focus();return;
		}else{
			form1.submit();					//提交表单
		}
	}
</script>

  </head>
  
  <body>
     <form name="form1" action="courieradd.do" method="post" onsubmit="return check()">
            <div class="row">
  <div class="col-lg-12">
        <div class="box">
            <header>
                <div class="icons"><i class="fa fa-table"></i></div>
                <h5>管理派件员信息</h5>
            </header>
            <div id="collapse4" class="body">
		<table  class="table table-bordered table-condensed table-hover table-striped">
			<tr>
				<td align="center" colspan="2">
					<h2>添加派件员信息</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">姓名：</td>
				<td><input type="text" name="cname" /></td>
			</tr>
			<tr>
				<td align="right">性别：</td>
				<td><input type="radio" name="csex" value="男" checked/>男&nbsp;
				    <input type="radio" name="csex" value="女"/>女
				</td>
			</tr>
			<tr>
				<td align="right">年龄：</td>
				<td><input type="text" name="cage" /></td>
			</tr>
			<tr>
				<td align="right">电话：</td>
				<td><input type="text" name="cphone" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<!-- <input type="submit" value="添　加"> -->
					<input name="Button" type="button" value="添   加" onclick="check()">
					<input type="reset" value="重    置">
				</td>
			</tr>
		</table>
		</div>
        </div>
    </div>
</div>
	</form>
  </body>
</html>
