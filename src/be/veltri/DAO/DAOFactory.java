package be.veltri.DAO;

import java.sql.Connection;
import be.veltri.DB.ClubDeVeloConnection;
import be.veltri.POJO.*;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = ClubDeVeloConnection.getInstance();

	public DAO<Bike> getBikeDAO() {
		return new BikeDAO (conn);
	}
	
	public DAO<Calendar> getCalendarDAO() {
		return new CalendarDAO (conn);
	}

	public DAO<Car> getCarDAO() {
		return new CarDAO (conn);
	}

	public DAO<Category> getCategoryDAO() {
		return new CategoryDAO (conn);
	}
	
	public DAO<Manager> getManagerDAO() {
		return new ManagerDAO (conn);
	}
	
	public DAO<Member> getMemberDAO() {
		return new MemberDAO (conn);
	}
	
	public DAO<Person> getPersonDAO() {
		return new PersonDAO (conn);
	}
	
	public DAO<Registration> getRegistrationDAO() {
		return new RegistrationDAO (conn);
	}
	
	public DAO<Treasurer> getTreasurerDAO() {
		return new TreasurerDAO (conn);
	}
	
	public DAO<Walk> getWalkDAO() {
		return new WalkDAO (conn);
	}
	
}
