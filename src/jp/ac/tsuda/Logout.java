package jp.ac.tsuda;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 *
 * @author 
 */
public class Logout extends HttpServlet {
    private static final long serialVersionUID=1L;

    

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
    	UserService userService = UserServiceFactory.getUserService();

        String thisURL = request.getRequestURI();
        HttpSession session = request.getSession();
        session.invalidate();
        if (request.getUserPrincipal() != null) {
        response.getWriter().println("<p>Hello, " +
                request.getUserPrincipal().getName() +
                "!  You can <a href=\"" +
                userService.createLogoutURL(thisURL) +
                "\">sign out</a>.</p>");
        }else{
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.jsp");
        	dispatcher.forward(request, response);
        }
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
