package jp.ac.tsuda;

import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RougeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

        req.setCharacterEncoding("UTF-8");
		HttpSession session =  req.getSession();
		Data registerUser = (Data)session.getAttribute("registerUser");
		Date date = Calendar.getInstance().getTime();
		Data data = new Data(registerUser.getUserName(),registerUser.getPass(),date);
		PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
		session.removeAttribute("registerUser");
		try {
			manager.makePersistent(data);
		} finally {
			manager.close();
		}
		resp.sendRedirect("/registerDone.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
        HttpServletResponse resp)
        		throws ServletException, IOException {
		resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
	}
}
