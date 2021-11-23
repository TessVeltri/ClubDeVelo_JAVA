package be.veltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import be.veltri.POJO.Bike;

public class BikeDAO extends DAO<Bike>{

	public BikeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Bike obj) {
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Bike(weight_Bike, type_Bike, lenght_Bike)"
					+ "Values('"+ obj.getWeight() + "', '" + obj.getType() + "', '" + obj.getLength() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Bike obj) {
		return false;
	}

	public boolean update(Bike obj) {
		return false;
	}

	public Bike find(int id) {
		return null;
	}

	public Bike find(Object o) {
		return null;
	}

	@Override
	public Bike find(Bike obj) {
		return null;
	}
	

}
