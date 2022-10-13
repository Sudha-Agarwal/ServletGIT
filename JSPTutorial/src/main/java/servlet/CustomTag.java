package servlet;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
 
/**
 * This class is used for defining a custom tag.
 */
public class CustomTag extends SimpleTagSupport{
	public void doTag() throws JspException, IOException {
      JspWriter out = getJspContext().getOut();
      out.println("This is our first custom tag.");
   }
}