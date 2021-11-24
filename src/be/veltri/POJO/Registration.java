package be.veltri.POJO;

import java.io.Serializable;

public class Registration implements Serializable {

    // Parameters
	private static final long serialVersionUID = -2973256169538184808L;
	private boolean driver = false;
	private boolean passenger = false;
	private boolean bike = false;

	// Builder with and without parameters
	public Registration() {}

	public Registration(boolean driver, boolean passenger, boolean bike) {
		this.driver = driver;
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

	public boolean isDriver() {
		return driver;
	}

	public void setDriver(boolean driver) {
		this.driver = driver;
	}
	
	
	
    
}