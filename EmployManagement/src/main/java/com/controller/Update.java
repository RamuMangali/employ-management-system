package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.EmployDetails;
import com.service.EmployService;
@WebServlet("/update")
public class Update extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	   EmployService service= new EmployService();
	   
	   int id=Integer.parseInt(req.getParameter("Id"));
	   System.out.println("update"+id);
	   EmployDetails details=service.update(id);
	   HttpSession session = req.getSession();
	   session.setAttribute("Details", details);
	   System.out.println("update"+details);
	   RequestDispatcher dispatcher= req.getRequestDispatcher("Update.jsp");
	   dispatcher.forward(req, resp);
	   
	   
}
}
