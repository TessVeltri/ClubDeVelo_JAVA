package be.veltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.veltri.POJO.Member;

public class MemberDAO extends DAO<Member>{

	public MemberDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Member obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member find(Member obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findId(Member obj) {
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
