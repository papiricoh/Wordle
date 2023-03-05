import game.GameManager;

public class Main {

	public static void main(String[] args) {
		GameManager gm = new GameManager("words.txt");
		gm.gameMenu();
	}

}
