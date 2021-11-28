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
    private int id_person = 0;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Bike> bikeDAO = dao.getBikeDAO();
    // Builder with and without parameters
    public Bike() {}

	public Bike(float weight, String type, float length, int id_person) {
		this.weight = weight;
		this.type = type;
		this.length = length;
		this.id_person = id_person;
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

	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	
	//Methods
	public boolean create() {
		boolean create = bikeDAO.create(this);
		return create;
	}
	
	public boolean delete() {
		boolean delete = bikeDAO.delete(this);
		return delete;
	}
	
	public Bike find(int id) {
		Bike bike = bikeDAO.find(id);
		return bike;
	}
	
}