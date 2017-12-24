package com.broadway.studentproject.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.broadway.studentproject.service.UserService;
import com.broadway.studentproject.service.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("uname")) {
				request.setAttribute("username", cookie.getValue());
			} else if(cookie.getName().equals("pass")) {
				request.setAttribute("password", cookie.getValue());
			}
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		request.setAttribute("LogOutMsg", "Sucessfully Logout");
		rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String rememberMe = request.getParameter("remember-me");
		
		int isUser = userService.checkUser(userName, password);
		
		if (isUser > 0) {
			if(rememberMe!=null) {
				Cookie cookie1 = new Cookie("uname",userName);
				Cookie cookie2 = new Cookie("pass",password);
				cookie1.setMaxAge(24*60*60);
				cookie2.setMaxAge(24*60*60);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginfail", "wrong username or password");
			rd.include(request, response);
		}
	}

}
