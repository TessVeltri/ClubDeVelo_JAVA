package be.veltri.POJO;

import java.io.Serializable;

public abstract class Category implements Serializable {

	// Parameters
	private static final long serialVersionUID = -9155000318506050985L;
	private int categoryNumber;
    
	// Builder with and without parameters
    public Category() {}

	public Category(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	// Getters and Setters 
	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
    
    

}