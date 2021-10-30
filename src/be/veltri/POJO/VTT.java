package be.veltri.POJO;

import java.io.Serializable;

public abstract class VTT extends Category implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -284887787976977480L;
	
	// Builder with and without parameters
	public VTT() {}

	public VTT(int categoryNumber) {
		super(categoryNumber);
	}
	
	

}