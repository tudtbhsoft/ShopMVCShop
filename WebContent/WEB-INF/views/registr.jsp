
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Đăng kí</title>
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
						<div class="card-header">Đăng kí</div>
						<div class="card-body">
						<h4 style="color: red; text-align: center">${message}</h4>
							<form:form action="saveRegistr" method="post"
								modelAttribute="registr">
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">Tên tài
										khoản</label>
									<div class="col-md-6">
										<form:input type="text" id="email_address" path="username"
											class="form-control" name="email-address" />
										<form:errors path="username" cssClass="error"
											style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
									<div class="col-md-6">
										<form:input type="password" id="password" path="password"
											class="form-control" name="password" />
										<form:errors path="password" cssClass="error"
											style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Họ và
										tên</label>
									<div class="col-md-6">
										<form:input type="text" id="name" path="name"
											class="form-control" name="name" />
										<form:errors path="name" cssClass="error" style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Tuổi</label>
									<div class="col-md-6">
										<form:input type="number" min="0" id="age" path="age"
											class="form-control" name="age" />
										<form:errors path="age" cssClass="error" style="color:red" />
									</div>
								</div>
								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Giới
										tính</label>
									<div class="col-md-6" style="padding: 200 0 0 0"><br>
										<input  type="radio" name="sex" path="sex"  value="Nam" checked> Nam 
										&emsp;&emsp;<input type="radio" name="sex" path="sex"  value="Nu" checked> Nữ
										&emsp;&emsp;<input type="radio" name="sex" path="sex"  value="Khac" checked> Khác
										<form:errors path="sex" cssClass="error" style="color:red" />
									</div>
								</div>


								<div class="col-md-6 offset-md-4">
									<button type="submit" value="Save" class="btn btn-primary">Đăng
										ký</button>
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