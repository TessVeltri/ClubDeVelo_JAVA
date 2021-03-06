package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Calendar implements Serializable {

	// Parameters
	private static final long serialVersionUID = 1L;
	private static Calendar instance;
	private ArrayList<Walk> listWalk = new ArrayList<Walk>();

	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Calendar> calendarDAO = dao.getCalendarDAO();

	// Builder without parameters
	public Calendar() {
	}

	// Singleton
	public static Calendar getInstance() {
		if (instance == null) {
			instance = new Calendar();
		}
		return instance;
	}

	// Getters and Setters
	public ArrayList<Walk> getListWalk(Category category, Person person) {
		setListWalk(category, person);
		return listWalk;
	}

	public void setListWalk(Category category, Person person) {
		this.listWalk = calendarDAO.getWalkByPersonAndCategory(person, category);
	}

	// Methods
	public void addWalk(Walk walk) {
		if (!listWalk.contains(walk))
			listWalk.add(walk);
	}

	public void deleteWalk(Walk walk) {
		this.listWalk.remove(walk);
	}

}