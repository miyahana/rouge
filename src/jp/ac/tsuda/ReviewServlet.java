package jp.ac.tsuda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReviewServlet extends HttpServlet{
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.removeAttribute("rouge");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/loginOK.jsp");
        dispatcher.forward(request,response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String rouge = request.getParameter("radiobutton");
        session.setAttribute("rouge", rouge);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/reviewShow.jsp");
        dispatcher.forward(request,response);
	}
}
