package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Bike;
import be.veltri.POJO.Car;
import be.veltri.POJO.Category;
import be.veltri.POJO.Person;
import be.veltri.POJO.Registration;
import be.veltri.POJO.Walk;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T find(T obj);

	public abstract ArrayList<T> getAll();

	public abstract int findId(T obj);

	public abstract T findByName(T name);

	public abstract boolean addCategoryToPerson(String name, Category category);

	public abstract int getPassengerCount(Walk walk);

	public abstract int getBikeCount(Walk walk);

	public abstract ArrayList<String> getDriver(Walk walk);

	public abstract ArrayList<String> getDriverForPay(Walk walk);

	public abstract ArrayList<String> getPassenger(Walk walk);

	public abstract ArrayList<Category> getAllCategory(Person person);

	public abstract ArrayList<Registration> getAllRegistration(Walk walk);

	public abstract ArrayList<Walk> getAllWalk(Person person);

	public abstract T find(int findId);

	public abstract Car findCarForPerson(Person person);

	public abstract Bike findBikeByPerson(Person person);

	public abstract ArrayList<Walk> getWalkByPersonAndCategory(Person person, Category category);
}