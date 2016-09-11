package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 
 * @author 
 *
 */
@MappedSuperclass
public abstract class User implements Serializable{

	private static final long serialVersionUID = -7773702648697201146L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique=true, nullable = false)
	private int id;
	
	@Column(name = "user_firstName", unique = false, nullable=true)
	private String firstName;
	
	@Column( name = "user_lastName", unique = false, nullable = true)
	private String lastName;
	
	@Column( name = "user_username", unique = true, nullable= false)
	private String username;
	
	@Column( name = "user_password", unique = false, nullable= false)
	private String password;
	
	
	
	public User(String firstName, String lastName,String user_username, String user_password){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = user_username;
		this.password = user_password;
	}

	public User(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
