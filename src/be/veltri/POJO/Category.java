package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public abstract class Category implements Serializable {

	// Parameters
	private static final long serialVersionUID = -9155000318506050985L;
	private int categoryNumber;
	private String categoryName;
	private Calendar calendar;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Category> categoryDAO = dao.getCategoryDAO();
	// Builder with and without parameters
    public Category() {
    	setCalendar(new Calendar());
    }

	public Category(int categoryNumber, String categoryName) {
		this.categoryNumber = categoryNumber;
		this.categoryName = categoryName;
	}

	// Getters and Setters 
	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	// Methods
	public ArrayList<Category> getAllById(int id){
		ArrayList<Category> lst_cat = categoryDAO.getAllById(id);
		return lst_cat;
	}
    
    

}