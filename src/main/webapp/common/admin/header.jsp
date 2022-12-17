<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page session="true"%>
<div class="header">
	<ul>
		<li style="background-color: #4285F4; font-size: 20px;"><a
			style="color: white; font-weight: 800" href="">Thousand Sunny</a></li>
	</ul>
	<ul>

		<div class="dropdown">
			<button onclick="AcountAdmin()" class="dropbtn">Account</button>
			<div id="Dropdown" class="dropdown-content account-drop">
				<a href="<c:url value='/admin/style/0/1'/>">Đổi Mật Khẩu</a> <a
					href="<c:url value='/admin/style/0/1'/>">Đăng xuất</a>
			</div>
		</div>
		<%-- <li style="border-radius: 10px" ><a href="">${sessionScope.accountName}</a></li> --%>
		<img
			src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.m.wikipedia.org%2Fwiki%2FFile%3AMicrosoft_Account.svg&psig=AOvVaw37vQ69_BALhxUBuZl85WlQ&ust=1671343981757000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLDvj9X___sCFQAAAAAdAAAAABAD"
			width="50" height="50" />


	</ul>


</div>

