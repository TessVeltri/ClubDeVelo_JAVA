package be.veltri.POJO;

import java.io.Serializable;

public class Cyclo extends Category implements Serializable {

	// Parameters
	private static final long serialVersionUID = -5413583480615463257L;

	// Builder with parameters
	public Cyclo() {
		super.setCategoryNumber(3);
		super.setCategoryName("Cyclo");
	}
    
    
}