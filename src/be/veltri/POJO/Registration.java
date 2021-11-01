package be.veltri.POJO;

import java.io.Serializable;

public class Registration implements Serializable {

    // Parameters
	private static final long serialVersionUID = -2973256169538184808L;
	private boolean passenger;
	private boolean bike;

	// Builder with and without parameters
	public Registration() {}

	public Registration(boolean passenger, boolean bike) {
		this.passenger = passenger;
		this.bike = bike;
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
	
	
	
    
}