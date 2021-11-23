package be.veltri.POJO;

import java.io.Serializable;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Category_Person implements Serializable {

	private static final long serialVersionUID = -4140223626221500603L;
	private int id_person;
	private int id_category;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Category_Person> categoryPersonDAO = dao.getCategoryPersonDAO();
	
	// Constructor with and without arguments
	public Category_Person() {}
	
	public Category_Person(int id_person, int id_category) {
		this.id_person = id_person;
		this.id_category = id_category;
	}

	// Getters and Setters
	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	
	// Methods
	
	public boolean create() {
		boolean create = categoryPersonDAO.create(this);
		return create;
	}
	

}
