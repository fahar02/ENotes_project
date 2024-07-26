package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import dto.User;

public class Login2 extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Database database=new Database();
		List<User> users=database.select();
		boolean flag=false;
		User userdb=null;
		for(User user:users)
		{
			if(user.getEmail().equals(email))
			{
				flag=true;
				userdb=user;
				break;
			}
		}
		if(flag)
		{
			if(userdb.getPassword().equals(password))
			{
				HttpSession session=req.getSession();
				session.setAttribute("user",userdb);
				RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, res);
				
			}
		}
		else {

			HttpSession session=req.getSession();
			session.setAttribute("login-fail","invalid email or password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, res);
		}
	}

}
