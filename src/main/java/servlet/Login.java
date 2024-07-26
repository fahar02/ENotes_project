package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import dto.User;

public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String nameString=req.getParameter("name");
		long phoneString=Long.parseLong(req.getParameter("phone"));
		String emailString=req.getParameter("email");
		String addressString=req.getParameter("address");
		String passwordString=req.getParameter("password");
		 
		User user=new User();
		user.setName(nameString);
		user.setPhone(phoneString);
		user.setEmail(emailString);
		user.setAddress(addressString);
		user.setPassword(passwordString);
		
		Database database=new Database();
	boolean flag=database.saveUser(user);
	HttpSession session;
	if(flag)
	{
		 session=req.getSession();
		session.setAttribute("register","register successfully");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, res);
	}
	else 
	{
		session=req.getSession();
		session.setAttribute("register-fail","register fail successfully");
		RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
		dispatcher.include(req, res);
	}
		
		
	}

}
