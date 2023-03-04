package game;

import fileManager.FileManager;
import fileManager.Parser;

import java.util.Arrays;

public class GameManager {
    private Word[] words;

    public GameManager(String route) {
        FileManager fm = new FileManager(route);
        this.words = Parser.parseWords(fm.getRawData());
    }

    @Override
    public String toString() {
        return "GameManager{" +
                "words=" + Arrays.toString(words) +
                '}';
    }
}
