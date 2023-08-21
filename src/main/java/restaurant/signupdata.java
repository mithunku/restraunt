package restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Mydao;
import dto.customer;

@WebServlet("/sgnup")
@MultipartConfig
public class signupdata extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		String name=req.getParameter("user");
		System.out.println(name);
		String n=req.getParameter("phno1");
		System.out.println(n);
		long phno=Long.parseLong(req.getParameter("phno1"));
		String pass=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		if(gender.equals("on"))
		{
			gender="male";
		}
		else
		{
			gender="female";
		}
		String country=req.getParameter("country");
		int age=Integer.parseInt(req.getParameter("age"));
		Part pic=req.getPart("picture");
		byte[] picture=null;
		picture=new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		Mydao dao=new Mydao();
		if(dao.fetchByEmail(email)==null && dao.fetchByMobile(phno)==null)
		{
		customer c=new customer();
		c.setCountry(country);
		c.setPhno(phno);
		c.setEmail(email);
		c.setFullname(name);
		c.setGender(gender);
		c.setAge(age);
		c.setPicture(picture);
		c.setPassword(pass);
		
		dao.save(c);
		
		resp.getWriter().print("<h1 style='color:green'>ACCOUNT CREATED SUCCESSFULLY</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1>EMAIL AND PHONE NO ALREADY EXISTS</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}
		
	}

	
	
	
	}


