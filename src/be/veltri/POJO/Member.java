package be.veltri.POJO;

import java.io.Serializable;

public class Member extends Person implements Serializable {
	
	// Parameters 
	private static final long serialVersionUID = -4534714288962563667L;
	private float pay;

	// Builder with and without parameters
    public Member() {}

    public Member(int id, String name, String firstname, String phone, String password, float pay) {
		super(id, name, firstname, phone, password);
		this.pay = pay;
	}
    
    // Getters and Setters
	public float getPay() {
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
	}

	// TODO Move to Member DAO
//    public void CalculatePay() {
//        // TODO implement here
//    }
//    public void VerifyPay() {
//        // TODO implement here
//    }

}