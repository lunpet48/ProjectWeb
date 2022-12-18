<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel='stylesheet' href="/css/web/product.css">
</head>
<body>
<%@ include file="/common/web/header.jsp"%>
	<br/>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                   Kết quả tìm kiếm 
                   <c:choose>
					    <c:when test="${cate != null}">
					        Cho danh mục: ${cate.name}
					    </c:when>    
					    <c:otherwise>
					    </c:otherwise>
					</c:choose>
                   
                </div>
                <div class="card-body">
                	
                	<c:forEach items="${list}" var ="product">
	                	<div class="product-card">
	                		<input type="hidden" value="${product._id}">
	                        <div class="product-tumb">
	                            <img src="/vendor/store/product/images/${product.listImages[0]}" alt="">
	                        </div>
	                        <div class="product-details">
	                            <p>${product.name}</p>
	                            <div class="product-bottom-details">
	                                <div class="product-price"><!-- <small>$96.000.000</small> -->${product.price}</div>
	                                 <c:choose>
									    <c:when test="${sessionScope.user != null}">
									       <div class="product-links " >
			                                    <a class="add-to-cart"><i class="fa fa-shopping-cart"></i></a>
			                                </div>
									    </c:when>    
									    <c:otherwise>
									       	<div class="product-links" >
			                                    <a href="/account/login"><i class="fa fa-shopping-cart"></i></a>
			                                </div>
									    </c:otherwise>
									</c:choose>
	                                
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