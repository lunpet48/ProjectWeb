<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link rel='stylesheet' href="/css/web/web.css">
    <!-- script -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	    <div class="container">
	        <a class="navbar-brand" href="index.html">SUNNY</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
	            <ul class="navbar-nav m-auto">
	                <li class="nav-item active">
	                    <a class="nav-link" href="#">Trang chủ <span class="sr-only">(current)</span></a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="category.html">Danh mục</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="product.html">Cửa hàng</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="product.html">Cart</a>
	                </li>
	                 <li class="nav-item">
	                    <a class="nav-link" href="login.html">Đăng ký</a>
	                    <!-- <a class="nav-link" href="login.html">Đăng nhập</a> -->
	                </li>
	            </ul>
	
	            <form class="form-inline my-2 my-lg-0">
	                <div class="input-group input-group-sm">
	                    <input type="text" class="form-control" placeholder="Search...">
	                    <div class="input-group-append">
	                        <button type="button" class="btn btn-secondary btn-number">
	                            <i class="fa fa-search"></i>
	                        </button>
	                    </div>
	                </div>
	                <a class="btn btn-success btn-sm ml-3" href="cart.html">
	                    <i class="fa fa-shopping-cart"></i> Cart
	                    <span class="badge badge-light">3</span>
	                </a>
	            </form>
	        </div>
	    </div>
	</nav>
</body>
</html>