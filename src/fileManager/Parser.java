package fileManager;

import game.Word;
import leaderboard.Leader;


public class Parser {

	private static final String separator = "\r\n";
	private static final String dataSeparator = ":";
	public static Leader[] parseLeaderboard(String toParse) {
		String[] separatedString = toParse.split(separator);
		Leader[] leaderList = new Leader[separatedString.length];
		for (int i = 0; i < separatedString.length; i++) {
			if(!separatedString[i].equals("##########")) {
				String[] leader_data = separatedString[i].split(dataSeparator);
				leaderList[i] = new Leader(leader_data[0], Integer.parseInt(leader_data[1]));
			}
		}
		return leaderList;
	}

	public static String unParseLeaderboard(Leader[] leaderList) {
		String returnedString = "##########\r\n";
		for (int i = 0; i < leaderList.length; i++) {
			if(leaderList[i] != null) {
				returnedString += leaderList[i].getName() + ":" + leaderList[i].getPoints() + "\r\n";
			}
		}
		return returnedString;
	}

	public static Word[] parseWords(String toParse) {
		String[] separatedString = toParse.split(separator);
		Word[] words = new Word[separatedString.length];
		for (int i = 0; i < separatedString.length; i++) {
			words[i] = new Word(separatedString[i]);
		}
		return words;
	}
}
