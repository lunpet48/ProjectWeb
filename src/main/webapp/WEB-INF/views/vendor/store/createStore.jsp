<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.2/css/bootstrap.min.css" />
<title>Tạo cửa hàng</title>
</head>
<body>
	<section class="row">
		<div class="col-6 offset-3 mt-4">
			<form action="<c:url value="/vendor/store/create"/>" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-header">
						<h2>Tạo cửa hàng</h2>
					</div>
					<div class="card-body">
						<div>
							<label for="_id" class="form-label">Store ID:</label> <input
								type="text" readonly="readonly" class="form-control"
								value="${store._id}" id="_id">
						</div>
						<div>
							<label for="name" class="form-label">Store's name:</label> <input
								type="text" class="form-control" value="${store.name }"
								name="name" id="name">
						</div>
						<div>
							<label for="bio" class="form-label">Store's bio:</label> <input
								type="text" class="form-control" value="${store.bio}" name="bio"
								id="bio">
						</div>
						<div>
							<label for="avatar" class="form-label">Avatar:</label> <input
								type="file" class="form-control-file" value="${store.avatar}"
								onchange = "chooseFile(this)" accept=".jpg, .png"
								name="avatar" id="avatar" >
						</div>
						<div>
							<label for="cover" class="form-label">Cover:</label> <input
								type="file" class="form-control-file" value="${store.cover}"
								name="cover" id="cover">
						</div>
						<div>
							<label for="featuredImages" class="form-label">Featured
								Images</label> <input type="file" class="form-control-file"
								value="${store.featuredImages}" name="featuredImages"
								id="featuredImages" multiple="multiple">
						</div>
					</div>
				</div>
				<input type="submit" value="Tạo cửa hàng">
			</form>
		</div>
	</section>
</body>
</html>