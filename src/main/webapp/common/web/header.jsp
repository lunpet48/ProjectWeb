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
    <link rel='stylesheet' href="/css/modal.css">
    <link rel='stylesheet' href="/css/alertMessage.css">
    <!-- script -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<div id="alertMessage">
			<c:if test="${messageError !=null}">
				<div class="alert">
				  <span class="closebtn">&times;</span>  
				 	${messageError}
				</div>
			</c:if>
	</div>
	
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
					       <li class="nav-item user-name">
			                    <a class="nav-link" >${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()} </a>
				                <div class="user-dropdown">
				                	<div class="user-dropdown__item">
				                		<a>Tài Khoản Của Tôi</a>
				                	</div>
				                	<div class="user-dropdown__item">
				                		<a>Đơn Mua</a>
				                	</div>
				                	<div class="user-dropdown__item" onclick="location.href='/account/logout';">
				                		<a>Đăng Xuất</a>
				                	</div>
				                </div>
			                </li>
					    </c:when>    
					    <c:otherwise>
					        <li class="nav-item">
			                    <a class="nav-link" href="/account/login">Đăng nhập</a>
			                </li>
					    </c:otherwise>
					</c:choose>
	                
	                 <c:choose>
					    <c:when test="${sessionScope.user != null}">
					       <a class="btn btn-success btn-sm ml-3" href="/cart">
			                    <i class="fa fa-shopping-cart"></i> Cart
			                    <span class="badge badge-light">3</span>
			                </a>
					    </c:when>    
					    <c:otherwise>
					        <a class="btn btn-success btn-sm ml-3" href="/account/login">
			                    <i class="fa fa-shopping-cart"></i> Cart
			                    <span class="badge badge-light">3</span>
			                </a>
					    </c:otherwise>
					</c:choose>
	                
	                
	            </ul>
	
	            
	        </div>
	    </div>
	</nav>
	
	<!-- thông báo xác nhận muốn thêm vào giỏ hàng -->
	<div id="confirm-add-to-cart" class="modal">
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close close-modal">&times;</span>
	      <h2>Thông báo</h2>
	    </div>
	    <div class="modal-body">
	      <p>Bạn có muốn thêm sản phẩm này vào giỏ hàng không?</p>
	    </div>
	    <div class="modal-footer">
	      <button id="xac-nhan-them-vao-gio" >Xác nhận</button>
	      <button class="close-modal">Hủy</button>
	    </div>
	  </div>
	</div>
		
	
	<script type="text/javascript">
	var pid;
	var modal = document.getElementById("confirm-add-to-cart");
	
	let page = '${page}';
	$('#navbars li').removeClass("active");
	$('#' + page).addClass("active");
	
	//thông báo xác nhận muốn thêm vào giỏ hàng
	$(document).on("click",".add-to-cart",function() {
		pid = $(this).closest('.product-card').find('input').eq(0).val()
		
		modal.style.display = "block";
	});
	$(document).on("click",".close-modal",function() {
		modal.style.display = "none";
	});
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}

	$(document).on("click","#xac-nhan-them-vao-gio",function() {
		
		$.ajax({
	        type: "POST",
	        contentType: "application/json",
	        url: location.protocol + '//' + location.host +  "/cart/add-to-cart",
	        data: JSON.stringify(pid),
	        /* dataType: 'json', */
	        success: function (data) {
				$('#alertMessage').append(`<div class="alert success">
						  <span class="closebtn">&times;</span>  
					 	\${data}
					</div>`)
				//alert(data)
					modal.style.display = "none";
	        },
	        error: function (e) {
				alert("An error occur!");
	        }
	    });
		
	});
	
	//close message

	/* $(document).on('click', '.closebtn', function(){
		var div = this.parentElement;
		div.style.opacity = "0";
		setTimeout(function(){ div.style.display = "none"; }, 600);
	}) */
	
       
	</script>
	<script src="/js/alertMessage.js"></script>
</body>
</html>