package be.veltri.POJO;

import java.io.Serializable;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Treasurer extends Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 7155488586618117402L;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Treasurer> treasurerDAO = dao.getTreasurerDAO();
	// Builder with and without parameters
    public Treasurer() {}

    public Treasurer(String username, String name, String firstname, String phone, String password, String type) {
		super(username, name, firstname, phone, password, type);
	}

}