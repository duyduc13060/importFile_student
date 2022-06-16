<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<body>

	<div class="container w-75">
		<div class="row mt-5">
			<h1 class="text-center mt-5">Tra cứu thông tin tuyển sinh</h1>
			<div class="col text-center mt-5">
				<img alt="" src="/images/logo.png" width="10%">
				<div class="row mt-3">
					<c:if test="${not empty sessionScope.message}">
						<div class="col">
							<div class="alert alert-success fs-4" role="alert">
								${sessionScope.message}
								<c:remove var="message" scope="session" />
							</div>
						</div>
					</c:if>
					<c:if test="${not empty sessionScope.error}">
						<div class="col">
							<div class="alert alert-danger fs-4" role="alert">
								${sessionScope.error}
								<c:remove var="error" scope="session" />
							</div>
						</div>
					</c:if>
				</div>
				<div class="row ">
					<form action="/ghtk/import" enctype="multipart/form-data"
						method="post">
						<div class="form-group mt-3 d-flex justify-content-center">
							<input type="file" name="uploadFile" id="uploadFile"
								class="form-control w-50 float-start">
							<button class="btn btn-primary float-start mx-3">Import</button>
						</div>
					</form>
					<div class="col mt-4">
						<a href="/ghtk/index" class="btn btn-info">Xem Danh Sách Học Sinh</a>
					</div>
				</div>
			</div>
		</div>
		<footer class="text-center mt-5 p-2">
			<h5 class="">Nguyễn Duy Đức</h5>
		</footer>
	</div>
</body>

</html>