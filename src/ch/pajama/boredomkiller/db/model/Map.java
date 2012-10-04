package ch.pajama.boredomkiller.db.model;

public class Map {
	private String name;
	private Game game;
	private Playstyle[] playstyles;
	
	public Map(String name, Game game, Playstyle[] playstyles) {
		this.name = name;
		this.game = game;
		this.playstyles = playstyles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Playstyle[] getPlaystyles() {
		return playstyles;
	}

	public void setPlaystyles(Playstyle[] playstyles) {
		this.playstyles = playstyles;
	}
}
