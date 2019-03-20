package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.RequestDumperFilter;

import dao.UserDAOImpl;
import model.Cart;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAOImpl userDAO = new UserDAOImpl();
    private List<Cart> cart = new ArrayList<Cart>();
    
    public LoginServlet() {
        super();
 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String err="";
		if(username.equals("") || password.equals("")) {
			err += "Phai nhap day du thong tin";
		}else {
			if(userDAO.login(username, password) == false) {
				err += "Sai thong tin hoac mat khau khong chinh xac";
			}
		}
		
		if(err.length() >0) {
			request.setAttribute("err", err);
		}
		String url="/login.jsp";
		
		try {
			if(err.length() ==0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("cart", cart);
                 userDAO.login(username, password);
                 Cookie loginCookie = new Cookie("username",username);
                 loginCookie.setMaxAge(30*60);
                 response.addCookie(loginCookie);
                 response.sendRedirect("index.jsp");
                 url="/index.jsp";
			}else {
				url="/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login.jsp");
		}
	}

}
