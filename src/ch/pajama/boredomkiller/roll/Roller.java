package ch.pajama.boredomkiller.roll;

import java.sql.Connection;

import ch.pajama.boredomkiller.db.Connector;
import ch.pajama.boredomkiller.db.QueryHandler;
import ch.pajama.boredomkiller.db.model.*;

public class Roller {
	private int amountPlayers;
	private Playstyle[] playstyles;
	private GameType[] gametypes;
	private Platform[] platforms;
	private Difficulty difficulty;
	private String setting;
	private Connection con;
	private QueryHandler qh;
	
	private Game game;
	private Map map;
	private Mode mode;
	private Challenge challenge;
	
	public Roller(int amountPlayers, Playstyle[] playstyles, GameType[] gametypes, Platform[] platforms, Difficulty difficulty, String setting, Connection con) {
		this.amountPlayers = amountPlayers;
		this.playstyles = playstyles;
		this.gametypes = gametypes;
		this.platforms = platforms;
		this.difficulty = difficulty;
		this.setting = setting;
		this.con = con;
		qh = new QueryHandler(con);
		
		rollGame();
		rollMap();
		rollMode();
		rollChallenge();
	}
	
	private void rollGame(){
		//TODO
		qh.getGames(platforms, gametypes, playstyles, amountPlayers);
	}

	private void rollMap(){
		//TODO
	}
	
	private void rollMode(){
		//TODO
	}
	
	private void rollChallenge(){
		//TODO
	}
	
	public Game getGame() {
		return game;
	}

	public Map getMap() {
		return map;
	}

	public Mode getMode() {
		return mode;
	}

	public Challenge getChallenge() {
		return challenge;
	}
}
