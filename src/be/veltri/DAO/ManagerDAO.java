package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Manager;

public class ManagerDAO extends DAO <Manager>{

	public ManagerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Manager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Manager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Manager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Manager find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager find(Manager obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Manager> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findId(Manager obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Manager findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, int category_number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Manager> getAllById(int id) {
		// TODO Auto-generated method stub
		return null;
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
