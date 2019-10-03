package entity;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private Date birthDay;
	
	public User() {
		
	}

	public User(int id, String name, String email, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String toString() {
		return "User: " + name + " --- Email: " + email + " --- Birthday: " + birthDay;
	}

}
