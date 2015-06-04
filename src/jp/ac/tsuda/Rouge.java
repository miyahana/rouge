package jp.ac.tsuda;

import java.io.Serializable;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Rouge implements Serializable{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String userName;
	@Persistent
	private String rouge;
	@Persistent
	private int number;

	public Rouge() { }
	public Rouge(String userName,String rouge,int number) {
		this.userName = userName;
	        
	    this.rouge = rouge;
	    
	    this.number = number;

	}
	public Long getId() {return id;}
 
    public void setId(Long id) {this.id = id;}
	public String getUserName(){return userName;}
	public String getRouge(){return rouge;}
	public int getNumber(){return number;}
	public void setUserName(String userName) {this.userName=userName;}
	public void setRouge(String rouge) {this.rouge = rouge;}
	public void setNumber(int number) {this.number=number;}
}
