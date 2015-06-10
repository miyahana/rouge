package jp.ac.tsuda;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 *
 * @author 
 */
public class Done extends HttpServlet {

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
    	HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
    	Price getPrice = (Price)session.getAttribute("getPrice");
    	//String userName = request.getParameter(name);
    	for(int i=1;i < 7;i++){
    		int number =0;
    		String rouge = "";
    		if(i == 1){
    			number = getPrice.getRouge1();
    			rouge = "CANMAKE";
    		}else if(i==2){
    			number = getPrice.getRouge2();
    			rouge = "MAYBELLINE";
    		}else if(i==3){
    			number = getPrice.getRouge3();
    			rouge = "ANNASUI";
    		}else if(i==4){
    			number = getPrice.getRouge4();
    			rouge = "MAC ";
    		}else if(i==5){
    			number = getPrice.getRouge5();	
    			rouge = "CHANEL";
    		}else if(i==6){
    			number = getPrice.getRouge6();	
    			rouge = "KiSHiORiGiNAL";
    		}
    		
    		if(number>0){
    			Rouge r = new Rouge(name,rouge,number);
    			PersistenceManagerFactory factory = PMF.get();
    			PersistenceManager manager = factory.getPersistenceManager();
    			try {
    				manager.makePersistent(r);
    			} finally {
    				manager.close();
    			}
    		}
    	}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/done.jsp");
        dispatcher.forward(request, response);
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
