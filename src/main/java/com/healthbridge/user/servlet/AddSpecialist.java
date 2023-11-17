package com.healthbridge.user.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthbridge.DAO.SpecialistDao;
import com.healthbridge.db.DBConnect;
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName=req.getParameter("specName");
		
		SpecialistDao dao=new SpecialistDao(DBConnect.getConnection());
		System.out.println("After connection in addspecialist.java");
		System.out.println("Now calling addSpecialistMethod in SpecialistDao");
		boolean f=false;
		try {
			f = dao.addSpecialist(specName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result fetched "+f );
		HttpSession session=req.getSession();
		if(f)
		{
			session.setAttribute("msg_specialist", "Successfully Added");
			resp.sendRedirect("admin/admin_index.jsp");
			
		}
		else
		{
			session.setAttribute("msg_specialist", "Something went wrong");
			resp.sendRedirect("admin/admin_index.jsp");
		}
	}
	

}
