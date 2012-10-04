package ch.pajama.boredomkiller.db;

import java.sql.Connection;
import java.util.ArrayList;

import ch.pajama.boredomkiller.db.model.GameType;
import ch.pajama.boredomkiller.db.model.Platform;

public class QueryHandler {
	private Connection con;
	
	public QueryHandler(Connection con){
		this.con = con;
	}
	
	public ArrayList<Platform> getPlatforms(){
		ArrayList<Platform> plats = new ArrayList<Platform>();
		//TODO read from DB
		plats.add(new Platform("PC"));
		plats.add(new Platform("SNES"));
		plats.add(new Platform("N64"));
		plats.add(new Platform("PS2"));
		plats.add(new Platform("PS3"));
		
		return plats;
	}
	
	public ArrayList<GameType> getGameTypes(){
		ArrayList<GameType> gametypes = new ArrayList<GameType>();
		//TODO read from DB
		gametypes.add(new GameType("Shooter"));
		gametypes.add(new GameType("RPG"));
		gametypes.add(new GameType("Adventure"));
		gametypes.add(new GameType("Racing"));
		gametypes.add(new GameType("Fighting"));
		gametypes.add(new GameType("Rhythm"));
		
		return gametypes;
	}
}
