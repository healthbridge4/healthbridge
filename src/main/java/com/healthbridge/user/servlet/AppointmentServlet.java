package com.healthbridge.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.AppointmentDao;
import com.healthbridge.db.DBConnect;
import com.healthbridge.entity.Appointment;
@WebServlet("/bookAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userid"));
		String fullName=req.getParameter("fullname");
		String gender=req.getParameter("gender");
		int age=Integer.parseInt(req.getParameter("age"));
		String appointmentDate=req.getParameter("appoint_date");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String disease=req.getParameter("disease");
		int doctorId=Integer.parseInt(req.getParameter("doct"));
		String address=req.getParameter("address");
		Appointment ap=new Appointment(userId,fullName,gender,age,appointmentDate,email,mobile,disease,doctorId,address,"pending");
		AppointmentDao dao=new AppointmentDao(DBConnect.getConnection());
		boolean f=dao.addAppointment(ap);
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("appointment_book","Appointment Successfully Booked");
			resp.sendRedirect("user_appointment.jsp");
		}
		else
		{
			session.setAttribute("appointment_book", "Some Error Occurred");
			resp.sendRedirect("user_appointment.jsp");
		}
		
		
		
	}
	

}
