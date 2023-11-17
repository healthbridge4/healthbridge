package com.healthbridge.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.UserDao;
import com.healthbridge.db.DBConnect;
import com.healthbridge.entity.User;
@WebServlet("/user_register")
public class UserRegister extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			User u=new User(fullName,email,password);
			
			UserDao dao=new UserDao(DBConnect.getConnection());
			HttpSession session=req.getSession();
			
			
			boolean f=dao.register(u);
			if(f) {
				session.setAttribute("smsg","Registered Successfully");
				resp.sendRedirect("signup.jsp");
			}
			else
			{
				session.setAttribute("emsg", "Something wrong on server");
				resp.sendRedirect("signup.jsp");
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
}
