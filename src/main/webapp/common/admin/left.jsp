<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="navigation">
	<ul>
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin'/>" class=" item active"> <span
				class="icon"><i class="fa-solid fa-gauge"></i></span> <span
				class="title">Dashboard</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin/user/1'/>" class=" item active"> <span
				class="icon"><i class="fa-solid fa-user"></i></span> <span
				class="title">User</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin/store/1'/>" class=" item active"> <span
				class="icon"><i
					class="fa-solid fa-store"></i></span> <span
				class="title">Store</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin/category'/>" class=" item active"> <span
				class="icon"><i class="fa-solid fa-list"></i></span> <span
				class="title">Category</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin/product/all/1'/>" class=" item active"> <span
				class="icon"><i class="fa-brands fa-product-hunt"></i></i></span> <span
				class="title">Product</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		<li class="list"><b></b> <b></b> <a
			href="<c:url value='/admin/product/all/1'/>" class=" item active"> <span
				class="icon"><i
					class="fa-regular fa-book"></i></span> <span
				class="title">Order</span> <i
				class="fa-solid fa-angle-right dropdown"></i>
		</a></li>
		
		
	</ul>
</div>

<div class="toggle">
	<i class="fa-solid fa-list open"></i> <i class="fa-solid fa-list close"></i>
</div>


