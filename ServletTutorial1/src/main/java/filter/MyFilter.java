/*
 * package filter;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import jakarta.servlet.Filter; import jakarta.servlet.FilterChain; import
 * jakarta.servlet.FilterConfig; import jakarta.servlet.ServletException; import
 * jakarta.servlet.ServletRequest; import jakarta.servlet.ServletResponse;
 * import jakarta.servlet.annotation.WebFilter; import
 * jakarta.servlet.http.HttpServlet;
 * 
 *//**
	 * Servlet Filter implementation class MyFilter
	 */
/*
 * @WebFilter("/MyFilter") public class MyFilter implements Filter {
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public MyFilter() { super(); // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see Filter#destroy()
	 */
/*
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 *//**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
/*
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException { PrintWriter
 * out=response.getWriter(); out.print("filter is invoked before");
 * 
 * chain.doFilter(request, response);//sends request to next resource
 * 
 * out.print("filter is invoked after"); }
 * 
 *//**
	 * @see Filter#init(FilterConfig)
	 *//*
		 * public void init(FilterConfig fConfig) throws ServletException { // TODO
		 * Auto-generated method stub }
		 * 
		 * }
		 */