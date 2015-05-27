package jp.ac.tsuda;


import java.io.Serializable;

/**
 *
 * @author 
 */
public class Data implements Serializable{
    private String userName;
    private String pass;
   
    public Data(){}
    public Data(String userName,String pass){
        this.userName = userName;
        this.pass = pass;
    }
    public String getUserName() { return userName; }
    public String getPass() {return pass; }
}