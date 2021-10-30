package be.veltri.POJO;

import java.io.Serializable;

public class Trialist extends VTT implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 7407345098364837948L;

	// Builder with and without parameters
    public Trialist() {}

	public Trialist(int categoryNumber) {
		categoryNumber = 1;
	}
    

}