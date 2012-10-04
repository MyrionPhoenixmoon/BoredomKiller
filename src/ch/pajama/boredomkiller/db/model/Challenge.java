package ch.pajama.boredomkiller.db.model;

public class Challenge {
	private String name;
	private String description;
	private Difficulty difficulty;
	private Statistic stat;
	private GameType gametype = null;
	private Game game = null;
	private Playstyle[] playstyles;
	
	public Challenge(String name, String description, Difficulty difficulty,
			Statistic stat, Playstyle[] playstyles) {
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.stat = stat;
		this.playstyles = playstyles;
	}

	public Challenge(String name, String description, Difficulty difficulty,
			Statistic stat, GameType gametype, Playstyle[] playstyles) {
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.stat = stat;
		this.gametype = gametype;
		this.playstyles = playstyles;
	}

	public Challenge(String name, String description, Difficulty difficulty,
			Statistic stat, Game game, Playstyle[] playstyles) {
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.stat = stat;
		this.game = game;
		this.playstyles = playstyles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Statistic getStat() {
		return stat;
	}

	public void setStat(Statistic stat) {
		this.stat = stat;
	}

	public GameType getGametype() {
		return gametype;
	}

	public void setGametype(GameType gametype) {
		this.gametype = gametype;
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
