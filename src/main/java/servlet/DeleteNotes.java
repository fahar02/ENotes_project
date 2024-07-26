package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
@WebServlet("/deleteNotes")
public class DeleteNotes extends HttpServlet{
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
	int id=Integer.parseInt(req.getParameter("id"));
	Database database=new Database();
boolean flag=database.delete(id);
if(flag)
{
	RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
	dispatcher.forward(req, res);
}
else {
	System.out.println("invalid id from deletenotes class");
}
}
}
