package com.healthbridge.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.DoctorDao;
import com.healthbridge.DAO.UserDao;
import com.healthbridge.db.DBConnect;
@WebServlet("/ChangeDoctorPassword")
public class ChangeDoctorPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int did=Integer.parseInt(req.getParameter("did"));
		String old_password=req.getParameter("oldPassword");
		String new_password=req.getParameter("newPassword");
		DoctorDao dao=new DoctorDao(DBConnect.getConnection());
		int i=dao.changePassword(did, old_password, new_password);
		System.out.println("\n"+i);
		HttpSession session=req.getSession();
		if(i==1)
		{
			session.setAttribute("change_password","Password Updated Successfully");
			session.removeAttribute("doctObj");
			resp.sendRedirect("doctor_login.jsp");
		}
		else
		{
			session.setAttribute("change_password","Some Error Occured!");
			session.removeAttribute("doctObj");
			resp.sendRedirect("doctor_login.jsp");
		}
	}
	
}
