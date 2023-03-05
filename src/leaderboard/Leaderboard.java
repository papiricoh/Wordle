package leaderboard;

import fileManager.FileManager;
import fileManager.Parser;

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

	public Leader[] getArrayLeaderboard() {
		Leader[] toReturn = new Leader[this.leaders.size()];
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = this.leaders.get(i);
		}
		return toReturn;
	}

	public Leader addToLeaderBoard(Leader newLeader) {
		this.leaders.add(newLeader);
		saveToFile(newLeader);
		return newLeader;
	}

	private void saveToFile(Leader newLeader) {
		FileManager fm = new FileManager("database.txt");
		fm.whiteUnparsedData(newLeader.getName() + ":" + newLeader.getPoints() + "\r\n");
	}

	public String getFormattedLeaderboard() {
		String result = "";
		for (int i = 0; i < this.leaders.size(); i++) {
			if(this.leaders.get(i) != null) {
				result += this.leaders.get(i).getName() + " : " + this.leaders.get(i).getPoints() + " pts\n";
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Leaderboard{" +
				"leaders=" + leaders +
				'}';
	}
}
