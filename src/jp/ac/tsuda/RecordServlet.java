package jp.ac.tsuda;
 
import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class RecordServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<Rouge> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Rouge.class.getName();
            try {
                list = (List<Rouge>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Rouge data = (Rouge)manager.getObjectById(Rouge.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Rouge data:list){
            	res += "{name:" + data.getUserName() + ",url:'" + data.getRouge() + "',rouge:'" +
                        data.getRouge() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}