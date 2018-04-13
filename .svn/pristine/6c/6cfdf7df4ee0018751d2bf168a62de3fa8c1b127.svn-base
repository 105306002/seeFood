import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Webize extends HttpServlet{
    private String message;
    
    public void init(){
    	this.message = "Thank You SeeFood";
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	
    	response.setContentType("text/html");
    	//response.sendError(HttpServletResponse.SC_NOT_FOUND, "µ§°O¤å¥ó");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println("<h1>" + message + "</h1>");
    	out.println("<form action=\"/Main\"method=\"GET\">");
    	out.println("<input type=\"text\" name=\"inputKyw\">");
    	out.println("<input type=\"submit\" value=\"search\">");
    	out.println("</form>");
    	out.println("<h1>" + message + "</h1>");
    }
}
