package jp.ac.tsuda;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Review implements Serializable{
	@Persistent
    private String userName;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
    private String comment;
	
	@Persistent
    private Date datetime;
   
    public Review(){}
    public Review(String userName,String comment){
        this.userName = userName;
        this.comment = comment;
    }
    public Review(String userName,Long id,String comment,Date datetime){
        this.userName = userName;
        this.id = id;
        this.comment = comment;
    }
    public String getUserName() { return userName; }
    public Long getId() { return id; }
    public String getComment() {return comment; }
    
    public void setUserName(String userName) { this.userName = userName;}
    public void setId(Long id){ this.id = id; }
    public void setComment(String comment){ this.comment = comment; }
    
    
}
