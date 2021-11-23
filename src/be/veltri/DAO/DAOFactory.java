package be.veltri.DAO;

import java.sql.Connection;

import be.veltri.DB.ClubDeVeloConnection;
import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = ClubDeVeloConnection.getInstance();

	public DAO<Bike> getBikeDAO() {
		return new BikeDAO (conn);
	}

	public DAO<Car> getCarDAO() {
		return new CarDAO (conn);
	}
	
	
}
