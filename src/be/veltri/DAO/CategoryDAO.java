package be.veltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import be.veltri.POJO.Category;

public class CategoryDAO extends DAO<Category>{

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

}
