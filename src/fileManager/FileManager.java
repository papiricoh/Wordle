package fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private String route;
	private String rawData;
	
	public FileManager(String route) {
		this.route = route;
		try {
			FileReader file = new FileReader(route);
			this.rawData = getRawData(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error File Not Exists : " + e.getMessage());
			try {
				FileWriter writer = new FileWriter(route, true);
				writer.write("##########\n");
				writer.close();
			} catch (IOException e1) {
				System.err.println("Failed to create file that not exists : " + e.getMessage());
			}
		}
	}
	
	private void updateRawData(String data) {
		this.rawData = this.rawData + data;
	}
	
	public String getRawData() {
		return this.rawData;
	}
	
	public String getRawData(FileReader file) {
		String result = "";
		int character = 0;
		try {
			while ((character = file.read()) != -1) {
				result += ((char) character);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());;
		}
		return result;
	}
	
	public void whiteDeparsedData(String data) {
		FileWriter writer;
		try {
			writer = new FileWriter(this.route, true);
			writer.write(data);
			updateRawData(data);
			writer.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
}
