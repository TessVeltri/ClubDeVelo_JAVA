package be.veltri.POJO;

import java.io.Serializable;

public class Trialist extends VTT implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 7407345098364837948L;

	// Builder with parameters
    public Trialist() {
		super.setCategoryNumber(1);
		super.setCategoryName("VTT_Trialist");
	}
    

}