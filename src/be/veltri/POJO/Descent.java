package be.veltri.POJO;

import java.io.Serializable;

public class Descent extends VTT implements Serializable{

    // Parameters
	private static final long serialVersionUID = 9200544747703000131L;

	// Builder with and without parameters
    public Descent() {}

	public Descent(int categoryNumber) {
		categoryNumber = 2;
	}
}