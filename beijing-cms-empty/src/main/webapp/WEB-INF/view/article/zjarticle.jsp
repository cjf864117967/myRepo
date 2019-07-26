<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="howsun">

    <title>CMS后台管理系统</title>

    <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

	<!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>

    <div id="wrapper">

 		<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>

      <div id="content-wrapper">

        <div class="container-fluid">


          <!-- Icon Cards-->
          <br/>
          <br/>
          <h1 align="center">专题文章设置</h1>
          <br/>
          
          <br/>
          <div class="row">
            <font style="color: red">专题名称:</font>${special.tittle }
          </div>
          <div class="row">
            <font style="color: red">专题摘要:</font>${special.aabstract }
          </div>
          <div class="row">
            <font style="color: red">专题文章:</font>
          </div>
		  <div>
		  	<table class="table table-hover">
  				<tr>
  					<td>文章ID</td>
  					<td>文章标题</td>
  					<td>文章发布时间</td>
  					<td>操作</td>
  				</tr>
  				<c:forEach items="${list }" var="b">
  					<tr>
  						<td>${b.id }</td>
  						<td>${b.title }</td>
  						<td><fmt:formatDate value="${b.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  						<td><a href="#">移除</a></td>
  					</tr>
  				</c:forEach>
			</table>
			<form action="/admin/addArticle" method="post">
				<div class="form-group">
					<div class="col-sm-6">
					 <input type="hidden" name="sid" value="${special.id }">
					 <input type="text" name="aid"  placeholder="文章ID">
					 <input class="btn btn-default" type="submit" value="添加文章">
					</div>
				</div>
			</form>
		  </div>
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright Â© Your Website 2019</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>
  </body>

</html>
