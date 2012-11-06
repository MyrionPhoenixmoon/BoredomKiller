package ch.pajama.boredomkiller.db;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ch.pajama.boredomkiller.db.model.Game;
import ch.pajama.boredomkiller.db.model.GameType;
import ch.pajama.boredomkiller.db.model.Map;
import ch.pajama.boredomkiller.db.model.Mode;
import ch.pajama.boredomkiller.db.model.Platform;
import ch.pajama.boredomkiller.db.model.Playstyle;

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
	
	public ArrayList<Game> getGames(Platform[] platforms, GameType[] gametypes, Playstyle[] playstyles, int players){
		ArrayList<Game> games = new ArrayList<Game>();
		
		String platformquery;
		if(platforms.length == 1){
			platformquery = "tbl_platforms.name = '" + platforms[0].getName() + "'";
		}
		else{
			platformquery = "( ";
			for(int i = 0; i < platforms.length; i++){
				platformquery += "tbl_platforms.name = '" + platforms[i].getName() + "'";
				if(i != platforms.length-1){
					platformquery += " OR ";
				}
			}
			platformquery += ")";
		}
		
		String gametypequery;
		if(gametypes.length == 1){
			gametypequery = "tbl_game_types.name = '" + gametypes[0].getName() + "'";
		}
		else{
			gametypequery = "( ";
			for(int i = 0; i < gametypes.length; i++){
				gametypequery += "tbl_game_types.name = '" + gametypes[i].getName() + "'";
				if(i != gametypes.length-1){
					gametypequery += " OR ";
				}
			}
			gametypequery += ")";
		}
		
		String playstylequery;
		if(playstyles.length == 1){
			playstylequery = "tbl_playstyles.name = '" + playstyles[0].getName() + "'";
		}
		else{
			playstylequery = "( ";
			for(int i = 0; i < playstyles.length; i++){
				playstylequery += "tbl_playstyles.name = '" + playstyles[i].getName() + "'";
				if(i != playstyles.length-1){
					playstylequery += " OR ";
				}
			}
			playstylequery += ")";
		}
		
		String query = "SELECT tbl_games.id, tbl_games.name FROM tbl_games LEFT JOIN tbl_platforms ON tbl_games.id_platform = tbl_platforms.id LEFT JOIN tbl_game_has_game_type ON tbl_games.id = tbl_game_has_game_type.id_game LEFT JOIN tbl_game_types ON tbl_game_types.id = tbl_game_has_game_type.id_game_type LEFT JOIN tbl_game_has_playstyle ON tbl_games.id = tbl_game_has_playstyle.id_game LEFT JOIN tbl_playstyles ON tbl_playstyles.id = tbl_game_has_playstyle.id_playstyle WHERE " + platformquery + " AND " + gametypequery + " AND " + playstylequery + " AND tbl_game_has_playstyle.min_Players <= '" + players + "' AND tbl_game_has_playstyle.max_Players >= '" + players + "';";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				//TODO replace null with real values
				Game g = new Game(rs.getString("name"), null, null, null, null);
				games.add(g);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return games;
	}
	
	public ArrayList<Map> getMaps(Game game, Playstyle[] playstyles){
		ArrayList<Map> maps = new ArrayList<Map>();
		
		String playstylequery;
		if(playstyles.length == 1){
			playstylequery = "tbl_playstyles.name = '" + playstyles[0].getName() + "'";
		}
		else{
			playstylequery = "( ";
			for(int i = 0; i < playstyles.length; i++){
				playstylequery += "tbl_playstyles.name = '" + playstyles[i].getName() + "'";
				if(i != playstyles.length-1){
					playstylequery += " OR ";
				}
			}
			playstylequery += ")";
		}
		
		String query = "SELECT tbl_maps.id, tbl_maps.name FROM tbl_maps LEFT JOIN tbl_games ON tbl_maps.id_game = tbl_games.id LEFT JOIN tbl_map_has_playstyle ON tbl_maps.id = tbl_map_has_playstyle.id_map LEFT JOIN tbl_playstyles ON tbl_playstyles.id = tbl_map_has_playstyle.id_playstyle WHERE " + playstylequery + " AND tbl_games.name = '" + game.getName() + "';";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				//TODO replace null with real values
				Map m = new Map(rs.getString("name"), null, null);
				maps.add(m);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return maps;
	}
	
	public ArrayList<Mode> getModes(Game game, Playstyle[] playstyles){
		ArrayList<Mode> modes = new ArrayList<Mode>();
		
		String playstylequery;
		if(playstyles.length == 1){
			playstylequery = "tbl_playstyles.name = '" + playstyles[0].getName() + "'";
		}
		else{
			playstylequery = "( ";
			for(int i = 0; i < playstyles.length; i++){
				playstylequery += "tbl_playstyles.name = '" + playstyles[i].getName() + "'";
				if(i != playstyles.length-1){
					playstylequery += " OR ";
				}
			}
			playstylequery += ")";
		}
		
		String query = "SELECT tbl_modes.id, tbl_modes.name FROM tbl_modes LEFT JOIN tbl_games ON tbl_modes.id_game = tbl_games.id LEFT JOIN tbl_mode_has_playstyle ON tbl_modes.id = tbl_mode_has_playstyle.id_mode LEFT JOIN tbl_playstyles ON tbl_playstyles.id = tbl_mode_has_playstyle.id_playstyle WHERE " + playstylequery + " AND tbl_games.name = '" + game.getName() + "';";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				//TODO replace null with real values
				Mode m = new Mode(rs.getString("name"), null, null);
				modes.add(m);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return modes;
	}
}
