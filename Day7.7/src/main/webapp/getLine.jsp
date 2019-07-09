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
	$(function(){
		var lid= ${param.lid}
		$.post(
			"getLine.do",
			{lid:lid},
			function(data){
				var line = data.line;
				$("input[name=lid]").val(line.lid)
				$("input[name=lname]").val(line.lname)
				$("textarea[name=ldesc]").val(line.ldesc)
				$("input[name=iopen]").val(line.iopen)
				$("input[name=iclose]").val(line.iclose)
				$("#image").attr("src","showImg.do?limage="+line.limage+"")
				var sheng = data.sheng;
				for ( var i in sheng) {
					$("#sheng").append("<option value='"+sheng[i].aid+"'>"+sheng[i].aname+"</option>")
					$("#sheng option[value='"+line.sheng+"']").attr("selected",true)
				}
				var shi1 =data.shi1;
				for ( var i in shi1) {
					$("#shi").append("<option value='"+shi1[i].aid+"'>"+shi1[i].aname+"</option>")
					$("#shi option[value='"+line.shi+"']").attr("selected",true)
				}
				var xian1=data.xian1;
				for ( var i in xian1) {
					$("#xian").append("<option value='"+xian1[i].aid+"'>"+xian1[i].aname+"</option>")
					$("#xian option[value='"+line.xian+"']").attr("selected",true)
				}
				
			},
			"json"
		)
	})
		function getShi(){
		var aid = $("#sheng option:checked").val();
		$("#shi").empty();
		$("#xian").empty();
		$("#shi").append("<option>==请选择==</option>");
		$.post(
			"getShi.do",
			{aid:aid},
			function(data){
				var shi = data.list;
				for ( var i in shi) {
					$("#shi").append("<option value='"+shi[i].aid+"'>"+shi[i].aname+"</option>")
				}
			},
			"json"
		)
	}
	function getXian(){
		var aid = $("#shi option:checked").val();
		$("#xian").empty();
		$.post(
			"getXian.do",
			{aid:aid},
			function(data){
				var xian = data.list;
				for ( var i in xian) {
					$("#xian").append("<option value='"+xian[i].aid+"'>"+xian[i].aname+"</option>")
				}
			},
			"json"
		)
	}
</script>
</head>
<body>
	<form action="addUserLine.do" method="post">
		<table>
		<tr>
			<td><input type="text" name="uid" value=${user.uid }></td>
		</tr>
		<tr>
			<td><input type="text" name="uname" value=${user.uname }></td>
		</tr>
		<tr>
			<td><input type="text" name="utype" value=${user.utype }></td>
		</tr>
		<tr>
			<td>编号:<input type="text" name="lid"></td>
		</tr>
		<tr>
			
			<td>
			线路名称 <input type="text" name="lname">
			<input type="date" name="iopen"> <input type="date" name="iclose">
			</td>
		</tr>
		<tr>
			<td>
				线路<select name="sheng" id="sheng" onchange="getShi()">
					<option>==请选择==</option>
				  </select>
				  <select name="shi" id="shi" onchange="getXian()">
					<option>==请选择==</option>
				  </select>
				  <select name="xian" id="xian">
					<option>==请选择==</option>
				  </select>
			</td>
		</tr>
		<tr>
			<td>
				线路介绍<textarea name="ldesc"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" name="ltese" value="徒步">徒步
				<input type="checkbox" name="ltese" value="登山">登山
				<input type="checkbox" name="ltese" value="看日出">看日出	
			</td>
		</tr>
		<tr>
			<td>
				照片<input type="file" name="photo">
				<img id="image" src="" width="100px" height="50px">
			</td>
			
		</tr>
		<tr>
			<td><input type="submit" value="选择路线"></td>
		</tr>
	</table>
	</form>
</body>
</html>