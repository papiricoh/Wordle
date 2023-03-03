import fileManager.FileManager;
import fileManager.Parser;
import leaderboard.Leaderboard;

public class Main {

	public static void main(String[] args) {
		FileManager fm = new FileManager("database.txt");
		Leaderboard leaderboard = new Leaderboard(Parser.parseLeaderboard(fm.getRawData()));
		System.out.println(leaderboard.toString());
	}

}
