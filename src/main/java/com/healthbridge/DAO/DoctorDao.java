package com.healthbridge.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthbridge.entity.Doctor;

public class DoctorDao {
	private Connection con;
	
	public DoctorDao(Connection con)
	{
		super();
		this.con=con;
	}
	public boolean registerDoctor(Doctor d)
	{
		boolean f=false;
		try {
			String sql="insert into doctor(fullName,dob,qualification,specialist,email,mobile,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2,d.getDob());
			ps.setString(3,d.getQualification());
			ps.setString(4,d.getSpecialist());
			ps.setString(5,d.getEmail());
			ps.setString(6,d.getMobNo());
			ps.setString(7,d.getPassword());
			int i= ps.executeUpdate();
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
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> list=new ArrayList<Doctor>();
		Doctor d=null;
		try {
			String sql="select * from doctor order by id desc";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Doctor getDoctorById(int id)
	{
		Doctor d=null;
		try {
			String sql="select * from doctor where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return d;
		
		
		
	}
	public boolean updateDoctor(Doctor d)
	{
		boolean f=false;
		try {
			String sql="update doctor set fullName=? ,dob=? ,qualification=? ,specialist=? ,email=? ,mobile=? ,password=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2,d.getDob());
			ps.setString(3,d.getQualification());
			ps.setString(4,d.getSpecialist());
			ps.setString(5,d.getEmail());
			ps.setString(6,d.getMobNo());
			ps.setString(7,d.getPassword());
			ps.setInt(8,d.getId());
			int i= ps.executeUpdate();
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
	
	public boolean deleteDoctor(Doctor d)
	{
		boolean f=false;
		try
		{
		int id=d.getId();
		String sql="delete from doctor where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		int i= ps.executeUpdate();
		if(i==1)
		{
			f=true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	public Doctor login(String email,String passw)
	{
		Doctor d=null;
		try {
			String sql="select * from doctor where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, passw);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return d;
	}
	public int changePassword(int id,String old_password,String new_password)
	{
		int i=0;
		String sql="select * from doctor where id=? and password=?";
		System.out.println("Inside change password");
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,old_password);
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
			{
				System.out.println("returning 0");
				return i;
			}
			else
			{
				System.out.println("Inside else");
				String sql2="update doctor set password=? where id=?";
				ps=con.prepareStatement(sql2);
				ps.setString(1, new_password);
				ps.setInt(2, id);
				i=ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return i;
	}

}
