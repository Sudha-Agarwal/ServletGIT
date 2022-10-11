package com.learning.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.learning.Bean.Employee;
import com.learning.DAO.EmployeeDAO;

/**
 * Servlet implementation class SaveServlet
 */

@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDao;	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveServlet() {
		super();

	}

	public void init() {
		employeeDao = new EmployeeDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setContact(contact);
		employee.setAddress(address);

		try {
			int status = employeeDao.registerEmployee(employee);
	        if(status>0){  
	        	pw.println("<h1>Employee successfully registered!</h1>");
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	        	pw.println("<h1>Sorry! unable to save record<h1>");  
	        	 request.getRequestDispatcher("index.html").include(request, response);  
	        } 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pw.println("<h1>SQL Exception</h1>");
			e.printStackTrace();
		}
		
		 //request.getRequestDispatcher("index.html").include(request, response);
	}
}


