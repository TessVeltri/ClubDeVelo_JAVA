package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Person;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);

	public abstract T find(T obj);
	
	public abstract ArrayList<T> getAll();
	
	public abstract ArrayList<T> getAllById(int id);
	
	public abstract int findId (T obj);

	public abstract boolean findByName (String name);
	
	public abstract boolean addCategoryToPerson (String name, int category_number);

	public abstract int getPassengerCount (int id);

	public abstract int getBikeCount (int id);
	
	public abstract ArrayList<String> getDriver (int id);

	public abstract ArrayList<String> getDriverForPay (int id);
	
	public abstract ArrayList<String> getPassenger (int id);
	
}