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
	private Set<Member> listPassenger = new HashSet<>();
	private Set<Bike> listBike = new HashSet<>();

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

	public Set<Member> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(Set<Member> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public Set<Bike> getListBike() {
		return listBike;
	}

	public void setListBike(Set<Bike> listBike) {
		this.listBike = listBike;
	}
	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	// Methods
	public void addPassenger(Member passenger) {
		if(!listPassenger.contains(passenger))
			listPassenger.add(passenger);
    }
    public void deletePassenger(Member passenger) {
        this.listPassenger.remove(passenger);
    }
    public void addBike(Bike bike) {
        if (!listBike.contains(bike))
        	listBike.add(bike);
    }
    public void deleteBike(Bike bike) {
        this.listBike.remove(bike);
    }

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}