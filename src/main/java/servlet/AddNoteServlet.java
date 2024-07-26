package servlet;

import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import dto.AddNotes;
import dto.User;

public class AddNoteServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
{
	String titleString=req.getParameter("title");
	String contentString=req.getParameter("content");
	 Date date = Calendar.getInstance().getTime();  
     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
     String strDate = dateFormat.format(date); 
     AddNotes addNotes=new AddNotes();
     addNotes.setTitle(titleString);
     addNotes.setContent(contentString);
     addNotes.setDate(strDate);
     HttpSession session=req.getSession();
	 User user=(User)session.getAttribute("user");
     Database database=new Database();
   AddNotes addNotesdb=  database.saveAddNotes(addNotes,user.getId());
   if(addNotesdb!=null)
   {
	   RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
	   dispatcher.forward(req, res);
   }
   else 
   {
	   RequestDispatcher dispatcher=req.getRequestDispatcher("addNotes.jsp");
	   dispatcher.forward(req, res);
	}
}
}
