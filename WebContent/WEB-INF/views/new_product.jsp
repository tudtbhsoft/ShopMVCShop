<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Thêm mới điện thoại</title>
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
						<div class="card-header">Thêm điện thoại mới</div>
						<div class="card-body">
							<form:form action="save" method="post" modelAttribute="product">
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Tên điện
										thoại</label>
									<div class="col-md-6">
										<form:input path="name" class="form-control" />
										<form:errors path="name" cssClass="error" style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Loại
										điện thoại</label>
									<div class="col-md-6">
										<form:select path="type" class="form-control">
											<option value="Iphone">Iphone</option>
											<option value="Samsung">Samsung</option>
											<option value="Oppo">Oppo</option>
											<option value="Huawei">Huawei</option>
										</form:select>
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Số lượng</label>
									<div class="col-md-6">
										<form:input class="form-control" path="amount" type="number"
											min="1" />
										<form:errors path="amount" cssClass="error" style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Thời
										gian nhập</label>
									<div class="col-md-6">
										<form:input type="date" class="form-control" path="time" />
										<form:errors path="time" cssClass="error" style="color:red" />
									</div>
								</div>
								<div class="col-md-6 offset-md-4">
									<button type="submit" value="Save" class="btn btn-primary">Lưu</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>