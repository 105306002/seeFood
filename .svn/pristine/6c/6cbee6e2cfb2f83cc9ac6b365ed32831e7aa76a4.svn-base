import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Main  extends HttpServlet{
    //main method
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        
		 System.out.println("Thank you SeeFood");
		 
		 while(scanner.hasNextLine()){
	        	String keyword = scanner.nextLine();
	        	GoogleQuery gq = new GoogleQuery(keyword);
	        	
	        	long a = System.currentTimeMillis();
	        	ArrayList<Rerank> ans= gq.query();
	        	gq.printResult(ans);
	        	System.out.println("Thank you SeeFood");
	        	long b = System.currentTimeMillis();
	            System.out.print("Searching time : " + (b - a)/1000 + " seconds");
	     }
	     scanner.close();
    }
	
	
	
	//webize
//    public void init(){
//    	
//    }
//    
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//    	response.setContentType("text/html");
//    	
//    	PrintWriter out = response.getWriter();
//    	String keyword = request.getParameter("inputKyw");
//    	
//    	out.println("<h1>Here is your result: <br>" + printResult(keyword) + "</h1>");
//    }
//    
//    //¦L¥Xµ²ªG
  	
  	
  	
}
