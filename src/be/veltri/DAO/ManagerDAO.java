package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Category;
import be.veltri.POJO.Manager;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;

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
	public Manager findByName(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCategoryToPerson(String name, Category category) {
		// TODO Auto-generated method stub
		return false;
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
	public ArrayList<Walk> getAllWalk(Person person) {
		// TODO Auto-generated method stub
		return null;
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
	public ArrayList<Walk> getWalkByPersonAndCategory(Person person, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
