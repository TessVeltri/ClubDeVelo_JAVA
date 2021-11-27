package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;

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
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Person WHERE username_Person = '" + obj.getUsername()
							+ "' AND password_Person = '" + obj.getPassword() + "'");
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

	public boolean findByName(String name) {
		boolean verif = false;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT 1 FROM Person WHERE username_Person = '" + name + "'");
			if (result.first()) {
				if (result.getInt(1) == 1)
					verif = true;
			}
			return verif;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addCategoryToPerson(String name, int category_Number) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT id_Person FROM Person WHERE username_Person = '" + name + "'");
			if (result.first()) {
				int id = result.getInt(1);
				try {
					this.connect.createStatement()
							.executeUpdate("INSERT INTO Category_Person (id_Person, id_Category) VALUES ('" + id
									+ "' , '" + category_Number + "')");
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
	public ArrayList<Person> getAllById(int id) {
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

}
