package be.veltri.POJO;

import java.io.Serializable;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Manager extends Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 6044946005392345729L;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Manager> managerDAO = dao.getManagerDAO();

	// Builder with and without parameters
	public Manager() {}

	public Manager(String username, String name, String firstname, String phone, String password, String type) {
		super(username, name, firstname, phone, password, type);
	}
}