package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Calendar;
import be.veltri.POJO.Car;
import be.veltri.POJO.Category;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Trialist;
import be.veltri.POJO.Walk;

public class CalendarDAO extends DAO<Calendar> {

	public CalendarDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Calendar obj) {
		return false;
	}

	public boolean delete(Calendar obj) {
		return false;
	}

	public boolean update(Calendar obj) {
		return false;
	}

	public Calendar find(int id) {
		return null;
	}

	@Override
	public Calendar find(Calendar obj) {
		return null;
	}

	@Override
	public int findId(Calendar obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Calendar findByName(Calendar calendar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Calendar> getAll() {
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
	public ArrayList<Walk> getWalkByPersonAndCategory(Person person, Category category) {
		ArrayList<Walk> lst_walks = new ArrayList<Walk>();
		try {
			ResultSet result = null;
			// 
			if (person == null && category != null) { 
				result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery(
								"SELECT placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, "
										+ "forfeit_Walk FROM Walk WHERE category_Walk = '" + category.getCategoryName()
										+ "'");
				while (result.next()) {
					Walk walk = new Walk(result.getString("placeDeparture_Walk"), result.getDate("dateDeparture_Walk"),
							result.getString("description_Walk"), result.getString("category_Walk"),
							result.getInt("forfeit_Walk"));
					lst_walks.add(walk);
				}

			} else if (person != null) {

				ArrayList<Category> cat_list = new Trialist().getAll(person);

				if (category != null) {
					boolean flag_is_person_category = false;
					for (Category cat : cat_list) {
						if (cat.getCategoryName().equals(category.getCategoryName()))
							flag_is_person_category = true;
					}

					cat_list = new ArrayList<Category>();
					
					if (flag_is_person_category == true) {
						cat_list.add(category);
					}

				}

				for (Category cat : cat_list) {
					result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
							.executeQuery(
									"SELECT placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, "
											+ "forfeit_Walk FROM Walk WHERE category_Walk = '" + cat.getCategoryName()
											+ "'");
					while (result.next()) {
						Walk walk = new Walk(result.getString("placeDeparture_Walk"),
								result.getDate("dateDeparture_Walk"), result.getString("description_Walk"),
								result.getString("category_Walk"), result.getInt("forfeit_Walk"));
						lst_walks.add(walk);
					}
				}

			} else {

				result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeQuery(
								"SELECT placeDeparture_Walk, dateDeparture_Walk, description_Walk, category_Walk, "
										+ "forfeit_Walk FROM Walk");
				while (result.next()) {
					Walk walk = new Walk(result.getString("placeDeparture_Walk"), result.getDate("dateDeparture_Walk"),
							result.getString("description_Walk"), result.getString("category_Walk"),
							result.getInt("forfeit_Walk"));
					lst_walks.add(walk);
				}
			}

			return lst_walks;
		} catch (

		SQLException e) {
			e.printStackTrace();
			return null;
		}
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
	public ArrayList<Walk> getAllWalk(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
