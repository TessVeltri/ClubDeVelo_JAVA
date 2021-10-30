package be.veltri.POJO;

import java.io.Serializable;

public class Bike implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -8160503794737965587L;
	private float weight;
    private String type;
    private float length;

    // Builder with and without parameters
    public Bike() {}

	public Bike(float weight, String type, float length) {
		this.weight = weight;
		this.type = type;
		this.length = length;
	}

	// Getters and Setters
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
}