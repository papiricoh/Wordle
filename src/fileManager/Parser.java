package fileManager;

import leaderboard.Leader;


public class Parser {
	public static Leader[] parseLeaderboard(String toParse) {
		String separator = "\r\n";
		String dataSeparator = ":";
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
}
