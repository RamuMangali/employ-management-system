package com.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.EmployDetails;

public class EmployDao {

	private static final String url="jdbc:mysql://localhost:3306/bank_management_system";
	private static final String query="insert into employ(Id,Name,Email,Mobile,Gender,Address,Password) values(?,?,?,?,?,?,?)";
	private static final String quert1="select * from employ";
	private static final String query4="update employ set Name=?,Email=?,Mobile=?,Address=?,Password=? where Id=?";
	private static final String query5="select * from employ where Name=? or Email=? or Mobile=? or Gender=? or Address=? or Password=?";
	

	public void inserEmployDetails(EmployDetails ed2) {
		// TODO Auto-generated method stub
		
		int id=ed2.getId();
		String name=ed2.getName();
		String email=ed2.getEmail();
		long mobile=ed2.getMobile();
		String gender=ed2.getGender();
		String address=ed2.getAddress();
		String password=ed2.getPassword();
		//System.out.println(id);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, mobile);
			ps.setString(5, gender);
			ps.setString(6, address);
			ps.setString(7, password);
			ps.execute();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.println("executed successfully");
		
	}



	public List<EmployDetails> getAllDetails() {
		// TODO Auto-generated method stub
		
		List<EmployDetails> details= new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();
			ResultSet rs=  st.executeQuery(quert1);
			while(rs.next()) {
				EmployDetails det=new EmployDetails();
				det.setId(rs.getInt("Id"));
				det.setName(rs.getString("Name"));
				det.setEmail(rs.getString("Email"));
				det.setMobile(rs.getLong("Mobile"));
				det.setGender(rs.getString("Gender"));
				det.setAddress(rs.getString("Address"));
				det.setPassword(rs.getString("Password"));
				details.add(det);
//				System.out.println("Getting all Dtails"+details);
		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return details;
		
	}



	public void deleteDetails(int id) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,"root","root");
			Statement st = con.createStatement();
			st.execute("delete from employ where Id="+id);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}



	public EmployDetails updateDetails(int id) {
		   EmployDetails details= new EmployDetails();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			String query3="select * from employ where Id="+id;
			PreparedStatement ps= con.prepareStatement(query3);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				details.setId(rs.getInt("Id"));
				details.setName(rs.getString("Name"));
				details.setEmail(rs.getString("Email"));
				details.setMobile(rs.getLong("Mobile"));
				details.setGender(rs.getString("Gender"));
				details.setAddress(rs.getString("Address"));
				details.setPassword(rs.getString("Password"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return details;
		// TODO Auto-generated method stub
		
	}



	public void updatedet(EmployDetails ed) {
		// TODO Auto-generated method stub
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","root");
			 PreparedStatement ps= con.prepareStatement(query4);
			 ps.setString(1, ed.getName());
			 ps.setString(2, ed.getEmail());
			 ps.setLong(3, ed.getMobile());
			 ps.setString(4, ed.getAddress());
			 ps.setString(5, ed.getPassword());
			 ps.setInt(6, ed.getId());
			 ps.execute();
			 
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}



	public List<EmployDetails> filterDet(String value) {
		// TODO Auto-generated method stub
		List<EmployDetails> list= new ArrayList<>();
		   EmployDetails details= new EmployDetails();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","root");
			PreparedStatement ps= con.prepareStatement(query5);
			ps.setString(1, value);
			ps.setString(2, value);
			ps.setString(3, value);
			ps.setString(4, value);
			ps.setString(5, value);
			ps.setString(6, value);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmployDetails det=new EmployDetails();
				details.setId(rs.getInt("Id"));
				details.setName(rs.getString("Name"));
				details.setEmail(rs.getString("Email"));
				details.setMobile(rs.getLong("Mobile"));
				details.setGender(rs.getString("Gender"));
				details.setAddress(rs.getString("Address"));
				details.setPassword(rs.getString("Password"));
				list.add(details);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}







	
	

}
