package test;

import java.io.IOException;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{

		String name = req.getParameter("userName");
		String email = req.getParameter("email");
		
		Object o1= new Object();
		o1.name = name;
		o1.email = email;
		
		Gson gson = new Gson();
		String result = gson.toJson(o1);
		
		ServletContext context = req.getServletContext();
		String fileName = context.getRealPath("/Test.txt");
		
		//String fileName = "C:\\Users\\tvadgave\\Desktop\\Deloitte\\Test.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(result);
		writer.close();
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<title> This is the response </title>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");		
		resp.getWriter().println(result);
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}
}
