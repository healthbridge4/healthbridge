package com.healthbridge.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			HttpSession session=req.getSession();
			if("admin@gmail.com".equals(email) && "admin".equals(password))
			{
				session.setAttribute("adminObj", "loggedin");
				resp.sendRedirect("admin/admin_index.jsp");
				
			}
			else
			{
				session.setAttribute("emsg", "Invalid Email & Password");
				resp.sendRedirect("admin_login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
