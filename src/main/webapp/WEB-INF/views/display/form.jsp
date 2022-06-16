<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
	<div class="container-fluid">
		<div class="row mt-5">
			<h5 class="text-center mt-2">Tra Cứu Thông Tin Tuyển sinh</h5>
			<div class="row">
				<div class="col-5 offset-4">
					<form action="/ghtk/search">
						<div class="form-group">
							<label for="">Họ Tên</label> <input type="text" name="hoTen"
								id="hoTen" class="form-control mt-2">
						</div>
						<div class="form-group">
							<label for="">Mã Học sinh</label> <input type="text"
								name="mahs" id="mahs" class="form-control mt-2">
						</div>
						<div class="form-group text-center mt-4">
							<button class="btn btn-primary">Tìm Kiếm</button>
						</div>
					</form>
				</div>

				<div class="col">
					<table class="table table-bordered mt-5">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Trường</th>
								<th scope="col">Quận/Huyện</th>
								<th scope="col">Mã sinh viên</th>
								<th scope="col">Lớp</th>
								<th scope="col">Họ Và Tên</th>
								<th scope="col">Ngày Sinh</th>
								<th scope="col">Giới Tính</th>
								<th scope="col">Nơi Sinh</th>
								<th scope="col">Dân Tộc</th>
								<th scope="col">Hộ Khẩu</th>
								<th scope="col">Điện thoại</th>
								<th scope="col">Tổng Điểm Lớp 1</th>
								<th scope="col">Tổng Điểm Lớp 2</th>
								<th scope="col">Tổng Điểm Lớp 3</th>
								<th scope="col">Tổng Điểm Lớp 4</th>
								<th scope="col">Tổng Điểm Lớp 5</th>
								<th scope="col">Tổng điểm kết quả 5 năm</th>
								<th scope="col">Điểm ưu tiên</th>
								<th scope="col">Tổng điểm sơ tuyển</th>
								<th scope="col">Ghi chú</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${listStudent}">
								<tr>
									<th scope="row">${student.id}</th>
									<td>${student.truong }</td>
									<td>${student.quanHuyen }</td>
									<td>${student.mahs }</td>
									<td>${student.lop }</td>
									<td>${student.hoTen }</td>
									<td><fmt:formatDate value="${student.ngaySinh }"
											pattern="dd/MM/YYYY" /></td>
									<td>${student.gioiTinh }</td>
									<td>${student.noiSinh }</td>
									<td>${student.danToc }</td>
									<td>${student.hoKhau }</td>
									<td>${student.dienThoai }</td>

									<td>${student.diem1 }</td>
									<td>${student.diem2 }</td>
									<td>${student.diem3 }</td>
									<td>${student.diem4 }</td>
									<td>${student.diem5 }</td>
									<td>${student.tongDiem }</td>
									<td>${student.diemUuTien }</td>
									<td>${student.tongDiemSoTuyen }</td>
									<td>${student.ghiChu }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="card-footer">
			<h5 class="text-center">Nguyễn Duy Đức</h5>
		</div>
	</div
</body>

</html>