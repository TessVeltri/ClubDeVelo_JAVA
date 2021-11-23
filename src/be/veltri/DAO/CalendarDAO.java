package be.veltri.DAO;

import java.sql.Connection;

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
	

}
