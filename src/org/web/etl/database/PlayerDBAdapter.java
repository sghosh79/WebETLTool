package org.web.etl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.web.etl.tool.bean.Player;

//This class will connect to the database and runs queries specific for Player objects
public class PlayerDBAdapter extends AbstractDBAdapter {
	
	public String INSERT_PLAYER_SQL = "INSERT INTO Player ( Name )" +
											"VALUES ( ? )";
	
	public String GET_ALL_PLAYERS_SQL = "SELECT * FROM Player";
	
		
	//This is a sample for inserting a single player's name into the database
	public void insertPlayer(String name){		
		String sql = INSERT_PLAYER_SQL;
		Connection conn = getConnection();					//We always need to open and close the connection when working with the database
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(0, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//This is a simple method to fetch a table of information into a player object.  The below will only get larger as we add more properties to the object.
	public List<Player> getAllPlayers(){
		Player player = null;
		List<Player> playerList = new ArrayList<Player>();
		
		String sql = GET_ALL_PLAYERS_SQL;
		Connection conn = getConnection();					//We always need to open and close the connection when working with the database
		ResultSet rs = null;	
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {	
				player = new Player();
				String name = rs.getString("name");
				player.setName(name);
				playerList.add(player);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return playerList;
		
	}
}
