package com.healthbridge.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthbridge.entity.Specialist;



public class SpecialistDao {
	private Connection con;

	public SpecialistDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean addSpecialist(String spec) throws SQLException
	{
		Statement st=null;
		PreparedStatement ps=null;
		boolean f=false;
		try {
			String sql1="select * from specialist where spec_nam=?";
			System.out.println("Inside try sql1");
			ps=con.prepareStatement(sql1);
			ps.setString(1,spec);
			ResultSet rs=ps.executeQuery();
			System.out.println("after execute Query");
			if(rs.next())
			{
				ps.close();
				con.close();
				return f;
			}
			else
			{
			
			String sql2="insert into specialist(spec_nam) values(?)";
			ps=con.prepareStatement(sql2);
			ps.setString(1,spec);
			int i=ps.executeUpdate();
			if(i==1)
			{
				ps.close();
				con.close();
				f=true;
			}
			}
			
			
			
		}catch (Exception e) {
//			st.close();
//			ps.close();
			
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	public List<Specialist> getAllSpecialist()
	{
		List<Specialist> list=new ArrayList<Specialist>();
		Specialist s=null;
		try
		{
			String sql="Select * from specialist";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Specialist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return list;
		
		
		
		
	}
	
	

}
