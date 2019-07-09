<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index3.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function login(){
		$.ajax({
			url:"login.do",
			type:"post",
			data:$("form").serialize(),
			dataType:"json",
			success:function(msg){
				if(msg==1){
					alert("登陆成功")
					location.href="list.do"
				}else{
					alert("用户名或密码错误")
				}
			}
		})
	}
</script>
</head>
<body>
	<form action="">
		<table>
		<tr>
			<td>姓名:</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="text" name="upwd"></td>
		</tr>
		<tr>
			<td>身份:</td>
			<td>
				<select name="utype">
					<option value="0">导游</option>
					<option value="1">游客</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
			<input type="button" value="登陆" onclick="login()">
			</td>
		</tr>
			
	</table>
	</form>
</body>
</html>