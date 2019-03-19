
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/menu.css" />
<link rel="stylesheet" href="css/product.css" />
</head>
<body>

	<div id="main">
		<div id="head">
			<img src="images/banner.jpg" width="1057px" height="200px" />
		</div>

		<%
		  String username = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username"))
					username = cookie.getValue();
			}
		}
		
		if(username != null){
		%>
		<div id="head-link">
			<div id='menungang'>
				<ul>
					<li class='last'><a href="index.jsp"><span>Trang
								chủ</span></a></li>
					<li class='last'><a href="product.jsp"><span>Sản phẩm</span></a></li>
					<li class='last'><a href="cart.jsp"><span>Giỏ hàng</span></a></li>
					<li class='last'><a href="search_page.jsp"><span>Tìm kiếm</span></a></li>
					<li class='last' style="float: right;">
					<a href=""><span>Đăng
								xuất</span></a></li>
								
				
				</ul>
			</div>
		</div>
		<%
		}else{
		%>
		
		<div id="head-link">
			<div id='menungang'>
				<ul>
					<li class='last'><a href="index.jsp"><span>Trang
								chủ</span></a></li>
					<li class='last'><a href="product.jsp"><span>Sản phẩm</span></a></li>
					<li class='last'><a href="search_page.jsp"><span>Tìm kiếm</span></a></li>
					<li class='last' style="float: right;"><a href="register.jsp"><span>Đăng
								ký</span></a></li>
					<li class='last' style="float: right;"><a href="login.jsp"><span>Đăng
								nhập</span></a></li>
				</ul>
			</div>
		</div>
		<%
		}
		%>
		
		<div id="content">
			<%-- <div id="left"><jsp:include page="category.jsp"></jsp:include></div> --%>
			
			<div id="right">
				
				<div id="site-wrapper" style="float: left">
					<ul class="products homepage">
						
						<li class="preorder"><span class="tagimg "> </span> 
									
								</h4> <span class="textkm">Khuyến mãi trị giá đến <strong>500.000₫</strong>
							</span>
								<p class="info">								
									
								</p>
						</a></li>

						

						<li class="preorder"><span class="tagimg "></span> 
						</li>
						
						
					</ul>
				</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
	</div>

</body>
</html>