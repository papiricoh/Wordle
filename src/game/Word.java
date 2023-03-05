package game;

import config.Config;

public class Word {
    private String fullWord;

    public Word(String fullWord) {
        this.fullWord = fullWord;
    }

    public String getFullWord() {
        return fullWord;
    }

    public int getPoints() {
        int points = 0;
        for (int i = 0; i < this.fullWord.length(); i++) {
            for (int j = 0; j < Config.CONSONANTS.length; j++) {
                if(this.fullWord.charAt(i) == Config.CONSONANTS[j]) {
                    points += Config.CONSONANT_POINTS;
                }
            }
            for (int j = 0; j < Config.VOWELS.length; j++) {
                if(this.fullWord.charAt(i) == Config.VOWELS[j]) {
                    points += Config.VOWEL_POINTS;
                }
            }
        }
        return points;
    }
}
