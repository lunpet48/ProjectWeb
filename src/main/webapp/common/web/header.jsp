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
	        <a class="navbar-brand" href="/">SUNNY</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	
	        <div class="collapse navbar-collapse justify-content-end" id="navbars">
	        
	        	<form class="form-inline my-2 my-lg-0">
	                <div class="input-group input-group-sm searchfield">
	                    <input type="text" class="form-control" placeholder="Search...">
	                    <select name="cars" id="cars">
						  	<option value="product">Sản phẩm</option>
						  	<option value="category">Danh mục</option>
						  	<option value="store">Cửa hàng</option>
						</select>
	                    <div class="input-group-append">
	                        <button type="button" class="btn btn-secondary btn-number btn-search">
	                            <i class="fa fa-search"></i>
	                        </button>
	                    </div>
	                </div>
	                
	            </form>
	        
	            <ul class="navbar-nav m-auto">
	                <li class="nav-item active" id="home">
	                    <a class="nav-link" href="/">Trang chủ </a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="/category-list" id="category">Danh mục</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="product.html">Cửa hàng</a>
	                </li>
	                <c:choose>
					    <c:when test="${sessionScope.user != null}">
					       <li class="nav-item">
			                    <a class="nav-link" >${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()} </a>
			                </li>
					    </c:when>    
					    <c:otherwise>
					        <li class="nav-item">
			                    <a class="nav-link" href="/account/login">Đăng nhập</a>
			                </li>
					    </c:otherwise>
					</c:choose>
	                 
	                <a class="btn btn-success btn-sm ml-3" href="cart.html">
	                    <i class="fa fa-shopping-cart"></i> Cart
	                    <span class="badge badge-light">3</span>
	                </a>
	            </ul>
	
	            
	        </div>
	    </div>
	</nav>
	<script type="text/javascript">
	let page = '${page}';
	$('#navbars li').removeClass("active");
	$('#' + page).addClass("active");
	</script>
</body>
</html>