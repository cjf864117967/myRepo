<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>我的个人空间</title>

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
	
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	 <div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp"><jsp:param value="profile" name="module"/></jsp:include>
			</div>
			 <div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				   		<h1> 个人设置</h1>
				  </div>
				</div>
				
			
			<form class="form-horizontal" action="/my/user/edit" method="post">
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="id" value="${user.id }"  placeholder="ID">
				    </div>
				  </div>	
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="username" value="${user.username }"  placeholder="用户名">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="password" value="${user.password }"  placeholder="密码">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="phone" value="${user.phone }"  placeholder="电话">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="email" value="${user.email }"  placeholder="邮箱">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="address" value="${user.address }"  placeholder="地址">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="star" value="${user.star }"  placeholder="星座">
				    </div>
				  </div>
				  
				  
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="motot" value="${user.motot }"  placeholder="座右铭">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">保存</button>
				    </div>
				  </div>
				</form>
			</div> 
		</div> 
		
	</div> 
	
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>