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
@WebServlet("/ChangeUserPassword")
public class ChangeUserPassword extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid=Integer.parseInt(req.getParameter("uid"));
		String old_password=req.getParameter("oldPassword");
		String new_password=req.getParameter("newPassword");
		UserDao dao=new UserDao(DBConnect.getConnection());
		int i=dao.changePassword(uid, old_password, new_password);
		System.out.println("\n"+i);
		HttpSession session=req.getSession();
		if(i==1)
		{
			session.setAttribute("change_password","Password Updated Successfully");
			session.removeAttribute("userObj");
			resp.sendRedirect("user_login.jsp");
		}
		else
		{
			session.setAttribute("change_password","Some Error Occured!");
			session.removeAttribute("userObj");
			resp.sendRedirect("user_login.jsp");
		}
	}
	
}
