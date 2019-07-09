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
	function zhuce(){
		var utype = $("select option:selected").val();
		var upwd = $("input[name=upwd]").val();
		var password = $("input[name=password]").val();
		if(upwd==password){
			$.ajax({
				url:"zhuce.do",
				type:"post",
				data:$("form").serialize(),
				dataType:"json",
				success:function(msg){
					if(msg>0){
						if(utype==0){
							alert("已成功注册为[导游]")
							location.href="tologin.do"
						}else{
							alert("已成功注册为[游客]")
							location.href="tologin.do"
						}
					}
				}
			})
		}else{
			alert("俩次输入的密码不一致")
		}
		
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
			<td>确认密码:</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td>身份:</td>
			<td>
				<select name="utype">
					<option>==请选择==</option>
					<option value="0">导游</option>
					<option value="1">游客</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
			<input type="button" value="注册" onclick="zhuce()">
			<input type="button" value="已有用户登陆" onclick="location.href='tologin.do'">
			</td>
		</tr>
			
	</table>
	</form>
</body>
</html>