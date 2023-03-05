package game;

import java.security.InvalidParameterException;

public class WordRenderer {
    private char[] orWord;
    private char[] renderedWord;

    public WordRenderer(Word originalWord) {
        this.orWord = new char[originalWord.getFullWord().length()];
        String fullWord = originalWord.getFullWord();
        for (int i = 0; i < orWord.length; i++) {
            this.orWord[i] = fullWord.charAt(i);
        }
        this.renderedWord = new char[originalWord.getFullWord().length()];
        for (int i = 0; i < this.renderedWord.length; i++) {
            this.renderedWord[i] = '_';
        }
    }

    public String getRenderWord() {
        String result = "";
        for (int i = 0; i < this.renderedWord.length; i++) {
            result += this.renderedWord[i];
        }
        return result;
    }

    public String tryWord(String word) throws InvalidParameterException {
        if(word.length() != this.orWord.length) {
            throw new InvalidParameterException("The Word must be " + this.orWord.length + " in length");
        }
        for (int i = 0; i < this.orWord.length; i++) {
            if(this.renderedWord[i] == '_' || this.renderedWord[i] == '*') {
                if(this.orWord[i] == word.charAt(i)) {
                    this.renderedWord[i] = this.orWord[i];
                }else {
                    this.renderedWord[i] = checkChar(word.charAt(i));
                }
            }
        }
        return getRenderWord();
    }
    public boolean checkSuccess() {
        for (int i = 0; i < this.orWord.length; i++) {
            if(this.orWord[i] != this.renderedWord[i]) {
                return false;
            }
        }
        return true;
    }

    private char checkChar(char charAt) {
        for (int i = 0; i < this.orWord.length; i++) {
            if(this.orWord[i] == charAt) {
                return '*';
            }
        }
        return '_';
    }

    public String getOriginalWord() {
        String result = "";
        for (int i = 0; i < this.orWord.length; i++) {
            result += this.orWord[i];
        }
        return result;
    }
}
