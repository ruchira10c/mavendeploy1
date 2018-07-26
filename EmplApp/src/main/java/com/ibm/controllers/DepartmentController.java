package com.ibm.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.DepartmentDAO;
import com.ibm.model.Department;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/departments")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get location id from the form
		int locid = Integer.parseInt(request.getParameter("loc"));
		//get the list of dept from dao based o loc id
		DepartmentDAO dao = new DepartmentDAO();
		ArrayList<Department> depts =dao.getDeptbyLoc(locid);
		//add the list as a request attribute
		request.setAttribute("depts", depts);
		//forward the request
		RequestDispatcher dispatch = request.getRequestDispatcher("departmentList2.jsp");
		dispatch.forward(request, response);
	}

	

}
