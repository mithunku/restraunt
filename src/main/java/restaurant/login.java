package restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mydao;

@WebServlet("/login2")
public class login extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		String email=req.getParameter("user");
		System.out.println(email);
		String password=req.getParameter("pass");
		System.out.println(password);
		Mydao dao=new Mydao();
		
		if(email.equals("admin")&& password.equals("admin123"))
		{

			resp.getWriter().print("<h1 style='color:green'>LOGGEDIN SUCCESSFULLY</h1>");
			req.getRequestDispatcher("admin.html").include(req, resp);
		}
		else {
		if(dao.validateEmail(email)!=null && dao.validatePassword(password)!=null)
		{
			resp.getWriter().print("<h1 style='color:green'>ACCOUNT LOGGEDIN SUCCESSFULLY</h1>");
			req.getRequestDispatcher("customer.html").include(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			resp.getWriter().print("INVALID USERNAME OR PASSWORD");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		}
	}

}
