package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLogin
 */
@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        request.getRequestDispatcher("CookieMenu.html").include(request, response);  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        if(password.equals("123")){  
	            out.print("You are successfully logged in!");  
	            out.print("<br>Welcome, "+name);  
	              
	            Cookie ck=new Cookie("loginname",name);  
	            response.addCookie(ck);  
	        }else{  
	            out.print("sorry, username or password error!");  
	            request.getRequestDispatcher("cookieLogin.html").include(request, response);  
	        }  
	          
	        out.close();  
	    }  
	}


