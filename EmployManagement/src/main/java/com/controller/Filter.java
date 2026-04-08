package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.EmployDetails;
import com.service.EmployService;
@WebServlet("/search")
public class Filter extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	   String value=req.getParameter("value");
	   EmployService service = new EmployService();
	   System.out.println(value);
	   List<EmployDetails> details=service.filterDetails(value);
	   HttpSession session = req.getSession();
	   session.setAttribute("details", details);
	   RequestDispatcher dis =req.getRequestDispatcher("DisplayAllDetails.jsp");
	   dis.forward(req, resp);
}
}
