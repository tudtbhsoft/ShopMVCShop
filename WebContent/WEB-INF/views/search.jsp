<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tìm kiếm</title>
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
						<div class="card-header">Tìm kiếm chuỗi: ${message}</div>
						<div class="card-body">
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
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${result}" var="product">
												<tr class="gradeU">
													<td>${product.id_product}</td>
													<td>${product.name}</td>
													<td>${product.type}</td>
													<td>${product.amount}</td>
													<td>${product.time}</td>
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