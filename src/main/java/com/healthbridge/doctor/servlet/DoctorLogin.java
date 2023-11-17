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
import com.healthbridge.entity.Doctor;
import com.healthbridge.entity.User;
@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			HttpSession session=req.getSession();
			//session.setAttribute("userObj", null);
			DoctorDao dao=new DoctorDao(DBConnect.getConnection());
			Doctor doctor = dao.login(email, password);
			if(doctor != null)
			{
				System.out.println("connection done and data fetched.");
				session.setAttribute("doctObj", doctor);
				resp.sendRedirect("doctor/index.jsp");
				
			}
			else
			{
				session.setAttribute("emsg", "Invalid Email & Password");
				resp.sendRedirect("doctor_login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
