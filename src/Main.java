import fileManager.FileManager;
import fileManager.Parser;
import game.GameManager;
import leaderboard.Leaderboard;

public class Main {

	public static void main(String[] args) {
		GameManager gm = new GameManager("words.txt");
		System.out.println(gm.toString());
		gm.gameMenu();
	}

}
