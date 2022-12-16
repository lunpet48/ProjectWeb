<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<br/>
	<div class="container mb-4">
	    <div class="row">
	        <div class="col-12">
	            <div class="table-responsive">
	                <table class="table table-striped">
	                    <thead>
	                        <tr>
	                            <th scope="col"> </th>
	                            <th scope="col">Product</th>
	                            <th scope="col">Available</th>
	                            <th scope="col" class="text-center">Quantity</th>
	                            <th scope="col" class="text-right">Price</th>
	                            <th> </th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
	                            <td>Product Name Dada</td>
	                            <td>In stock</td>
	                            <td><input class="form-control" type="text" value="1" /></td>
	                            <td class="text-right">124,90 €</td>
	                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
	                        </tr>
	                        <tr>
	                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
	                            <td>Product Name Toto</td>
	                            <td>In stock</td>
	                            <td><input class="form-control" type="text" value="1" /></td>
	                            <td class="text-right">33,90 €</td>
	                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
	                        </tr>
	                        <tr>
	                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
	                            <td>Product Name Titi</td>
	                            <td>In stock</td>
	                            <td><input class="form-control" type="text" value="1" /></td>
	                            <td class="text-right">70,00 €</td>
	                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
	                        </tr>
	                        
	                        <tr>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td><strong>Total</strong></td>
	                            <td class="text-right"><strong>346,90 €</strong></td>
	                        </tr>
	                    </tbody>
	                </table>
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
	                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

	<%@ include file="/common/web/footer.jsp"%>
</body>
</html>