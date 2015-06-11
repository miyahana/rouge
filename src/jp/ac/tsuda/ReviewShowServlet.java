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

public class ReviewShowServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("comment");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        response.setContentType("text/html");
        String param1 = request.getParameter("id");
        PrintWriter out = response.getWriter();
        List<Review> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Review.class.getName();
            try {
                list = (List<Review>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Review data = (Review)manager.getObjectById(Review.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Review data:list){
            	res += "{userName:" + data.getUserName() + "',comment:'" +
                        data.getComment() + "'},"+"date"+data.getDatetime();
            }
        }
        res += "]";
        out.println(res);
        manager.close();
        RequestDispatcher dispatcher=request.getRequestDispatcher("/reviewShow.jsp");
        dispatcher.forward(request,response);
	}
}
