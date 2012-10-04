package ch.pajama.boredomkiller.db.model;

public class Player {
	private String name;
	private Statistic stat;
	
	public Player(String name, Statistic stat) {
		this.name = name;
		this.stat = stat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Statistic getStat() {
		return stat;
	}

	public void setStat(Statistic stat) {
		this.stat = stat;
	}
}
