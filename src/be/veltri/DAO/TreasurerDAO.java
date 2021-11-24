package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Treasurer;

public class TreasurerDAO extends DAO<Treasurer>{

	public TreasurerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Treasurer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Treasurer find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Treasurer find(Treasurer obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Treasurer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findId(Treasurer obj) {
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
