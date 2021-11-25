package be.veltri.POJO;

import java.io.Serializable;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Bike implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -8160503794737965587L;
	private float weight = 0;
    private String type = "";
    private float length = 0;
    private Person person;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Bike> bikeDAO = dao.getBikeDAO();
    // Builder with and without parameters
    public Bike() {}

	public Bike(float weight, String type, float length, Person person) {
		this.weight = weight;
		this.type = type;
		this.length = length;
		this.person = person;
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

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}