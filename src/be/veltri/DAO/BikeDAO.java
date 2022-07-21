package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Category;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;

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
							+ obj.getPerson().findId() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Bike obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM Bike WHERE id_Person = '" + obj.getPerson().findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Bike obj) {
		return false;
	}

	public Bike findBikeByPerson(Person person) {
		Bike bike = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT weight_Bike, type_Bike, lenght_Bike FROM Bike WHERE id_Person = '"
							+ person.findId() + "'");
			if (result.first())
				bike = new Bike(result.getInt("weight_Bike"), result.getString("type_Bike"), result.getInt("lenght_Bike"), person);
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
	public Bike findByName(Bike bike) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPassengerCount(Walk walk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBikeCount(Walk walk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getDriverForPay(Walk walk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPassenger(Walk walk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bike find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getDriver(Walk walk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> getAllCategory(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Registration> getAllRegistration(Walk walk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Walk> getAllWalk(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findCarForPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Walk> getWalkByPersonAndCategory(Person person, Category category) {
		// TODO Auto-generated method stub
		return null;
	}



}
