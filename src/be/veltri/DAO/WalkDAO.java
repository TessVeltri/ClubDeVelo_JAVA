package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Person;
import be.veltri.POJO.Walk;

public class WalkDAO extends DAO<Walk> {

	public WalkDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Walk obj) {
		try {
			this.connect.createStatement().executeUpdate(
					"INSERT INTO Walk(placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, forfeit_Walk) "
							+ "Values('" + obj.getPlaceDeparture() + "', '" + obj.getDateDeparture() + "', '"
							+ obj.getDescription_walk() + "', '" + obj.getCategory_walk() + "', '0')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Walk obj) {
		return false;
	}

	public boolean update(Walk obj) {
		return false;
	}

	public Walk find(int id) {
		return null;
	}

	public Walk find(Walk obj) {
		Walk walk = new Walk();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Walk WHERE placeDeparture_Walk = '" + obj.getPlaceDeparture()
							+ "' AND dateDeparture_Walk = '" + obj.getDateDeparture() + "' AND description_Walk = '"
							+ obj.getDescription_walk() + "' AND category_Walk = '" + obj.getCategory_walk() + "'");
			if (result.first())
				walk = new Walk(result.getString("placeDeparture_Walk"), result.getDate("dateDeparture_Walk"),
						result.getString("description_Walk"), result.getString("category_Walk"), 0);
			return walk;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int findId(Walk obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT id_Walk FROM Walk WHERE placeDeparture_Walk = '" + obj.getPlaceDeparture()
							+ "' AND dateDeparture_Walk = '" + obj.getDateDeparture() + "' AND description_Walk = '"
							+ obj.getDescription_walk() + "' AND category_Walk = '" + obj.getCategory_walk() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean findByName(String name) {
		return false;
	}

	public boolean addCategoryToPerson(String name, int category_number) {
		return false;
	}

	public ArrayList<Walk> getAll() {
		ArrayList<Walk> lst_walks = new ArrayList<Walk>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, "
							+ "forfeit_Walk FROM Walk");
			while (result.next()) {
				Walk walk = new Walk(result.getString("placeDeparture_Walk"), result.getDate("dateDeparture_Walk"),
						result.getString("description_Walk"), result.getString("category_Walk"),
						result.getInt("forfeit_Walk"));
				lst_walks.add(walk);
			}
			return lst_walks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Walk> getAllById(int id) {
		ArrayList<Walk> lst_walks = new ArrayList<Walk>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, "
							+ "forfeit_Walk FROM Walk INNER JOIN Registration reg ON reg.id_Walk = Walk.id_Walk WHERE reg.id_Person = "
							+ id + " ORDER BY Walk.id_Walk");
			while (result.next()) {
				Walk walk = new Walk(result.getString("placeDeparture_Walk"), result.getDate("dateDeparture_Walk"),
						result.getString("description_Walk"), result.getString("category_Walk"),
						result.getInt("forfeit_Walk"));
				lst_walks.add(walk);
			}
			return lst_walks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
