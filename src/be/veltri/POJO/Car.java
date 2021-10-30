package be.veltri.POJO;

import java.io.Serializable;
import java.util.*;

public class Car implements Serializable {
	
	// Parameters 
	private static final long serialVersionUID = -3093959181040098424L;
	private int nbrMemberPlace;
	private int nbrBikePlace;
	private Member driver;
	private Set<Member> listPassenger = new HashSet<>() ;
	private Set<Bike> listBike = new HashSet<>();
	
    // Builder with and without parameters
    public Car() {}
    
    public Car(int nbrMemberPlace, int nbrBikePlace, Member driver) {
		super();
		this.nbrMemberPlace = nbrMemberPlace;
		this.nbrBikePlace = nbrBikePlace;
		this.driver = driver;
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

	public Member getDriver() {
		return driver;
	}
	public void setDriver(Member driver) {
		this.driver = driver;
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

}