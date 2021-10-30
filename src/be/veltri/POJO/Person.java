package be.veltri.POJO;

import java.io.Serializable;

public abstract class Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -8046334496633743917L;
	private int id = 0;
	private String name = "";
    private String firstname = "";
    private String phone = "";
    private String password = "";

    // Builder with and without parameters
    public Person() {}

	public Person(int id, String name, String firstname, String phone, String password) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		this.password = password;
	}

	// Getters and setters
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

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}