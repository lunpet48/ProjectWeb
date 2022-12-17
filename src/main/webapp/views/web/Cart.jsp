<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LTWEB</title>

<link rel='stylesheet' href="/css/web/cart.css">

<script>
$(document).ready(function(){
  $('.store .check-one').change(function(){
   alert(5)
  });   
});
</script>
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
				                        	<td><input type="checkbox" class="check-one" name="check-one" value="${cartitem._id}"></td>
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
	                	<form action="/order/delete" method="post">
	                		<input type="hidden" name="cartitem" id="input-cartitem-delete" value="" multiple >
	                    	<button class="btn btn-block btn-light">Xóa</button>
	                    </form>
	                </div>
	                <div class="col-sm-12 col-md-4 text-right">
	                    <button class="btn btn-lg btn-block btn-success text-uppercase" id="dat-hang">Checkout</button>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Form điền thông tin đặt hàng -->
	<form action="/order/add" method="post">
		<div id="form-order-info" class="modal">
		  <div class="modal-content">
		    <div class="modal-header">
		      <span class="close close-modal">&times;</span>
		      <h2>Đặt hàng</h2>
		    </div>
		    <div class="modal-body">
		    	<label>Địa chỉ: </label><br/>
		    	<input type="text" name="address" value=""><br/><br/>
		    	
		    	<label>Số Điện thoại: </label><br/>
		    	<input type="text" name="phone" value=""><br/><br/>
		    	
		    	<label>Đơn vị giao hàng: </label><br/>
		    	<select name="delivery" id="delivery">
				  <option value="1">nhanh</option>
				  <option value="2">từ từ</option>
				</select>
		    	<br/><br/>
		    </div>
		    <div class="modal-footer">
		      <button class="close-modal" >Hủy</button>
		      <button id="xac-nhan-dat-hang" >Xác nhận</button>
		    </div>
		  </div>
		</div>
		
		<input type="hidden" name="cartitem" id="input-cartitem" value="" multiple >
		
	</form>
	<%@ include file="/common/web/footer.jsp"%>
	
	<script type="text/javascript">
	// checkbox all
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
		
	// uncheck checkbox-all
		$(document).on('change', '.store input[type=checkbox]', function(e) {
		    if (!this.checked) {
		    	$('#check-all').prop('checked', false);
		    }
		});
	// checkbox shop
		$(document).on('change', '.check-shop', function() {
		    if (this.checked) {
		    	$(this).closest('table').find('tbody .check-one').prop('checked', true);
		    } else {
		    	$(this).closest('table').find('tbody .check-one').prop('checked', false);
		    }
		});
	// uncheck checkbox-shop
		$(document).on('change', '.store .check-one', function(e) {
			alert(1)
		    if (!this.checked) {
		    	
		    	$(this).closest('table').find('thead .check-shop').prop('checked', false);
		    }
		});
	
	// chặn submit form khi ấn hủy 	
		$(document).on('click', 'button.close-modal', function(e) {
			e.preventDefault();
		});
		
		
		//form đặt hàng
		var modal = document.getElementById("form-order-info");
		$(document).on("click","#dat-hang",function() {
			let strcartitem = "";
			let checked = $(".check-one:checked");
			//console.log($(checked).val());
			$.each(checked, function( index, value ) {
				strcartitem = strcartitem + $(value).val() + ",";
			});
			strcartitem = strcartitem.slice(0, -1);
			console.log(strcartitem);
			$("#input-cartitem").val(strcartitem);
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
		// 
		$(document).on('change', '#check-all', function() {
			
		})
		
	</script>
</body>
</html>