package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Registration implements Serializable {

    // Parameters
	private static final long serialVersionUID = -2973256169538184808L;
	private boolean driver = false;
	private boolean passenger = false;
	private boolean bike = false;
	private int id_person;
	private int id_walk;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Registration> registrationDAO = dao.getRegistrationDAO();

	// Builder with and without parameters
	public Registration() {}
	
	public Registration(boolean driver, boolean passenger, boolean bike) {
		this.driver = driver;
		this.passenger = passenger;
		this.bike = bike;
	}

	public Registration(boolean driver, boolean passenger, boolean bike, int id_person, int id_walk) {
		this.driver = driver;
		this.passenger = passenger;
		this.bike = bike;
		this.id_person = id_person;
		this.id_walk = id_walk;
	}

	// Getters and Setters
	public boolean isPassenger() {
		return passenger;
	}
	public void setPassenger(boolean passenger) {
		this.passenger = passenger;
	}

	public boolean isBike() {
		return bike;
	}
	public void setBike(boolean bike) {
		this.bike = bike;
	}

	public boolean isDriver() {
		return driver;
	}

	public void setDriver(boolean driver) {
		this.driver = driver;
	}

	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

	public int getId_walk() {
		return id_walk;
	}

	public void setId_walk(int id_walk) {
		this.id_walk = id_walk;
	}
	// Methods
	
	public ArrayList<Registration> getAllById(int id){
		ArrayList<Registration> lst_reg = registrationDAO.getAllById(id);
		return lst_reg;
	}

	public int getPassengerCount(int id) {
		int count = registrationDAO.getPassengerCount(id);
		return count;
	}
	
	public int getBikeCount(int id){
		int count = registrationDAO.getBikeCount(id);
		return count;
	}

	public ArrayList<String> getDriver(int id) {
		ArrayList<String> lst_reg = registrationDAO.getDriver(id);
		return lst_reg;
	}
	
	public boolean create () {
		boolean create = registrationDAO.create(this);
		return create;
	}
	public Registration find () {
		Registration find = registrationDAO.find(this);
		return find;
	}

	
    
}