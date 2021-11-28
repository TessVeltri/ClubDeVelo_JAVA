package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;

public class BikeDAO extends DAO<Bike> {

	public BikeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Bike obj) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Bike(weight_Bike, type_Bike, lenght_Bike, id_Person)" + "Values('"
							+ obj.getWeight() + "', '" + obj.getType() + "', '" + obj.getLength() + "', '"
							+ obj.getId_person() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Bike obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM Bike WHERE id_Person = '" + obj.getId_person() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Bike obj) {
		return false;
	}

	public Bike find(int id) {
		Bike bike = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT weight_Bike, type_Bike, lenght_Bike FROM Bike WHERE id_Person = '"
							+ id + "'");
			if (result.first())
				bike = new Bike(result.getInt("weight_Bike"), result.getString("type_Bike"), result.getInt("lenght_Bike"), id);
			return bike;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bike find(Object o) {
		return null;
	}

	@Override
	public Bike find(Bike obj) {
		return null;
	}

	@Override
	public int findId(Bike obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCategoryToPerson(String name, int category_number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bike> getAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPassengerCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBikeCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getDriver(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getDriverForPay(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPassenger(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
