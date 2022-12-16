<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LTWEB</title>

<link rel='stylesheet' href="/css/web/cart.css">
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<br/>
	<div class="container mb-4">
	    <div class="row">
	        <div class="col-12">
	            <div class="table-responsive">
	            	<div class="choose-all">
	            		<input type="checkbox" id="check-all" name="check-all">
	            		<a>CHỌN TẤT CẢ</a>
	            	</div>
	            	
	            	<c:forEach items="${cartItem}" var ="cartitembystore">
		            	<div class="store">
		            		<div class="store-name">
				            	<a href="">${cartitembystore[0].cartId.storeId.name}</a>
		            		</div>
		            		
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col"><input type="checkbox" class="check-shop" name="check-shop"></th>
			                            <th scope="col"></th>
			                            <th scope="col">Product</th>
			                            <th scope="col" class="text-left">Price</th>
			                            <th scope="col" class="text-center">Quantity</th>
			                            <th> </th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<c:forEach items="${cartitembystore}" var ="cartitem">
				                    	<tr>
				                        	<td><input type="checkbox" class="check-one" name="check-one"></td>
				                            <td> <div class="product-image"><img src="https://dummyimage.com/80x80/55595c/fff" /></div> </td>
				                            <td>${cartitem.productId.name}</td>
				                            <td class="text-left">${cartitem.productId.price}</td>
				                            <td class="text-center input-center"><input class="form-control text-center" type="text" value="${cartitem.count}" /></td>
				                            <td class="text-center"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
				                        </tr>
			                    	</c:forEach>
			                    </tbody>
			                </table>
		                </div>
	            	</c:forEach>
	            	
	            	<!-- <div class="store">
	            		<div class="store-name">
			            	<a href="">store1</a>
	            		</div>
	            		
		                <table class="table table-striped">
		                    <thead>
		                        <tr>
		                            <th scope="col"><input type="checkbox" name="check-shop"></th>
		                            <th scope="col"></th>
		                            <th scope="col">Product</th>
		                            <th scope="col" class="text-left">Price</th>
		                            <th scope="col" class="text-center">Quantity</th>
		                            <th> </th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <tr>
		                        	<td><input type="checkbox" name="check-one"></td>
		                            <td> <div class="product-image"><img src="https://dummyimage.com/80x80/55595c/fff" /></div> </td>
		                            <td>Product Name Dada</td>
		                            <td class="text-left">124,90 €</td>
		                            <td class="text-center input-center"><input class="form-control text-center" type="text" value="1" /></td>
		                            <td class="text-center"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
		                        </tr>
		                        <tr>
		                        	<td><input type="checkbox" name="check-one"></td>
		                            <td> <div class="product-image"><img src="https://dummyimage.com/80x80/55595c/fff" /></div> </td>
		                            <td>Product Name Dada</td>
		                            <td class="text-left">124,90 €</td>
		                            <td class="text-center input-center"><input class="form-control text-center" type="text" value="1" /></td>
		                            <td class="text-center"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
		                        </tr>
		                        <tr>
		                        	<td><input type="checkbox" name="check-one"></td>
		                            <td> <div class="product-image"><img src="https://dummyimage.com/80x80/55595c/fff" /></div> </td>
		                            <td>Product Name Dada</td>
		                            <td class="text-left">124,90 €</td>
		                            <td class="text-center input-center"><input class="form-control text-center" type="text" value="1" /></td>
		                            <td class="text-center"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
		                        </tr>
		                    </tbody>
		                </table>
	                </div> -->
	                
	            </div>
	        </div>
	        <div class="col mb-2">
	            <div class="row">
	                <div class="col-sm-12  col-md-4">
	                    <button class="btn btn-block btn-light">Continue Shopping</button>
	                </div>
	                <div class="col-sm-12  col-md-4">
	                    <button class="btn btn-block btn-light">Xóa</button>
	                </div>
	                <div class="col-sm-12 col-md-4 text-right">
	                    <button class="btn btn-lg btn-block btn-success text-uppercase" id="dat-hang">Checkout</button>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Form điền thông tin đặt hàng -->
	<div id="form-order-info" class="modal">
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="close close-modal">&times;</span>
	      <h2>Đặt hàng</h2>
	    </div>
	    <div class="modal-body">
	      
	    </div>
	    <div class="modal-footer">
	      <button id="xac-nhan-dat-hang" >Xác nhận</button>
	      <button class="close-modal">Hủy</button>
	    </div>
	  </div>
	</div>

	<%@ include file="/common/web/footer.jsp"%>
	
	<script type="text/javascript">
		$(document).on('change', '#check-all', function() {
		    if (this.checked) {
		    	$('.store input[type=checkbox]').each(function () {
		    	    $(this).prop('checked', true);
		    	    
		    	});
		    } else {
		    	$('.store input[type=checkbox]').each(function () {
		    	    $(this).prop('checked', false);
		    	});
		    }
		});
		
		$(document).on('change', '.store input[type=checkbox]', function(e) {
		    if (!this.checked) {
		    	$('#check-all').prop('checked', false);
		    }
		});
		
		$(document).on('change', '.check-shop', function() {
		    if (this.checked) {
		    	$(this).closest('table').find('tbody .check-one').prop('checked', true);
		    } else {
		    	$(this).closest('table').find('tbody .check-one').prop('checked', false);
		    }
		});
		
		$(document).on('change', '.store .check-one', function(e) {
		    if (!this.checked) {
		    	$(this).closest('table').find('thead .check-shop').prop('checked', false);
		    }
		});
		
		//form đặt hàng
		var modal = document.getElementById("form-order-info");
		$(document).on("click","#dat-hang",function() {
			
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
	</script>
</body>
</html>