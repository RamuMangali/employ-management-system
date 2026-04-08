package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmployDetails;
import com.service.EmployService;
@WebServlet("/updateUser")
public class SendUpdate extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	  EmployService service= new EmployService();
  	EmployDetails ed = new EmployDetails();
  	int id=Integer.parseInt(req.getParameter("id"));
  	String name=req.getParameter("name");
  	String email=req.getParameter("email");
  	long mobile=Long.parseLong(req.getParameter("mobile"));
  	String address=req.getParameter("address");
  	String password=req.getParameter("pass");
      
  	ed.setId(id);
  	ed.setName(name);
  	ed.setEmail(email);
  	ed.setMobile(mobile);
  	ed.setAddress(address);
  	ed.setPassword(password);
  	System.out.println(ed+"send update");
  	
  	service.updateDetails(ed);
  	RequestDispatcher dispatcher= req.getRequestDispatcher("alluserdetails");
  	dispatcher.forward(req, resp);
	  
}
}
