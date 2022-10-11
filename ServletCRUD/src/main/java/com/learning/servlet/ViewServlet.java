package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.learning.Bean.Employee;
import com.learning.DAO.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		out.println("<a href='index.html'>Add New Employee</a>");  
		out.println("<h1>Employees List</h1>");  

		List<Employee> list=EmployeeDAO.getAllEmployeesCallable();  

		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>First Name</th><th>Last Name</th><th>UserName</th><th>Address</th></tr>");  
				for(Employee e:list){  
					out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+
							"</td><td>"+e.getUsername()+"</td><td>"+e.getAddress()+"</td></tr>");  
				}  
				out.print("</table>");  

				out.close();  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		out.println("<a href='index.html'>Add New Employee</a>");  
		out.println("<h1>Employees List</h1>");  
		
		int id = Integer.valueOf(request.getParameter("id"));

		Employee e=EmployeeDAO.getAllEmployeeByIdCallable(id);  

		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>First Name</th><th>Last Name</th><th>UserName</th><th>Address</th></tr>");  
				  
					out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+
							"</td><td>"+e.getUsername()+"</td><td>"+e.getAddress()+"</td></tr>");  
				  
				out.print("</table>");  

				out.close();  
	}

}
