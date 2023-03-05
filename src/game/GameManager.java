package game;

import fileManager.FileManager;
import fileManager.Parser;
import leaderboard.Leaderboard;

import java.util.Arrays;
import java.util.Scanner;

public class GameManager {
    private Word[] words;

    public GameManager(String route) {
        FileManager fm = new FileManager(route);
        this.words = Parser.parseWords(fm.getRawData());
    }

    public void gameMenu() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("WORDLE\n1: Start game\n2: Leaderboard\n3: Exit");
            System.out.print("Select option");
            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    startGame(scan);
                    break;
                case 2:
                    FileManager fm = new FileManager("database.txt");
                    //TODO Short rawData
                    System.out.println(fm.getRawData());
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }

        scan.close();
    }

    private void startGame(Scanner scan) {

    }

    @Override
    public String toString() {
        return "GameManager{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}
