package be.veltri.DAO;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	// public abstract DAO<Classe> getClasseDAO();
	public abstract DAO<Bike> getBikeDAO();
	
	public abstract DAO<Car> getCarDAO();

	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
	
}
