package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import dto.AddNotes;
@WebServlet("/EditNotes")
public class EditNotes extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Integer id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		 Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	     String strDate = dateFormat.format(date);
	     AddNotes addNotes=new AddNotes();
	     addNotes.setId(id);
	     addNotes.setTitle(title);
	     addNotes.setContent(content);
	     addNotes.setDate(strDate);
	     Database database=new Database();
	     database.editNotes(id,addNotes);
	     RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
	     dispatcher.forward(req, res);
	     
		
	}

}
