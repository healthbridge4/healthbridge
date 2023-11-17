package com.healthbridge.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthbridge.entity.Appointment;

public class AppointmentDao {
	private Connection con;
	public AppointmentDao(Connection con)
	{
		super();
		this.con=con;
		
	}
	public boolean addAppointment(Appointment ap)
	{
		boolean f=false;
		try {
			String sql = "insert into appointment(user_id,fullName,gender,age,appoinDate,email,mobile,disease,doctorId,address,statuss) values(?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3, ap.getGender());
			ps.setInt(4, ap.getAge());
			ps.setString(5, ap.getAppoinDate());
			ps.setString(6,ap.getEmail());
			ps.setString(7, ap.getMobile());
			ps.setString(8,ap.getDiseases());
			ps.setInt(9,ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11,ap.getStatus());
			
			int i=ps.executeUpdate();
			if(i==1)
				f=true;
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		return f;
	}

	public List<Appointment> getAppointmentOfUser(int userId)
	{
		List<Appointment> list=new ArrayList<Appointment>();
		Appointment ap=null;
		try 
		{
			String sql="select * from appointment where user_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobile(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	public List<Appointment> getAppointmentOfDoctor(int doctorId)
	{
		List<Appointment> list=new ArrayList<Appointment>();
		Appointment ap=null;
		try 
		{
			String sql="select * from appointment where doctorId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, doctorId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobile(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public Appointment getAppointmentDetailsById(int id)
	{
		
		Appointment ap=null;
		try 
		{
			String sql="select * from appointment where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobile(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ap;
		
	}
	
	public boolean updateStatus(String status,int id,int did)
	{
		boolean f=false;
		String sql="update appointment set statuss=? where id=? and doctorId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,status);
			ps.setInt(2,id);
			ps.setInt(3, did);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
		
		
		
		return f;
	}
	
	public List<Appointment> getAllAppointment( )
	{
		List<Appointment> list=new ArrayList<Appointment>();
		Appointment ap=null;
		try 
		{
			String sql="select * from appointment";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobile(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
