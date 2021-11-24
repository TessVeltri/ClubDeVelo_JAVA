package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Registration;

public class RegistrationDAO extends DAO<Registration>{

	public RegistrationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Registration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Registration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Registration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Registration find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Registration find(Registration obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Registration> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findId(Registration obj) {
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
