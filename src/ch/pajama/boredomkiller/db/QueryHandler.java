package ch.pajama.boredomkiller.db;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ch.pajama.boredomkiller.db.model.GameType;
import ch.pajama.boredomkiller.db.model.Platform;

public class QueryHandler {
	private Connection con;
	
	public QueryHandler(Connection con){
		this.con = con;
	}
	
	public ArrayList<Platform> getPlatforms(){
		ArrayList<Platform> plats = new ArrayList<Platform>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_platforms;");
			while(rs.next()){
				plats.add(new Platform(rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plats;
	}
	
	public ArrayList<GameType> getGameTypes(){
		ArrayList<GameType> gametypes = new ArrayList<GameType>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_game_types;");
			while(rs.next()){
				gametypes.add(new GameType(rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gametypes;
	}
}
