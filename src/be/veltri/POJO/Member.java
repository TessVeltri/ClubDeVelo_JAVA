package be.veltri.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.veltri.DAO.AbstractDAOFactory;
import be.veltri.DAO.DAO;

public class Member extends Person implements Serializable {

	// Parameters
	private static final long serialVersionUID = -4534714288962563667L;
	private float pay = 0;
	private boolean payed = false;

	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Member> memberDAO = dao.getMemberDAO();

	// Builder with and without parameters
	public Member() {
	}

	public Member(String username, String name, String firstname, String phone, String password, String type,
			float pay) {
		super(username, name, firstname, phone, password, type);
		this.pay = pay;
	}

	public Member(String username, String name, String firstname, String phone, String password, String type, float pay,
			boolean payed) {
		super(username, name, firstname, phone, password, type);
		this.pay = pay;
		this.payed = payed;
	}

	// Getters and Setters
	public float getPay() {
		Category cat = new Trialist();
		ArrayList<Category> lst_cat = cat.getAll(this);
		this.setPay(20 + ((lst_cat.size() - 1) * 5));
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	// Methods
	public ArrayList<Member> getAll() {
		ArrayList<Member> lst_pers = memberDAO.getAll();
		return lst_pers;
	}

	public boolean update(Member member) {
		boolean update = memberDAO.update(member);
		return update;
	}
	public Member findByName () {
		Member find = memberDAO.findByName(this);
		return find;
	}
}