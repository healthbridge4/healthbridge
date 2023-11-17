package com.healthbridge.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.DoctorDao;
import com.healthbridge.db.DBConnect;
import com.healthbridge.entity.Doctor;
@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName=req.getParameter("fullname");
			String dob=req.getParameter("dob");
			String qualification=req.getParameter("qualification");
			String specialist=req.getParameter("spec");
			String email=req.getParameter("email");
			String mobile=req.getParameter("mobile");
			String password=req.getParameter("password");
			Doctor doctor=new Doctor(fullName,dob,qualification,specialist,email,mobile,password);
			DoctorDao dao=new DoctorDao(DBConnect.getConnection());
			boolean val= dao.registerDoctor(doctor);
			HttpSession session=req.getSession();
			if(val)
			{
				session.setAttribute("docregister", "Successfully Registered");
				resp.sendRedirect("admin/doctor.jsp");
			}
			else
			{
				session.setAttribute("docregister", "Something wrong occured!");
				resp.sendRedirect("admin/doctor.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
