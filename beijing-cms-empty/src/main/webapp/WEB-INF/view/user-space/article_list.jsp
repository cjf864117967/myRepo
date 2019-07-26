<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>发布文章_个人空间_CMS系统</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	<br/>
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp"></jsp:include>
				<br/>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				  		<h1>我的文章</h1>
				    	<hr/>
				    	
				    	<ul class="nav nav-tabs">
				    	 <li class="nav-item">
						    <a class="nav-link" href="#"></a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="/my/blogs">全部</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="/my/hot">热门</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="/my/status">审核通过</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="/my/deleted">已删除</a>
						  </li>
						</ul>
				    	<br/>
				    	<form class="form-inline">
				    		搜索：<input name="keywork" placeholder="标签" class="form-control"/>
				    		<button type="submit" class="btn btn-info">搜索</button>
				    	</form>
				    	<br/>
				    	
				    	<table class="table table-bordered table-hover">
				    		<thead>
				    			<tr class="table-active">
				    				<th>标题</th>
				    				<th>热门</th>
				    				<th>状态</th>
				    				<th>删除</th>
				    				<th>操作</th>
				    			</tr>
				    		</thead>
				    		<tbody class="">
				    		<c:forEach items="${blogs}" var="article">
				    			<tr id="item_${article.id}">
				    				<td><b>${article.title}</b>
				    				<div class="small text-secondary">
				    				分类：${article.channel.name} > ${article.category.name} &nbsp;&nbsp;
				    				标签： &nbsp;&nbsp;
				    				浏览：${article.hits} &nbsp;&nbsp;
				    				发布时间：<fmt:formatDate value="${article.updated}" pattern="yyyy-MM-dd"/>
				    				</div>
				    				</td>
				    				<td>${article.hot?'是':'否'}</td>
				    				<td>${article.status==1?'已审核':'未审核'}</td>
				    				<td>${article.deleted?'是':'否'}</td>
				    				<td><a href="/my/article/edit?id=${article.id}" title="编辑">编辑</a><br/>
				    				<a href="#" onclick="removeArticle(${article.id});" title="删除">删除</a></td>
				    			</tr>
				    		</c:forEach>
				    		</tbody>
				    	</table>
				  </div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>