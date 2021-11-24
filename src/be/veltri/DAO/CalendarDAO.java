package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Calendar;

public class CalendarDAO extends DAO<Calendar>{

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
	public ArrayList<Calendar> getAll() {
		return null;
	}
	

}
