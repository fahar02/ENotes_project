package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		HttpSession session=req.getSession();
		session.removeAttribute("user");
		
		HttpSession session2=req.getSession();
		session2.setAttribute("logoutMsg","LogOut Successfully");
		res.sendRedirect("login.jsp");
		
	}

}
