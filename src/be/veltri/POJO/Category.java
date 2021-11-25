package be.veltri.POJO;

import java.io.Serializable;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public abstract class Category implements Serializable {

	// Parameters
	private static final long serialVersionUID = -9155000318506050985L;
	private int categoryNumber;
	private Calendar calendar;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Category> categoryDAO = dao.getCategoryDAO();
	// Builder with and without parameters
    public Category() {
    	setCalendar(new Calendar());
    }

	public Category(int categoryNumber) {
		this.categoryNumber = categoryNumber;
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
    
    

}