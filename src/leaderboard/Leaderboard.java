package leaderboard;

import java.util.ArrayList;

public class Leaderboard {
	ArrayList<Leader> leaders;

	public Leaderboard(Leader[] parsedLeader) {
		this.leaders = new ArrayList<Leader>();
		for (int i = 0; i < parsedLeader.length; i++) {
			this.leaders.add(parsedLeader[i]);
		}
	}

	public ArrayList<Leader> getLeaderboard() {
		return this.leaders;
	}

	public Leader addToLeaderBoard(Leader newLeader) {
		return newLeader;
	}

	@Override
	public String toString() {
		return "Leaderboard{" +
				"leaders=" + leaders +
				'}';
	}
}
