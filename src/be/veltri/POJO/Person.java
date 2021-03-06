package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.veltri.DAO.*;

public class Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -8046334496633743917L;
	private String username = "";
	private String name = "";
    private String firstname = "";
    private String phone = "";
    private String password = "";
    private String type = "";
    
    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Person> personDAO = dao.getPersonDAO();

    // Builder with and without parameters
    public Person() {}

	public Person(String username, String name, String firstname, String phone, String password, String type) {
		this.username = username;
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		this.password = password;
		this.type = type;
	}

	// Getters and setters
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// Methods
	public Person find () {
		Person person = personDAO.find(this);
		return person;
	}
	
	public boolean create () {
		boolean create = personDAO.create(this);
		return create;
	}
	
	public int findId () {
		int id = personDAO.findId(this);
		return id;
	}
	
	public Person findByName () {
		Person find = personDAO.findByName(this);
		return find;
	}
	public boolean addCategoryToPerson (Category category) {
		boolean cat = personDAO.addCategoryToPerson(this.getUsername(), category);
		return cat;
	}
}