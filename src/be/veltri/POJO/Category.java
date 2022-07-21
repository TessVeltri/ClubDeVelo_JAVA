package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public abstract class Category implements Serializable {

	// Parameters
	private static final long serialVersionUID = -9155000318506050985L;
	private int categoryNumber;
	private String categoryName;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Category> categoryDAO = dao.getCategoryDAO();
	// Builder with and without parameters
    public Category() {}

	public Category(int categoryNumber, String categoryName) {
		this.categoryNumber = categoryNumber;
		this.categoryName = categoryName;
	}

	// Getters and Setters 
	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	// Methods
	public ArrayList<Category> getAll(Person person){
		ArrayList<Category> lst_cat = categoryDAO.getAllCategory(person);
		return lst_cat;
	}
	
	public int findId() {
		int find = categoryDAO.findId(this);
		return find;
	}
    
	public ArrayList<String> checkDouble(Person person) {
		ArrayList<Category> lst_cat = this.getAll(person);
		
		ArrayList<String> lst_allCat = new ArrayList<String>(
				Arrays.asList("VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"));
		ArrayList<String> lst_allCat_tmp = new ArrayList<String>(
				Arrays.asList("VTT_Trialist", "VTT_Descent", "VTT_Hiker", "Cyclo"));
		
		for (String allCat : lst_allCat) {
			for (Category cat : lst_cat) {
				if (allCat.equals(cat.getCategoryName())) {
					lst_allCat_tmp.remove(allCat);
				}
			}
		}
		return lst_allCat_tmp;
	}
    

}