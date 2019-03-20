<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<link href="css/login.css" rel='stylesheet' type='text/css'>

<title>Dang Ky Tai Khoan</title>
</head>
<body>

	<%
		String err = "";
		if (request.getParameter("err") != null) {
			err = (String) request.getAttribute("err");
		}
	%>
	<!-- /Start login two -->
	<div class="two-login  hvr-float-shadow">
	<div class="two-login-head">
	<img alt="" src="images/top-note.png" />
	<h2> Dang Ky</h2>
	<label></label>
	</div>
	
	<form action="RegisterServlet" method="post">
	<li style="color: red"><%=err %></li>
	Tên người dùng
	<li><input type="text" class="text" value="" name="username"><a href="" class=" icon2 user2"></a></li>
	Mật Khẩu
	<li><input type="password" value="" name="password"><a href="#" class=" icon2 lock2"></a></li>
	Ngày Sinh
	<li><input type="date" value="" name="ngaysinh"><a href="#" class=" icon2 lock2"></a></li>
	Giới tính
	<li><input type="text" value="" list ="exampleList" name="gioitinh">
	<datalist id="exampleList">
	<option value="Nam">
	<option value="Nữ">
	</datalist>
	<a href="#" class=" icon2 lock2"></a></li>
	Email
	<li><input type="text" value="" name="email"> <a href="#" class =" icon2 lock2"></a></li>
	Số điện thoại
	<li><input type="text" value="" name="sdt"><a href="#" class=" icon2 lock2"></a></li>
	Địa chỉ
	<li><input type="text" value="" name="diachi"><a href="" class =" icon2 lock2"></a></li>
	
	<div class ="p-container">
	<label class="checkbox two"><input type="checkbox" name="checkbox" checked><i></i>Tôi đồng ý
	<a href="#">Điều khoản dịch vụ</a>
	</label>
	</div>
	<div class="submit two">
	<input type="submit" value="ĐĂNG KÝ">

	</div>
	<h5>
	<a href="login.jsp">Đăng nhập</a>
	</h5>
	</form>
	</div>
</body>
</html>