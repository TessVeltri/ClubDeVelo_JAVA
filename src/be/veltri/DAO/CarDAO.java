package be.veltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import be.veltri.POJO.Car;

public class CarDAO extends DAO<Car>{

	public CarDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Car obj) {
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Car(name_Car, nbrMemberPlace, nbrBikePlace)"
					+ "Values('"+ obj.getCarName() + "', '" + obj.getNbrMemberPlace() + "', '" + obj.getNbrBikePlace() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Car obj) {
		return false;
	}

	public boolean update(Car obj) {
		return false;
	}

	public Car find(int id) {
		return null;
	}

	public Car find(Car obj) {
		return null;
	}

	@Override
	public int findId(Car obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
