package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Category;
import be.veltri.POJO.Member;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Person obj) {
		try {
			this.connect.createStatement().executeUpdate(
					"INSERT INTO Person(username_Person, name_Person, firstname_Person, phone_Person, password_Person, "
							+ "type_Person, pay_Person) Values('" + obj.getUsername() + "', '" + obj.getName() + "', '"
							+ obj.getFirstname() + "', '" + obj.getPhone() + "', '" + obj.getPassword() + "', '"
							+ obj.getType() + "', '20')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Person obj) {
		return false;
	}

	public boolean update(Person obj) {
		return false;
	}

	public Person find(int id) {
		return null;
	}

	public Person find(Person obj) {
		Person person = new Person();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT username_Person, name_Person, firstname_Person, phone_Person, password_Person, "
									+ "type_Person, pay_Person FROM Person WHERE username_Person = '"
									+ obj.getUsername() + "' AND password_Person = '" + obj.getPassword() + "'");
			if (result.first())
				person = new Person(obj.getUsername(), result.getString("name_Person"),
						result.getString("firstname_Person"), result.getString("phone_Person"), obj.getPassword(),
						result.getString("type_Person"));
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int findId(Person obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT id_Person FROM Person WHERE username_Person = '" + obj.getUsername()
							+ "' AND password_Person = '" + obj.getPassword() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Person findByName(Person person) {
		Person pers = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name_Person, firstname_Person, phone_Person, password_Person, type_Person, pay_Person, payed"
									+ " FROM Person WHERE username_Person = '" + person.getUsername() + "'");
			if (result.first()) {
				pers = new Member(person.getUsername(), result.getString("name_Person"), result.getString("firstname_Person"),
						result.getString("phone_Person"), result.getString("password_Person"),
						result.getString("type_Person"), result.getInt("pay_Person"), result.getBoolean("payed"));
			}
			return pers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addCategoryToPerson(String name, Category category) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT id_Person FROM Person WHERE username_Person = '" + name + "'");
			if (result.first()) {
				int id = result.getInt(1);
				try {
					this.connect.createStatement()
							.executeUpdate("INSERT INTO Category_Person (id_Person, id_Category) VALUES ('" + id
									+ "' , '" + category.findId() + "')");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Person> getAll() {
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
