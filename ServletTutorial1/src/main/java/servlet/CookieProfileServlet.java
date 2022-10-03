package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieProfileServlet
 */
@WebServlet("/CookieProfileServlet")
public class CookieProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		System.out.println("profile");

		request.getRequestDispatcher("CookieMenu.html").include(request, response);  

		Cookie ck[]=request.getCookies();  
		System.out.println(ck);
		
		for(int i=0; i<ck.length; i++) {
			Cookie cookie = ck[i];
			System.out.println(cookie.getName());

			if(cookie.getName().equals("loginname")) {
				String name=cookie.getValue(); 
				System.out.println(name);
				if(!name.equals("")||name!=null){  
					out.print("<b>Welcome to Profile</b>");  
					out.print("<br>Welcome, "+name);  	
					break;
				  
			}
			}
	
			
			else {
				out.print("Please login first");  
	            request.getRequestDispatcher("cookieLogin.html").include(request, response);
	            break;
				
			}
			
		}

		out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
