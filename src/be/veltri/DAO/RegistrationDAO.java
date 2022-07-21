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

public class RegistrationDAO extends DAO<Registration> {

	public RegistrationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Registration obj) {
		try {
			this.connect.createStatement().executeUpdate(
					"INSERT INTO Registration(driver_registration, passenger_Registration, bike_Registration, id_Person, id_Walk "
							+ ") Values('" + obj.isDriver() + "', '" + obj.isPassenger() + "', '" + obj.isBike()
							+ "', '" + obj.getPerson().findId() + "', '" + obj.getWalk().findId() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Registration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Registration obj) {
		Registration rg = null;
		try {
			int result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE Registration "
							+ "SET driver_Registration = '" + obj.isDriver() + "', "
							+ "passenger_Registration = '"+ obj.isPassenger() +"' "
							+ "WHERE id_Person = '" + obj.getPerson().findId() + "' AND id_Walk = '" + obj.getWalk().findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Registration find(int id) {
		return null;
	}

	@Override
	public Registration find(Registration obj) {
		Registration rg = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Registration WHERE id_person = '" + obj.getPerson().findId()+ "' AND id_Walk = '"
							+ obj.getWalk().findId() + "'");
			if (result.first()) {
				rg = new Registration ();
			}
			return rg;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Registration> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findId(Registration obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Registration findByName(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Registration> getAllRegistration(Walk walk) {
		ArrayList<Registration> lst_reg = new ArrayList<Registration>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT driver_Registration, passenger_Registration, bike_Registration, id_Person, id_Walk "
									+ "FROM Registration WHERE id_Walk = '" + walk.findId() + "'");
			while (result.next()) {
				Registration reg = new Registration(result.getBoolean("driver_Registration"),
						result.getBoolean("passenger_Registration"), result.getBoolean("bike_Registration"));
				lst_reg.add(reg);
			}
			return lst_reg;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getPassengerCount(Walk walk) {
		int count = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT COUNT(*) FROM Registration WHERE passenger_Registration = 1 AND id_Walk = '"
							+ walk.findId() + "'");
			if (result.first()) {
				count = result.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<String> getDriver(Walk walk) {
		ArrayList<String> lst_dataDriver = new ArrayList<String>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT username_Person, name_Person, firstname_Person, nbrMemberPlace_Car, nbrBikePlace_Car "
									+ "FROM Registration INNER JOIN Person ON Person.id_Person = Registration.id_Person "
									+ "LEFT JOIN Car on Car.id_Person = Person.id_Person "
									+ "WHERE driver_Registration = 1 AND id_Walk = '" + walk.findId() + "'");
			if (result.first()) {
				lst_dataDriver.add(result.getString("username_Person"));
				lst_dataDriver.add(result.getString("name_Person"));
				lst_dataDriver.add(result.getString("firstname_Person"));
				lst_dataDriver.add(result.getString("nbrMemberPlace_Car"));
				lst_dataDriver.add(result.getString("nbrBikePlace_Car"));
			}
			return lst_dataDriver;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getBikeCount(Walk walk) {
		int count = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT COUNT(*) FROM Registration WHERE bike_Registration = 1 AND id_Walk = '" + walk.findId() + "'");
			if (result.first()) {
				count = result.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<String> getDriverForPay(Walk walk) {
		ArrayList<String> lst_dataDriver = new ArrayList<String>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name_Person, firstname_Person, Walk.id_Walk, Walk.forfeit_Walk "
									+ "FROM Registration "
									+ "INNER JOIN Person ON Person.id_Person = Registration.id_Person "
									+ "INNER JOIN Walk on Walk.id_Walk = Registration.id_Walk "
									+ "WHERE driver_Registration = 1 AND id_Walk = '" + walk.findId() + "'");
			while(result.next())
			{
				lst_dataDriver.add(result.getString("name_Person"));
				lst_dataDriver.add(result.getString("firstname_Person"));
				lst_dataDriver.add(result.getString("id_Walk"));
				lst_dataDriver.add(result.getString("forfeit_Walk"));
			}
			return lst_dataDriver;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<String> getPassenger(Walk walk) {
		ArrayList<String> lst_passenger = new ArrayList<String>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name_Person, firstname_Person, Walk.id_Walk, Walk.forfeit_Walk "
									+ "FROM Registration "
									+ "INNER JOIN Person ON Person.id_Person = Registration.id_Person "
									+ "INNER JOIN Walk on Walk.id_Walk = Registration.id_Walk "
									+ "WHERE passenger_Registration = 1 AND id_Walk = '" + walk.findId() + "'");
			while(result.next())
			{
				lst_passenger.add(result.getString("name_Person"));
				lst_passenger.add(result.getString("firstname_Person"));
				lst_passenger.add(result.getString("id_Walk"));
				lst_passenger.add(result.getString("forfeit_Walk"));
			}
			return lst_passenger;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Category> getAllCategory(Person person) {
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
