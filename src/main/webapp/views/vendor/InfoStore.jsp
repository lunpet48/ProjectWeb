<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.rtl.min.css"
	integrity="sha512-tC3gnye8BsHmrW3eRP3Nrj/bs+CSVUfzkjOlfLNrfvcbKXFxk5+b8dQCZi9rgVFjDudwipXfqEhsKMMgRZGCDw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h2>${store.name }</h2>

	<div class="container-fluid pt-5 pb-3">
		<h2
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">Recent Products</span>
		</h2>
		<div class="row px-xl-5">
			<c:forEach var="item" items="${listProducts }">
				<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
					<div class="product-item bg-light mb-4">
						<div class="product-img position-relative overflow-hidden">
							<img class="img-fluid w-100" src="/images/${item.listImages[0] }"
								alt="">
							<div class="product-action">
								<a class="btn btn-outline-dark btn-square" href=""><i
									class="fa fa-shopping-cart"></i></a> <a
									class="btn btn-outline-dark btn-square" href=""><i
									class="far fa-heart"></i></a> <a
									class="btn btn-outline-dark btn-square" href=""><i
									class="fa fa-sync-alt"></i></a> <a
									class="btn btn-outline-dark btn-square" href=""><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="text-center py-4">
							<a class="h6 text-decoration-none text-truncate" href=""><span>${item.name}</span></a>
							<div
								class="d-flex align-items-center justify-content-center mt-2">
								<h5>${item.price}</h5>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/js/bootstrap.min.js"
		integrity="sha512-1/RvZTcCDEUjY/CypiMz+iqqtaoQfAITmNSJY17Myp4Ms5mdxPS5UV7iOfdZoxcGhzFbOm6sntTKJppjvuhg4g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>