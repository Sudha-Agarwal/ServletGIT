package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeHttpSession
 */
@WebServlet("/WelcomeHttpSession")
public class WelcomeHttpSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeHttpSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();
	        String user = (String)session.getAttribute("user");
	        
	        long creationTime = 0;
	        long lastAccessedTime = 0;
	        int maxInactiveInterval = 0;
	        
	        out.println("Hello "+user);
	        
	        if (session != null) {
	            creationTime = session.getCreationTime();
	            lastAccessedTime = session.getLastAccessedTime();
	            maxInactiveInterval = session.getMaxInactiveInterval();
	        }
	        
			/*
			 * out.println("creationTime: " + creationTime);
			 * out.println("lastAccessedTime: " + lastAccessedTime);
			 * out.println("maxInactiveInterval: " + maxInactiveInterval);
			 */
	        
	        
	        Integer attribute=(Integer)session.getAttribute("attribute");
	        if (attribute == null)
	        {
	                    attribute = Integer.valueOf(1);
	                    out.println("<h1><center>NewUser</center></h1>");
	        } else {
	        	out.println("<h1><center>Welcome back</center></h1>");
	                    attribute = Integer.valueOf(attribute.intValue() + 1);
	        }
	        session.setAttribute("attribute",attribute);
	        session.setMaxInactiveInterval(10);
	        
	                
	        out.println("<h2>Session id:"+session.getId()+"</h2>");
	        out.println("<h2>Session Creation Time:"+new Date(creationTime)+"</h2>");
	        out.println("<h2>Servlet last accessed time:"+new Date(session.getLastAccessedTime())+"</h2>");
	        out.println("<h2>Max Inactive Interval:"+session.getMaxInactiveInterval()+"</h2>");
	        out.println("<h2>Number of time visit:"+attribute+"</h2>");
	        
	}

}
