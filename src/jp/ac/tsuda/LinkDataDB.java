package jp.ac.tsuda;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.jdo.*;

public class LinkDataDB {
	private static final PersistenceManagerFactory factory = 
	        JDOHelper.getPersistenceManagerFactory("transactions-optional");
	public static void create(Rouge data){
		PersistenceManager manager = factory.getPersistenceManager();
		try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
	}
	public static Rouge read(long id){
		PersistenceManager manager = factory.getPersistenceManager();
	        List<Rouge> list = null;
	        try {
                Rouge data = (Rouge)manager.getObjectById(Rouge.class,id);
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
	        return list.get(0);
	}
	public static List<Rouge> read(){
		PersistenceManager manager = factory.getPersistenceManager();
        List<Rouge> list = null;
        String query = "select from " + Rouge.class.getName();
        try {
        	list = (List<Rouge>)manager.newQuery(query).execute();
        } catch(JDOObjectNotFoundException e){}
        return list;
	}
	public static void update(long id,Rouge newData){
		PersistenceManager manager = factory.getPersistenceManager();
		Rouge data = (Rouge)manager.getObjectById(Rouge.class,id);
        data.setUserName(newData.getUserName());
        data.setRouge(newData.getRouge());
        data.setNumber(newData.getNumber());
        
        manager.close();
	}
	public static void delete(long id){
	}
	public static void create(Review data){
		PersistenceManager manager = factory.getPersistenceManager();
		try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
	}
	public static Review read1(long id){
		PersistenceManager manager = factory.getPersistenceManager();
	        List<Review> list = null;
	        try {
                Review data = (Review)manager.getObjectById(Review.class,id);
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
	        return list.get(0);
	}
	public static List<Review> read1(){
		PersistenceManager manager = factory.getPersistenceManager();
        List<Review> list = null;
        String query = "select from " + Review.class.getName();
        try {
        	list = (List<Review>)manager.newQuery(query).execute();
        } catch(JDOObjectNotFoundException e){}
        return list;
	}
	public static void update(long id,Review newData){
		PersistenceManager manager = factory.getPersistenceManager();
		Review data = (Review)manager.getObjectById(Review.class,id);
        data.setUserName(newData.getUserName());
        data.setComment(newData.getComment());
        data.setId(id);
        data.setDatetime(newData.getDatetime());
        manager.close();
	}
}
