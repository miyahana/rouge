package jp.ac.tsuda;


/**
 *
 * @author 
 */
public class RegisterUserLogic {
    public void register(Data data){
       DataDAO dao = new DataDAO();
        dao.create(data);
    }
}