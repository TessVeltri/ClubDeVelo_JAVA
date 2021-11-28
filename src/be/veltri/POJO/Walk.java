package be.veltri.POJO;

import java.io.Serializable; 
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.veltri.DAO.*;


public class Walk implements Serializable {

	// Parameters
	private static final long serialVersionUID = -386600856277767918L;
	private String placeDeparture = "";
	private Date dateDeparture = null;
	private String description_walk = "";
	private String category_walk = "";
	private int forfeit = 0;

    private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Walk> walkDAO = dao.getWalkDAO();

	// Builder with and without parameters
    public Walk() {}
    
    public Walk(String placeDeparture, Date dateDeparture, String description_walk, String category_walk, int forfeit) {
		this.placeDeparture = placeDeparture;
		this.dateDeparture = dateDeparture;
		this.description_walk = description_walk;
		this.setCategory_walk(category_walk);
		this.forfeit = forfeit;
	}

    // Getters and Setters
	public String getPlaceDeparture() {
		return placeDeparture;
	}
	public void setPlaceDeparture(String placeDeparture) {
		this.placeDeparture = placeDeparture;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}
	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public int getForfeit() {
		return forfeit;
	}
	public void setForfeit(int forfeit) {
		this.forfeit = forfeit;
	}

	public String getDescription_walk() {
		return description_walk;
	}

	public void setDescription_walk(String description_walk) {
		this.description_walk = description_walk;
	}
	
	public String getCategory_walk() {
		return category_walk;
	}

	public void setCategory_walk(String category_walk) {
		this.category_walk = category_walk;
	}

	// Methods 
    public ArrayList<Walk> getAll (){
		ArrayList<Walk> lst_walk = new ArrayList<Walk>();
		lst_walk = walkDAO.getAll();
		return lst_walk;
    }
    
    public ArrayList<Walk> getAllById(int id) {
    	ArrayList<Walk> lst_walk = new ArrayList<Walk>();
		lst_walk = walkDAO.getAllById(id);
		return lst_walk;
    }
    
    public int findId() {
    	int id = walkDAO.findId(this);
    	return id;
    }
    
    public Walk find () {
    	Walk walk = walkDAO.find(this);
    	return walk;
    }
    
    public boolean create () {
    	boolean create = walkDAO.create(this);
    	return create;
    }
    public boolean update (Walk walk) {
    	boolean update = walkDAO.update(walk);
    	return update;
    } 
}