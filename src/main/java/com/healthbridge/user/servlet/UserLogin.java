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

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			HttpSession session=req.getSession();
			//session.setAttribute("userObj", null);
			UserDao dao=new UserDao(DBConnect.getConnection());
			User user= dao.login(email, password);
			if(user != null)
			{
				System.out.println("connection done and data fetched.");
				session.setAttribute("userObj", user);
				resp.sendRedirect("index.jsp");
				
			}
			else
			{
				session.setAttribute("emsg", "Invalid Email & Password");
				resp.sendRedirect("user_login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
