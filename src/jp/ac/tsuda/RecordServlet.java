package jp.ac.tsuda;
 
import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class RecordServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException, ServletException {
    	
    	
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        
        RequestDispatcher dispatcher=req.getRequestDispatcher("/record.jsp");
        dispatcher.forward(req,resp);
    }
}