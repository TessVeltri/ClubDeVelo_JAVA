package be.veltri.POJO;

import java.io.Serializable;

public class Hiker extends VTT implements Serializable {

	// Parameters
	private static final long serialVersionUID = 710038844832355865L;

	// Builder with and without parameters
	public Hiker() {}

	public Hiker(int categoryNumber) {
		categoryNumber = 3;
	}
}