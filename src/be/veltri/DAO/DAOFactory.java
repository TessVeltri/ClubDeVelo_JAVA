package be.veltri.DAO;

import java.sql.Connection;
import be.veltri.DB.ClubDeVeloConnection;
import be.veltri.POJO.*;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = ClubDeVeloConnection.getInstance();

	public DAO<Bike> getBikeDAO() {
		return new BikeDAO (conn);
	}

	public DAO<Car> getCarDAO() {
		return new CarDAO (conn);
	}
	
	public DAO<Person> getPersonDAO() {
		return new PersonDAO (conn);
	}
	
	public DAO<Category_Person> getCategoryPersonDAO() {
		return new Category_PersonDAO (conn);
	}
}
