package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.Database;
import dto.AddNotes;
import dto.User;
@WebServlet("/shownotes")
public class ShowNotes extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		int id=Integer.parseInt(req.getParameter("id"));
		Database database=new Database();
		req.setAttribute("list",database.getnotes(id));
		RequestDispatcher dispatcher=req.getRequestDispatcher("show.jsp");
		dispatcher.forward(req, resp);
	}

}
