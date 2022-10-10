package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet(urlPatterns = "/ImageUploadServlet",
			initParams = {
					@WebInitParam(name="SaveDir", value="C:/FileUpload"),
					@WebInitParam(name="allowedTypes", value="jpg,jpeg,gif,png")
			}

		)
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletConfig config=getServletConfig();  
		
		String saveDir = getInitParameter("SaveDir");		
        String fileTypes = getInitParameter("allowedTypes");
 
        PrintWriter writer = response.getWriter();
 
        writer.println("saveDir = " + saveDir);
        writer.println("fileTypes = " + fileTypes);
        
        String path = getServletContext().getInitParameter("path");
        writer.println("Path:" + path);
        
        writer.println("Servlet Name: " + getServletName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
