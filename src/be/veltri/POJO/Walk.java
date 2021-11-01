package be.veltri.POJO;

import java.io.Serializable;
import java.util.*;


public class Walk implements Serializable {

	// Parameters
	private static final long serialVersionUID = -386600856277767918L;
	private int walkNumber;
	private String placeDeparture;
	private Date dateDeparture;
	private int forfeit;
	private Set<Registration> listRegistration = new HashSet<>();
    private Set<Member> listParticipants = new HashSet<>();
    private Set<Car> listCars = new HashSet<>();

	// Builder with and without parameters
    public Walk() {}
    
    public Walk(int walkNumber, String placeDeparture, Date dateDeparture, int forfeit) {
		this.walkNumber = walkNumber;
		this.placeDeparture = placeDeparture;
		this.dateDeparture = dateDeparture;
		this.forfeit = forfeit;
	}

    // Getters and Setters    
	public int getWalkNumber() {
		return walkNumber;
	}
	public void setWalkNumber(int walkNumber) {
		this.walkNumber = walkNumber;
	}

	public String getPlaceDeparture() {
		return placeDeparture;
	}
	public void setPlaceDeparture(String placeDeparture) {
		this.placeDeparture = placeDeparture;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}
	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public int getForfeit() {
		return forfeit;
	}
	public void setForfeit(int forfeit) {
		this.forfeit = forfeit;
	}

	public Set<Member> getListParticipants() {
		return listParticipants;
	}
	public void setListParticipants(Set<Member> listParticipants) {
		this.listParticipants = listParticipants;
	}

	public Set<Car> getListCars() {
		return listCars;
	}
	public void setListCars(Set<Car> listCars) {
		this.listCars = listCars;
	}

	public Set<Registration> getListRegistration() {
		return listRegistration;
	}
	public void setListRegistration(Set<Registration> listRegistration) {
		this.listRegistration = listRegistration;
	}

	// Methods 
	public void addParticipant(Member passenger) {
		if(!listParticipants.contains(passenger))
			listParticipants.add(passenger);
    }
    public void deleteParticipant(Member passenger) {
        this.listParticipants.remove(passenger);
    }
    public void addCar(Car car) {
		if(!listCars.contains(car))
			listCars.add(car);
    }
    public void deleteCar(Car car) {
        this.listCars.remove(car);
    }
    
    // TODO Move to Walk DAO
//    public void GetTotalMemberPlace() {
//        // TODO implement here
//    }
//    public void GetRemainingMemberPlace() {
//        // TODO implement here
//    }
//    public void GetTotalBikePlace() {
//        // TODO implement here
//    }
//    public void GetRemainingBikePlace() {
//        // TODO implement here
//    }
//    public void GetNeedMemberPlace() {
//        // TODO implement here
//    }
//    public void GetNeedBikePlace() {
//        // TODO implement here
//    }
    

}