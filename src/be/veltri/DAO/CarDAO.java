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

public class CarDAO extends DAO<Car> {

	public CarDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Car obj) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Car(name_Car, nbrMemberPlace_Car, nbrBikePlace_Car, id_Person)"
							+ "Values('" + obj.getCarName() + "', '" + obj.getNbrMemberPlace() + "', '"
							+ obj.getNbrBikePlace() + "', '" + obj.getPerson().findId() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Car obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM Car WHERE id_Person = '" + obj.getPerson().findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Car obj) {
		return false;
	}

	public Car findCarForPerson(Person person) {
		Car car = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name_Car, nbrMemberPlace_Car, nbrBikePlace_Car FROM Car WHERE id_Person = '"
							+ person.findId() + "'");
			if (result.first())
				car = new Car(result.getString("name_Car"), result.getInt("nbrMemberPlace_Car"),
						result.getInt("nbrBikePlace_Car"), person);
			return car;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
	public Car findByName(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Car> getAll() {
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
	public ArrayList<String> getDriver(Walk walk) {
		// TODO Auto-generated method stub
		return null;
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
	public Car find(int findId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bike findBikeByPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Walk> getWalkByPersonAndCategory(Person person, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
