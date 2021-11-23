package be.veltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import be.veltri.POJO.Category_Person;

public class Category_PersonDAO extends DAO<Category_Person> {

	public Category_PersonDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Category_Person obj) {
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Category_Person(id_Person, id_Category) Values('"
					+ obj.getId_person() + "', '" + obj.getId_category() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category_Person obj) {
		return false;
	}

	public boolean update(Category_Person obj) {
		return false;
	}

	public Category_Person find(int id) {
		return null;
	}

	public Category_Person find(Category_Person obj) {
		return null;
	}

	@Override
	public int findId(Category_Person obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
