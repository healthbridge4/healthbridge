package com.healthbridge.DAO;

import java.sql.*;

import com.healthbridge.entity.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean register(User u)
	{
		boolean f= false;
		try {
			String query="insert into user_details(full_name,email,password) values(?,?,?);";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,u.getFullName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
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

	public User login(String email,String pass)
	{
		User u=null;
		try {
			String query="select * from user_details where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setId(rs.getInt(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		{
			
		}
		
		
		
		return u;
	}
	public int changePassword(int id,String old_password,String new_password)
	{
		int i=0;
		String sql="select * from user_details where id=? and password=?";
		System.out.println("Inside change password");
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2,old_password);
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
				return i;
			else
			{
				String sql2="update user_details set password=? where id=?";
				ps=con.prepareStatement(sql2);
				ps.setString(1, new_password);
				ps.setInt(2, id);
				i=ps.executeUpdate();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

}
