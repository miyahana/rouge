package jp.ac.tsuda;
import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Login {
	@Persistent
    private String name;
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String pass;
	@Persistent
    private Date datetime;
	
    public Login(String name,String pass){
        this.name = name;
        this.pass = pass;
    }
    public String getName() { return name; }
    public String getPass() { return pass; }
    public Date getDatetime() { return datetime; }
    public void setDatetime(Date datetime) { this.datetime = datetime; }
}
