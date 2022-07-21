package be.veltri.POJO;

import java.io.Serializable;
import java.util.*;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Car implements Serializable {
	
	// Parameters 
	private static final long serialVersionUID = -3093959181040098424L;
	private String carName = "";
	private int nbrMemberPlace = 0;
	private int nbrBikePlace = 0;
	private Person person;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Car> carDAO = dao.getCarDAO();
    // Builder with and without parameters
    public Car() {}
    
    public Car(String carName, int nbrMemberPlace, int nbrBikePlace, Person person) {
		super();
		this.carName = carName;
		this.nbrMemberPlace = nbrMemberPlace;
		this.nbrBikePlace = nbrBikePlace;
		this.person = person;
	}
    
    // Getters and Setters
	public int getNbrMemberPlace() {
		return nbrMemberPlace;
	}
	public void setNbrMemberPlace(int nbrMemberPlace) {
		this.nbrMemberPlace = nbrMemberPlace;
	}

	public int getNbrBikePlace() {
		return nbrBikePlace;
	}
	public void setNbrBikePlace(int nbrBikePlace) {
		this.nbrBikePlace = nbrBikePlace;
	}
	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	// Methods
	public Car find(Person person) {
		Car car = carDAO.findCarForPerson(person);
		return car;
	}
	
	public boolean create() {
		boolean create = carDAO.create(this);
		return create;
	}
	
	public boolean delete() {
		boolean delete = carDAO.delete(this);
		return delete;
	}

}