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
	private Person person;
	private Walk walk;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Registration> registrationDAO = dao.getRegistrationDAO();

	// Builder with and without parameters
	public Registration() {}
	
	public Registration(boolean driver, boolean passenger, boolean bike) {
		this.driver = driver;
		this.passenger = passenger;
		this.bike = bike;
	}

	public Registration(boolean driver, boolean passenger, boolean bike, Person person, Walk walk) {
		this.driver = driver;
		this.passenger = passenger;
		this.bike = bike;
		this.person = person;
		this.walk = walk;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Walk getWalk() {
		return walk;
	}

	public void setWalk(Walk walk) {
		this.walk = walk;
	}
	// Methods
	
	public ArrayList<Registration> getAll(Walk walk){
		ArrayList<Registration> lst_reg = registrationDAO.getAllRegistration(walk);
		return lst_reg;
	}

	public int getPassengerCount(Walk walk) {
		int count = registrationDAO.getPassengerCount(walk);
		return count;
	}
	
	public int getBikeCount(Walk walk){
		int count = registrationDAO.getBikeCount(walk);
		return count;
	}

	public ArrayList<String> getDriver(Walk walk) {
		ArrayList<String> lst_reg = registrationDAO.getDriver(walk);
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

	public ArrayList<String> getDriverForPay(Walk walk) {
		ArrayList<String> lst_reg = registrationDAO.getDriverForPay(walk);
		return lst_reg;
	}
	public ArrayList<String> getPassenger(Walk walk) {
		ArrayList<String> lst_reg = registrationDAO.getPassenger(walk);
		return lst_reg;
	}
	public boolean update (Registration reg) {
		boolean update = registrationDAO.update(reg);
		return update;
	}
}