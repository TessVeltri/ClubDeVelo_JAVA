package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Walk;

public class WalkDAO extends DAO<Walk> {

	public WalkDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Walk obj) {
		return false;
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
		return null;
	}

	public int findId(Walk obj) {
		return 0;
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
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT placeDeparture_Walk, dateDeptature_Walk, description_Walk, category_Walk, "
							+ "forfeit_Walk FROM Walk");
			while (result.next()) {
				Walk walk = new Walk(result.getString("placeDeparture_Walk"), result.getTimestamp("dateDeparture_Walk"),
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

}
