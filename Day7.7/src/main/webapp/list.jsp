<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index3.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$.post(
			"getSheng.do",
			function(data){
				var sheng = data.list;
				for ( var i in sheng) {
					$("#sheng").append("<option value='"+sheng[i].aid+"'>"+sheng[i].aname+"</option>")
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
	
	function addLine(){
		location.href="addLine.jsp";
	}
	function getLine1(){
		var lid = $("input[type=checkbox]:checked").val();
		alert(lid);
		location.href="getLine.jsp?lid="+lid
	}
	function deleteAll(){
		var ids = $("input[type=checkbox]:checked").map(function(){
			return this.value;
		}).get().join();
		alert(ids)
		var count = ids.length
		if(ids.length>0){
			if(confirm("您确认要删除选中的路线吗?")){
				$.ajax({
					url:"deleteAll.do",
					type:"post",
					data:{ids:ids},
					dataType:"json",
					success:function(msg){
						if(msg>0){
							alert("成功删除"+count+"条数据")
							location.href="list.do"
						}
					}
				})
			}
		}
	}
	$(function(){
		$("#qfx").toggle(function(){
			$("input[type=checkbox]").attr("checked",true)
		},function(){
			$("input[type=checkbox]").attr("checked",false)
		})
	})
</script>
</head>
<body>
	<form action="list.do" method="post">
		线路名称:<input type="text" name="mname">
		特色标签:<input type="text" name="tname"><br>
		地区:<select name="sheng" id="sheng" onchange="getShi()">
					<option>==请选择==</option>
				  </select>
				  <select name="shi" id="shi" onchange="getXian()">
					<option>==请选择==</option>
				  </select>
				  <select name="xian" id="xian">
					<option>==请选择==</option>
				  </select>
		<input type="submit" value="搜索">
	</form>
	<table>
		<tr>
			<td><input type="button" value="全选/全不选" id="qfx"></td>
			<td>编号</td>
			<td>线路名称</td>
			<td>特色标签</td>
			<td>地区</td>
			<td>参与人员姓名</td>
			<td>参与人员身份</td>
			<td>线路介绍</td>
			<td>开始日期</td>
			<td>结束日期</td>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td><input type="checkbox" id="s" value="${b.lid }" ></td>
				<td>${b.lid }</td>	
				<td>${b.lname }</td>
				<td>${b.ltese }</td>
				<td>${b.sheng1 } ${b.shi1 } ${b.xian1 }</td>
				<td>
					<c:if test="${b.uname1 =='Tom'}">Tom</c:if>
					<c:if test="${b.uname1 =='Jerry'}">Jerry</c:if>
				</td>
				<td>
				<c:if test="${b.uname1 =='Tom'}">导游</c:if>
				<c:if test="${b.uname1 =='Jerry'}">游客</c:if>
				</td>
				<td>${b.ldesc }</td>
				<td>${b.iopen }</td>
				<td>${b.iclose }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
			<input type="button" value="查看线路详情" onclick="getLine1()">
			<c:if test="${user.utype==0 }">
				<input type="button" value="批量删除" onclick="deleteAll()">
			</c:if>
			
			</td>
		</tr>
		<tr>
			<c:if test="${user.utype==0 }">
				<td><input type="button" value="创建线路" onclick="addLine()"></td>
			</c:if>
			
		</tr>
	</table>
</body>
</html>