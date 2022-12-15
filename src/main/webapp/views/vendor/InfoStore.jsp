<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<br />
	<div class="container mt-3">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-star"></i> Last products
					</div>
					<div class="card-body">
						<c:forEach items="${listProducts }" var="item">
						<div class="product-card">
							<div class="product-tumb">
								<img src="/images/${item.listImages[0]}" alt="">
							</div>
							<div class="product-details">
								<p>${item.name }</p>
								<div class="product-bottom-details">
									<div class="product-price">
										<span>${item.price }</span>
									</div>
									<div class="product-links">
										<a href=""><i class="fa fa-shopping-cart"></i></a>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/common/web/footer.jsp"%>
</body>
</html>