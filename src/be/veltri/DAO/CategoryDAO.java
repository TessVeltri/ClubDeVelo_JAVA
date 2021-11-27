package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Category;
import be.veltri.POJO.Cyclo;
import be.veltri.POJO.Descent;
import be.veltri.POJO.Hiker;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Trialist;

public class CategoryDAO extends DAO<Category> {

	public CategoryDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Category obj) {
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		return false;
	}

	@Override
	public boolean update(Category obj) {
		return false;
	}

	@Override
	public Category find(int id) {
		return null;
	}

	@Override
	public Category find(Category obj) {
		return null;
	}

	@Override
	public int findId(Category obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT id_Category FROM Category WHERE type_Category = '" + obj.getCategoryName() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
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
	public ArrayList<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> getAllById(int id) {
		ArrayList<Category> lst_cat = new ArrayList<Category>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT id_Category FROM Category_Person WHERE id_Person = '" + id + "'");
			while (result.next()) {
				if (result.getInt(1) == 1) {
					Category cat = new Trialist();
					lst_cat.add(cat);
				} else if (result.getInt(1) == 2) {
					Category cat = new Descent();
					lst_cat.add(cat);
				} else if (result.getInt(1) == 3) {
					Category cat = new Hiker();
					lst_cat.add(cat);
				} else if (result.getInt(1) == 4) {
					Category cat = new Cyclo();
					lst_cat.add(cat);
				}
			}
			return lst_cat;
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
