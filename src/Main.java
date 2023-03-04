import fileManager.FileManager;
import fileManager.Parser;
import game.GameManager;
import leaderboard.Leaderboard;

public class Main {

	public static void main(String[] args) {
		FileManager fm = new FileManager("database.txt");
		Leaderboard leaderboard = new Leaderboard(Parser.parseLeaderboard(fm.getRawData()));
		System.out.println(leaderboard.toString());
		System.out.println(Parser.unParseLeaderboard(leaderboard.getArrayLeaderboard()));
		GameManager gm = new GameManager("words.txt");
		System.out.println(gm.toString());
	}

}
