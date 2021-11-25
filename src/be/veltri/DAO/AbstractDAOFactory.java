package be.veltri.DAO;

import be.veltri.POJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAO<Bike> getBikeDAO();

	public abstract DAO<Calendar> getCalendarDAO();
	
	public abstract DAO<Car> getCarDAO();

	public abstract DAO<Category> getCategoryDAO();

	public abstract DAO<Manager> getManagerDAO();

	public abstract DAO<Member> getMemberDAO();
	
	public abstract DAO<Person> getPersonDAO();

	public abstract DAO<Registration> getRegistrationDAO();

	public abstract DAO<Treasurer> getTreasurerDAO();

	public abstract DAO<Walk> getWalkDAO();

	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
	
}
