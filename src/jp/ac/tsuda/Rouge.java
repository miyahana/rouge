package jp.ac.tsuda;

import java.io.Serializable;
import javax.jdo.annotations.*;

public class Rouge implements Serializable{
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
	public String getUserName(){return userName;}
	public String getRouge(){return rouge;}
	public int getNumber(){return number;}
	public void setUserName(String userName) {this.userName=userName;}
	public void setRouge(String rouge) {this.rouge = rouge;}
	public void setNumber(int number) {this.number=number;}
}
