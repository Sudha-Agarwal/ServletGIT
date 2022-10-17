package filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter(urlPatterns = "/HttpSessionValidate")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		/*
		 * String uri = req.getRequestURI();
		 * this.context.log("Requested Resource::"+uri);
		 * 
		 * HttpSession session = req.getSession(false);
		 * 
		 * if(session == null && !(uri.endsWith("html") ||
		 * uri.endsWith("LoginServlet"))){
		 * this.context.log("Unauthorized access request");
		 * res.sendRedirect("index.jsp"); }else{ // pass the request along the filter
		 * chain chain.doFilter(request, response); }
		 */

		PrintWriter out=response.getWriter();  

		String password=request.getParameter("pass");  
		if(password.equals("1234")){  
			chain.doFilter(request, response);//sends request to next resource  
		}  
		else{  
			out.print("username or password error!");  
			//res.sendRedirect("index.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.include(request, response);  
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//this.context = fConfig.getServletContext();
		//this.context.log("AuthenticationFilter initialized");
	}

}
