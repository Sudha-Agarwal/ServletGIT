package listners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String path = sc.getInitParameter("path");
		String mode = sc.getInitParameter("mode");
		sc.setAttribute("filePath", path);
		sc.setAttribute("fileMode", mode);
		System.out.println("Value saved in context.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute("path");
		sc.removeAttribute("mode");
		System.out.println("Value deleted from context.");
	}

}
