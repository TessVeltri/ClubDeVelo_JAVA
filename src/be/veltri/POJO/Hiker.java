package be.veltri.POJO;

import java.io.Serializable;

public class Hiker extends VTT implements Serializable {

	// Parameters
	private static final long serialVersionUID = 710038844832355865L;

	// Builder with parameters
	public Hiker() {
		super.setCategoryNumber(3);
		super.setCategoryName("VTT_Hiker");
	}
}