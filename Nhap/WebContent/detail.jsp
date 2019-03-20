
<%@page import="dao.ProductDAOImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.NumberFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<link rel="stylesheet" href="css/detail.css" />
<link rel="stylesheet" href="css/menu.css" />
<style type="text/css">
#main {
	width: 1060px;
	padding: 0;
	margin-left: auto;
	margin-right: auto;
}

#head {
	height: 200px;
	background-color: #F5F5F5;
	border: 1px solid #CDCDCD;
	margin-bottom: 5px;
	margin-top: 5px;
}

#head-link {
	height: 50px;
	line-height: 30px;
	border: 1px solid #CDCDCD;
	background-color: #F5F5F5;
	margin-bottom: 5px;
	clear: both;
}

#content {
	width: 1060px;
	min-height: 430px;
	border: 1px solid #CDCDCD;
	float: left;
	margin-bottom: 5px;
	clear: both;
}

#footer {
	height: 50px;
	clear: both;
	border: 1px solid #CDCDCD;
	background-color: #F8F8FF;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<%
		//Ham de lay ma san pham truyen qua tren thanh dia chi 
		String ma_san_pham ="";
	if(request.getParameter("ma_san_pham")!=null){
	  ma_san_pham = request.getParameter("ma_san_pham");
	
	}
	ProductDAOImpl productDAO = new ProductDAOImpl();
	NumberFormat nf = NumberFormat.getInstance();
	nf.setMinimumFractionDigits(0);
	%>
	<div id="main">
		<div id="head">
			<img src="images/banner.jpg" width="1057px" height="200px" />
		</div>
		<%
		
		String username =null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username"))
					username = cookie.getValue();
			}
		}
		
		if(username !=null){
		%>
		<div id="head-link">
			<div id='menungang'>
				<ul>
					<li class='last'><a href="index.jsp"><span>Trang chủ</span></a></li>
					<li class='last'><a href=""><span>Sản Phẩm</span></a></li>
					<li class='last'><a href="cart.jsp"><span>Giỏ Hàng</span></a></li>
					<li class='last'><a href="search_page.jsp"><span>Tìm Kiếm</span></a></li>
					<li class='last' style="float: rigth;"><a href="LogoutServlet"><span>Đăng Xuất</span></a></li>
				    <li class='last' style="float: rigth;"><a href="update_user.jsp?username=<%=username%>"><span><%=username %></span></a></li>
				</ul>
			</div>
		</div>
		
		<%
		}else{
		%>
		
		<div id="head-link">
			<div id='menungang'>
				<ul>
				<li class='last'><a href="index.jsp"><span>Trang Chủ</span></a></li>
				<li class='last'><a href=""><span>Sản Phẩm</span></a></li>
				<li class='last'><a href="search_page.jsp"><span>Tìm Kiếm</span></a></li>
				<li class='last' style="float: rigth;"><a href="register.jsp"><span>Đăng Ký</span></a></li>
				<li class='last' style="float: rigth;"><a href="login.jsp"><span>Đăng Nhập</span></a></li>	
				</ul>
			</div>
		</div>
		<%
			}
		%>
		<div id="content">
		
		<div class="left-1">
		<img
		  src="sanpham/<%=productDAO.getProduct(Integer.parseInt(ma_san_pham)).getHinh_anh() %>" width="200px" height="200px" />
		</div>
		<div class="left-2">
		<table>
		<tr class="row1">
		<td class="col2" colspan="2"
		style="padding:10px; color:blue; font-size: 15px; text-transform: uppercase;text-align: center; font-weight: bold">
			<%=productDAO.getProduct(Integer.parseInt(ma_san_pham)).getTen_san_pham() %></td>
			</tr>
			
			<tr class="row2">
						<td class="col1">Hãng sản xuất:</td>
						<td class="col2"><%=productDAO.getProduct(Integer.parseInt(ma_san_pham))
					.getHang_san_xuat()%></td>
					</tr>
					
		    <tr class="row2">
		    <td class="rol1">Gia ban: </td>
		    <td class="col2"><%=nf.format(productDAO.getProduct(Integer.parseInt(ma_san_pham)).getGia_ban()) %> VND</td></tr>
		  
		</table>
		</div>
		
		<% if(username !=null){%>
		<div
				style="margin-left: auto; margin-right: auto; text-align: center; margin-top: 10px; padding: 10px; clear: both;">
		<a href="login.jsp"><img 
		                src="images/giohang.png" /> </a>
		</div>
		<%} %>
		<div class="left-3">
		<article> <input type="checkbox" id="read_more"
					role="button"> <label for="read_more" onclick=""
					style="width: 770px; margin-left: 150px; margin-right: auto;"><span>Xem
						thông tin chi tiết</span> <span>Đóng</span></label> <section>
						
		<table>
		<!-- Thong tin chung -->
		<tr rowspan = "2">
		<td class="detail-1">Thong tin chi tiet</td>
		<td class="detail-2">Dang cap nhat</td>
		</tr>
		
		</table>
		</section></article>
		</div>
		</div>
		<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
		</div>
		</body>
</html>