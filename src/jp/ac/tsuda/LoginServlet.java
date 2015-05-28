package jp.ac.tsuda;

import java.io.*;
import java.util.*;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.jdo.*;
import javax.servlet.http.*;

/**
 *
 * @author 
 */
public class LoginServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/login.jsp");
        dispatcher.forward(request,response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String param1 = request.getParameter("id");
        
        List<Data> d = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Data.class.getName();
            try {
                d = (List<Data>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
            	Data data =(Data)manager.getObjectById(Data.class,Long.parseLong(param1));
            	d = new ArrayList();
            	d.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        boolean result = false;
        for(Data p:d){
        	if(pass.equals(p.getPass())){
        		result = true;
        	}
        }
        if(result){
        	Login login = new Login(name,pass);
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
             RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/loginOK.jsp");
        dispatcher.forward(request,response);
        }else{
            response.sendRedirect("/login");
        }
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
