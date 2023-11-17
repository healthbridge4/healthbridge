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
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		Doctor d=new Doctor();
		d.setId(id);
		DoctorDao dao=new DoctorDao(DBConnect.getConnection());
		boolean val=dao.deleteDoctor(d);
		HttpSession session=req.getSession();
		if(val)
		{
			session.setAttribute("docdelete", "Successfully deleted");
			resp.sendRedirect("admin/doctor.jsp");
		}
		else
		{
			session.setAttribute("docdelete", "Something wrong occured!");
			resp.sendRedirect("admin/doctor.jsp");
		}
		
	}
	
	
	
	
	
}
