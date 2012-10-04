package ch.pajama.boredomkiller.db.model;

public class Game {
	private String name;
	private String theme_loc = null;
	private Statistic stat;
	private Platform[] plats;
	private Playstyle[] playstyles;
	private GameType[] gametypes;
	
	public Game(String name, Statistic stat, Platform[] plats,
			Playstyle[] playstyles, GameType[] gametypes) {
		this.name = name;
		this.stat = stat;
		this.plats = plats;
		this.playstyles = playstyles;
		this.gametypes = gametypes;
	}

	public Game(String name, String theme_loc, Statistic stat,
			Platform[] plats, Playstyle[] playstyles, GameType[] gametypes) {
		this.name = name;
		this.theme_loc = theme_loc;
		this.stat = stat;
		this.plats = plats;
		this.playstyles = playstyles;
		this.gametypes = gametypes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheme_loc() {
		return theme_loc;
	}

	public void setTheme_loc(String theme_loc) {
		this.theme_loc = theme_loc;
	}

	public Statistic getStat() {
		return stat;
	}

	public void setStat(Statistic stat) {
		this.stat = stat;
	}

	public Platform[] getPlats() {
		return plats;
	}

	public void setPlats(Platform[] plats) {
		this.plats = plats;
	}

	public Playstyle[] getPlaystyles() {
		return playstyles;
	}

	public void setPlaystyles(Playstyle[] playstyles) {
		this.playstyles = playstyles;
	}

	public GameType[] getGametypes() {
		return gametypes;
	}

	public void setGametypes(GameType[] gametypes) {
		this.gametypes = gametypes;
	}
}
