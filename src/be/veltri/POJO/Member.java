package be.veltri.POJO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Member extends Person implements Serializable {
	
	// Parameters 
	private static final long serialVersionUID = -4534714288962563667L;
	private float pay = 0;
	private Set<Bike> listBike = new HashSet<>();
	private Set<Category> listCategory = new HashSet<>();
	private Set<Registration> listRegistration = new HashSet<>();
	

	// Builder with and without parameters
    public Member(String username, String name, String firstname, String phone, String password, String type, float pay) {
		super(username, name, firstname, phone, password, type);
		this.pay = pay;
	}
    
    // Getters and Setters
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	
	// Methods
	public void addBike(Bike bike) {
		if(!listBike.contains(bike))
			listBike.add(bike);
    }
    public void deleteBike(Bike bike) {
        this.listBike.remove(bike);
    }
    public void addCategory(Category category) {
		if(!listCategory.contains(category))
			listCategory.add(category);
    }
    public void deleteCategory(Category category) {
        this.listCategory.remove(category);
    }
    public void addRegistration(Registration registration) {
		if(!listRegistration.contains(registration))
			listRegistration.add(registration);
    }
    public void deleteRegistration(Registration registration) {
        this.listRegistration.remove(registration);
    }

	// TODO Move to Member DAO
//    public void CalculatePay() {
//        // TODO implement here
//    }
//    public void VerifyPay() {
//        // TODO implement here
//    }

}