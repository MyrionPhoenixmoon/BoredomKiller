package ch.pajama.boredomkiller.roll;

import java.util.ArrayList;

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
	private Connector con;
	private QueryHandler qh;
	
	private Game game;
	private Map map;
	private Mode mode;
	private Challenge challenge;
	
	public Roller(int amountPlayers, Playstyle[] playstyles, GameType[] gametypes, Platform[] platforms, Difficulty difficulty, String setting, Connector con) {
		this.amountPlayers = amountPlayers;
		this.playstyles = playstyles;
		this.gametypes = gametypes;
		this.platforms = platforms;
		this.difficulty = difficulty;
		this.setting = setting;
		this.con = con;
		qh = new QueryHandler(con.getConnection());
		
		game = rollGame();
		map = rollMap();
		mode = rollMode();
		challenge = rollChallenge();
		
		System.out.println("Game: " + game.getName());
		System.out.println("Map: " + map.getName());;
		System.out.println("Mode: " + mode.getName());
		System.out.println("Challenge: " + challenge.getName());
	}
	
	private Game rollGame(){
		ArrayList<Game> games = qh.getGames(platforms, gametypes, playstyles, amountPlayers);
		
		if(games.size() > 0){
			int random = (int) Math.round(Math.random()*(games.size()-1));
			return games.get(random);
		}
		else return new Game("No Match found!", null, null, null, null);
	}

	private Map rollMap(){
		ArrayList<Map> maps = qh.getMaps(game, playstyles);
		
		if(maps.size() > 0){
			int random = (int) Math.round(Math.random()*(maps.size()-1));
			return maps.get(random);
		}
		else return new Map("No Map found!", null, null);
	}
	
	private Mode rollMode(){
		ArrayList<Mode> modes = qh.getModes(game, playstyles);
		
		if(modes.size() > 0){
			int random = (int) Math.round(Math.random()*(modes.size()-1));
			return modes.get(random);
		}
		else return new Mode("No Mode found!", null, null);
	}
	
	private Challenge rollChallenge(){
		//TODO
		return new Challenge("TODO", null, null, null, null);
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
