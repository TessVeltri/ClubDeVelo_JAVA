package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Car;
import be.veltri.POJO.Person;

public class CarDAO extends DAO<Car> {

	public CarDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Car obj) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO Car(name_Car, nbrMemberPlace_Car, nbrBikePlace_Car, id_Person)"
							+ "Values('" + obj.getCarName() + "', '" + obj.getNbrMemberPlace() + "', '"
							+ obj.getNbrBikePlace() + "', '" + obj.getId_person() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Car obj) {
		try {
			int result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM Car WHERE id_Person = '"+ obj.getId_person() + "'");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Car obj) {
		return false;
	}

	public Car find(int id) {
		Car car = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name_Car, nbrMemberPlace_Car, nbrBikePlace_Car FROM Car WHERE id_Person = '"
							+ id + "'");
			if (result.first())
				car = new Car(result.getString("name_Car"), result.getInt("nbrMemberPlace_Car"),
						result.getInt("nbrBikePlace_Car"), id);
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
	public ArrayList<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Car> getAllById(int id) {
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
