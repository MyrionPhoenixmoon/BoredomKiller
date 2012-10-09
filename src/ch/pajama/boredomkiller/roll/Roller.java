package ch.pajama.boredomkiller.roll;

import ch.pajama.boredomkiller.db.model.*;

public class Roller {
	private int amountPlayers;
	private Mode[] modes;
	private GameType[] gametypes;
	private Platform[] platforms;
	private Difficulty difficulty;
	private String setting;
	
	private Game game;
	private Map map;
	private Mode mode;
	private Challenge challenge;
	
	public Roller(int amountPlayers, Mode[] modes, GameType[] gametypes, Platform[] platforms, Difficulty difficulty, String setting) {
		this.amountPlayers = amountPlayers;
		this.modes = modes;
		this.gametypes = gametypes;
		this.platforms = platforms;
		this.difficulty = difficulty;
		this.setting = setting;
		rollGame();
		rollMap();
		rollMode();
		rollChallenge();
	}
	
	private void rollGame(){
		//TODO
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
