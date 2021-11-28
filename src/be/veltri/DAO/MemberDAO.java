package be.veltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.veltri.POJO.Member;
import be.veltri.POJO.Person;

public class MemberDAO extends DAO<Member> {

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
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"UPDATE Person " + "SET name_Person = '" + obj.getName() + "', " + "firstname_Person = '"
									+ obj.getFirstname() + "', " + "phone_Person = '" + obj.getFirstname() + "', "
									+ "password_Person = '" + obj.getPassword() + "', " + "pay_Person = '"
									+ obj.getPay() + "' , payed = '" + obj.isPayed() + "' " + "WHERE username_Person = '" + obj.getUsername() + "'");
			if (result == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
		ArrayList<Member> lst_pers = new ArrayList<Member>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT username_Person, name_Person, firstname_Person, password_Person, pay_Person, payed "
							+ "FROM Person WHERE type_Person = 'Member'");
			while (result.next()) {
				Member pers = new Member(result.getString("username_Person"), result.getString("name_Person"),
						result.getString("firstname_Person"), "", result.getString("password_Person"), "Member",
						result.getInt("pay_Person"), result.getBoolean("payed"));
				lst_pers.add(pers);
			}
			return lst_pers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int findId(Member obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member findByName(String name) {
		Member pers = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name_Person, firstname_Person, phone_Person, password_Person, type_Person, pay_Person, payed"
									+ " FROM Person WHERE username_Person = '" + name + "'");
			if (result.first()) {
				pers = new Member(name, result.getString("name_Person"), result.getString("firstname_Person"),
						result.getString("phone_Person"), result.getString("password_Person"),
						result.getString("type_Person"), result.getInt("pay_Person"), result.getBoolean("payed"));
			}
			return pers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCategoryToPerson(String name, int category_number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Member> getAllById(int id) {
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
