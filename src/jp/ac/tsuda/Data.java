package jp.ac.tsuda;


import java.io.Serializable;

/**
 *
 * @author 
 */
import java.util.Date;
 
import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Data implements Serializable {
	
	@Persistent
    private String userName;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String pass;
	
	@Persistent
    private Date datetime;
   
    public Data(){}
    public Data(String userName,String pass){
        this.userName = userName;
        this.pass = pass;
    }
    public Data(String userName,String pass,Date datetime){
        this.userName = userName;
        this.pass = pass;
        this.datetime = datetime;
    }
    public String getUserName() { return userName; }
    public String getPass() {return pass; }
    public Date getDatetime() { return datetime; }
    
    public void setUserName(String userName) { this.userName = userName;}
    public void setPass(String pass){ this.pass = pass; }
    public void setDatetime(Date datetime) { this.datetime = datetime; }
    
    
}