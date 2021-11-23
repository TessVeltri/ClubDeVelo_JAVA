package be.veltri.DAO;

import be.veltri.POJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	// public abstract DAO<Classe> getClasseDAO();
	public abstract DAO<Bike> getBikeDAO();
	
	public abstract DAO<Car> getCarDAO();
	
	public abstract DAO<Person> getPersonDAO();

	public abstract DAO<Category_Person> getCategoryPersonDAO();

	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
	
}
