<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Đăng nhập</title>
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
						<div class="card-header">Đăng nhập</div>
						<div class="card-body">
							<h4 style="color: red; text-align: center">${message}</h4>
							<form action="checklogin" method="post">
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">Tên tài
										khoản</label>
									<div class="col-md-6">
										<input type="text"  Name="username" 
											class="form-control" value="${username}" required  />
									</div>
								</div>

								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Mật khẩu</label>
									<div class="col-md-6">
										<input type="password"  Name="password" 
											class="form-control" value="${password}" required  />
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-6 offset-md-4">
										<div class="checkbox">
											<label> <input type="checkbox" name="remember">
												Remember Me
											</label>
										</div>
									</div>
								</div>

								<div class="col-md-6 offset-md-4">
									<button type="submit" value="Save" class="btn btn-primary">Đăng
										nhập</button>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>