<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>DANH SÁCH ĐIỆN THOẠI</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Danh sách điện thoại</div>
						<div class="card-body">
							<div class="card-body">
								<form style="text-align: center;" method="get" action="search">
									<input type="text" name="keyword" /> &nbsp; <input
										type="submit" value="Tìm kiếm" />
								</form>
							</div>
							<div>
								<a class="btn btn-large btn-success" href="new">Thêm điện
									thoại mới</a>
							</div>
							<h4 style="color: red; text-align: center">${message}</h4>
							<div class="module">
								<div class="module-body table">
									<table cellpadding="0" cellspacing="0" border="0"
										class="datatable-1 table table-bordered table-striped	 display"
										width="100%">
										<thead>
											<tr>
												<th>ID</th>
												<th>Tên sản phẩm</th>
												<th>Loại sản phẩm</th>
												<th>Số lượng</th>
												<th>Thời gian nhập</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listProducts}" var="product">
												<tr class="gradeU">
													<td>${product.id_product}</td>
													<td>${product.name}</td>
													<td>${product.type}</td>
													<td>${product.amount}</td>
													<td><fmt:formatDate value="${product.time}"
															pattern="dd-MM-yyyy" /></td>
													<td><a class="btn btn-large btn-info"
														href="edit?id=${product.id_product}">Sửa</a> <a
														class="btn btn-large btn-danger"
														href="delete?id=${product.id_product}">Xóa</a></td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>ID</th>
												<th>Tên sản phẩm</th>
												<th>Loại sản phẩm</th>
												<th>Số lượng</th>
												<th>Thời gian nhập</th>
												<th>Chức năng</th>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</main>
</body>
</html>