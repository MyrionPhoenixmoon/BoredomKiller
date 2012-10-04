package ch.pajama.boredomkiller.db.model;

public class Statistic {
	private int timesPlayed = 0;
	private int totalPlaytime = 0;
	
	public Statistic(int timesPlayed, int totalPlaytime){
		this.timesPlayed = timesPlayed;
		this.totalPlaytime = totalPlaytime;
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}

	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}

	public int getTotalPlaytime() {
		return totalPlaytime;
	}

	public void setTotalPlaytime(int totalPlaytime) {
		this.totalPlaytime = totalPlaytime;
	}
}
