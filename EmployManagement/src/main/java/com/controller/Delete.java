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
@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		EmployService service = new EmployService();
		int id=Integer.parseInt(req.getParameter("Id"));
		//System.out.println(id);
		service.deleteData(id);
		List<EmployDetails> Details=service.allDetails();
		HttpSession session = req.getSession();
		session.setAttribute("details", Details);
		RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayAllDetails.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
