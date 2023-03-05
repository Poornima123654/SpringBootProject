package com.example.demo.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.example.demo.dbutil.DBUtil;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService
{

     Connection connection;
     
     int flag=0;
     
     public UserServiceImpl() throws SQLException
     {
    	 connection =DBUtil.getConnection();
     }
     
	@Override
	public int loginValidation(String username,String password)
	{
		try 
		{
			PreparedStatement statement = connection.prepareStatement("select * from users where username = '" + username+"'");
		    ResultSet rs = statement.executeQuery();
		    
		    while(rs.next())
		    {
		    	if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
		    	{
		    	    flag = 1;
		    	}
		    	else
		    	{
		    		System.out.println("Invalid username/password");
		    	}
		    }
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}	
}
