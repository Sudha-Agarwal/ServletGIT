package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class WelcomeGeneric
 */
@WebServlet("/WelcomeGeneric")
public class WelcomeGeneric extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	ServletConfig config=null;
	
	   public void init(ServletConfig config){
	      this.config=config;
	      System.out.println("Initialization complete");
	   }

    public WelcomeGeneric() {
        super();        
    }


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");
	       PrintWriter pwriter=res.getWriter();
	       pwriter.print("<html>");
	       pwriter.print("<body>");
	       pwriter.print("<h1>Servlet Example Program</h1>");
	       pwriter.print("</body>");
	       pwriter.print("</html>");
		
	}	
	   public void destroy(){
	       System.out.println("servlet life cycle finished");
	   }
	   public ServletConfig getServletConfig(){
	       return config;
	   }
	   public String getServletInfo(){
	       return "A Demo program written by Chaitanya";
	   }

}
