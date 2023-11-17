package com.healthbridge.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllCount {
	private Connection con;

	public GetAllCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllCount(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Integer> GetTotalCount() throws SQLException
	{
	Statement st=null;
	ResultSet rs=null;
	List<Integer> list=new ArrayList<Integer>();
	try {
		st=con.createStatement();
		rs=st.executeQuery("select count(*) from doctor");
		rs.next();
		int doctor_count=rs.getInt(1);
		rs=st.executeQuery("select count(*) from user_details");
		rs.next();
		int user_count=rs.getInt(1);
		rs=st.executeQuery("select count(*) from appointment");
		rs.next();
		int appointment_count=rs.getInt(1);
		rs=st.executeQuery("select count(*) from specialist");
		rs.next();
		int specialist_count=rs.getInt(1);
		list.add(doctor_count);
		list.add(user_count);
		list.add(appointment_count);
		list.add(specialist_count);
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally
	{
		st.close();
		con.close();
	}
		
		
		return list;
	}
	

}
