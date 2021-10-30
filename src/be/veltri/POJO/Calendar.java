package be.veltri.POJO;

import java.io.Serializable;

public class Calendar implements Serializable {

	// Parameters
	private static final long serialVersionUID = 1L;
	private static Calendar instance;

	// Builder without parameters
    private Calendar() {}
    
    // Singleton
    public static Calendar getInstance() {
        if (instance == null) {
            instance = new Calendar();
        }
        return instance;
    }

    // TODO Move to Calendar DAO
//    public void AddWalk() {
//        // TODO implement here
//    }

}