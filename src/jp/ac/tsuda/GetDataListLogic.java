package jp.ac.tsuda;

import java.util.List;
/**
 *
 * @author 
 */
public class GetDataListLogic {
    
    public List<Data> execute(){
    DataDAO dao = new DataDAO();
    List<Data> dataList = dao.findAll();
    return dataList;
  }
}
