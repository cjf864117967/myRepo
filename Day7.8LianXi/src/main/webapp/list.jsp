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
		$("#qfx").toggle(function(){
			$("input[name=ids]").attr("checked",true)
		},function(){
			$("input[name=ids]").attr("checked",false)
		})
	})
	function deleteAll(){
		var ids = $("input[type=checkbox]:checked").map(function(){
			return this.value;
		}).get().join();
		alert(ids)
		if(ids.length>0){
			if(confirm("您确定要删除选中的数据吗?")){
				$.ajax({
					url:"deleteAll.do",
					type:"post",
					data:{ids:ids},
					dataType:"json",
					success:function(msg){
						if(msg>0){
							alert("删除成功")
							location.href="list.do";
						}
					}
				})
			}
		}
	}
	function chaxun(){
		var s1="影片名称:<input type='text' name='yname'>"
		var s2="上映时间:<input type='date' name='dopen'>至<input type='date' name='dclose'><br>"
		var s3="导演<input type='text' name='yauthor'>"
		var s4="价格:<input type='text' name='popen'>-<input type='text' name='pclose'><br>"
		var s5="电影年代:<input type='text' name='yyear'>"
		var s6="电影时长:<input type='text' name='topen'>-<input type='text' name='tclose'><br>"
		
		var s7="<input type='submit' value='查询影片'>"
		
		$("#s").append("<form action='list.do' method='post'>"+s1+s2+s3+s4+s5+s6+s7+"</form>");
	}
</script>
</head>
<body>
	
	<input type="button" value="查询影片" onclick="chaxun()">
	<input type="button" value="添加影片">
	<input type="button" value="删除影片" onclick="deleteAll()">
	<table>
		<tr>
			<td><input type="checkbox" id="qfx"></td>
			<td>编号</td>
			<td>影片名</td>
			<td>导演</td>
			<td>票价</td>
			<td>上映时间</td>
			<td>时长</td>
			<td>类型</td>
			<td>年代</td>
			<td>区域</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="b">
			<tr>
				<td><input type="checkbox" value="${b.mid }" name="ids"></td>
				<td>${b.mid }</td>
				<td>${b.mname }</td>
				<td>${b.mauthor }</td>
				<td>${b.mprice }</td>
				<td>${b.mdate }</td>
				<td>${b.mtime }</td>
				<td>${b.cname }</td>
				<td>${b.myear }</td>
				<td>${b.aname }</td>
				<td>
				<c:if test="${b.mzhuangtai==1 }">正在热映</c:if>
				<c:if test="${b.mzhuangtai==0 }">已经下架</c:if>
				<c:if test="${b.mzhuangtai==2 }">即将上映</c:if>
				</td>
				<td>
				<a>详情</a>
				<a>编辑</a>
				<c:if test="${b.mzhuangtai==1 }"><a href="getState.do?mid=${b.mid }">下架</a></c:if>
				<c:if test="${b.mzhuangtai==0 }"><a href="getState1.do?mid=${b.mid }">上架</a></c:if>
				<c:if test="${b.mzhuangtai==2 }"><a href="getState.do?mid=${b.mid }">下架</a></c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<a href="list.do?pageNum=${page.firstPage }">首页</a>
				<a href="list.do?pageNum=${page.prePage }">上页</a>
				<a href="list.do?pageNum=${page.nextPage }">下页</a>
				<a href="list.do?pageNum=${page.lastPage }">尾页</a>
			</td>
		</tr>
	</table>
	<div id="s">
	
	</div>
</body>
</html>