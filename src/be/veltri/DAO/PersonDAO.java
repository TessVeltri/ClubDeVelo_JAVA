package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.veltri.POJO.Person;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Person obj) {
		return false;
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
}
