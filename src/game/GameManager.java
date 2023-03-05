package game;

import config.Config;
import fileManager.FileManager;
import fileManager.Parser;
import leaderboard.Leader;
import leaderboard.Leaderboard;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameManager {
    private Word[] allWords;
    private Word[] words;
    private Leaderboard leaderboard;

    public GameManager(String route) {
        FileManager fm = new FileManager(route);
        this.words = Parser.parseWords(fm.getRawData());
        this.allWords = Arrays.copyOf(this.words, this.words.length);
        this.leaderboard = new Leaderboard(Parser.parseLeaderboard(new FileManager("database.txt").getRawData()));
    }

    public void gameMenu() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("WORDLE\n1: Start game\n2: Custom game\n3: Leaderboard\n4: Exit");
            System.out.print("Select option: ");
            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    this.words = Arrays.copyOf(this.allWords, this.allWords.length);
                    startGame();
                    break;
                case 2:
                    System.out.println("Input the length in number of the words");
                    this.words = filterWords(scan.nextInt());
                    startGame();
                    break;
                case 3:
                    System.out.println(this.leaderboard.getFormattedLeaderboard());
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }

        scan.close();
    }

    private Word[] filterWords(int length) {
        ArrayList<Word> listWords = new ArrayList<>();
        for (int i = 0; i < this.words.length; i++) {
            if (words[i].getFullWord().length() == length) {
                listWords.add(words[i]);
            }
        }
        return listWords.toArray(new Word[0]);
    }

    private void startGame() {
        Scanner gameScanner = new Scanner(System.in);
        boolean[] successWords = new boolean[this.words.length];
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
                successWords[i] = true;
                System.out.println("Congratulations!! the word was: " + wr.getRenderWord());
            }else {
                System.out.println("No more tries, the word was: " + wr.getOriginalWord());
            }
        }
        int points = calculatePoints(successWords);
        System.out.println("You have earned: " + points + " points");
        System.out.println("Game Over");
        System.out.print("\n\nInsert your name to register in the leaderboard: ");
        newLeader(gameScanner.nextLine(), points);
        System.out.println();
    }

    private void newLeader(String name, int points) {
        Leader newLeader = new Leader(name, points);
        this.leaderboard.addToLeaderBoard(newLeader);
    }

    private int calculatePoints(boolean[] successWords) {
        int points = 0;
        for (int i = 0; i < this.words.length; i++) {
            if(successWords[i]) {
                points += this.words[i].getPoints();
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return "GameManager{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}
