package game;

import config.Config;
import fileManager.FileManager;
import fileManager.Parser;
import leaderboard.Leaderboard;

import java.security.InvalidParameterException;
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
            System.out.print("Select option: ");
            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    startGame();
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

    private void startGame() {
        Scanner gameScanner = new Scanner(System.in);
        for (int i = 0; i < this.words.length; i++) {
            WordRenderer wr = new WordRenderer(this.words[i]);
            System.out.println(wr.getRenderWord());
            int counter = 0;
            while(!wr.checkSuccess() && counter < Config.TRIES) {
                String currentWord = gameScanner.nextLine();
                try {
                    String renderedWord = wr.tryWord(currentWord);
                    System.out.println(renderedWord);
                    counter++;
                }catch (InvalidParameterException e) {
                    System.err.println(e.getMessage());
                }
            }
            if(wr.checkSuccess()) {
                System.out.println("Congratulations!! the word was: " + wr.getRenderWord());
            }else {
                System.out.println("No more tries, the word was: " + wr.getOriginalWord());
            }
        }
        System.out.println("Game Over");
    }

    @Override
    public String toString() {
        return "GameManager{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}
