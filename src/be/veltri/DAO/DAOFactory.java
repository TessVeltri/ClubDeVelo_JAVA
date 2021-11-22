package be.veltri.DAO;

import java.sql.Connection;

import be.veltri.DB.ClubDeVeloConnection;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = ClubDeVeloConnection.getInstance();
	
	
}
