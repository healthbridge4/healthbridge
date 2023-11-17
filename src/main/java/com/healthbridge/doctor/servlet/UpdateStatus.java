package com.healthbridge.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.AppointmentDao;
import com.healthbridge.db.DBConnect;
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status=req.getParameter("comm");
		int appointment_id=Integer.parseInt(req.getParameter("id"));
		int doctor_id=Integer.parseInt(req.getParameter("did"));
		AppointmentDao dao=new AppointmentDao(DBConnect.getConnection());
		boolean f=dao.updateStatus(status, appointment_id, doctor_id);
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("comment_status","Comment Updated");
			resp.sendRedirect("doctor/patient.jsp");
		}
		else
		{

			session.setAttribute("comment_status","Something Wrong On Server");
			resp.sendRedirect("doctor/patient.jsp");
		}
		
		
		
		
	}

	
	
	
}
