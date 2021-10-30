package be.veltri.POJO;

import java.io.Serializable;

public class Manager extends Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 6044946005392345729L;

	// Builder with and without parameters
	public Manager() {}

	public Manager(int id, String name, String firstname, String phone, String password) {
		super(id, name, firstname, phone, password);
	}
}