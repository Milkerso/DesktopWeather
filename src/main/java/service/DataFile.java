package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DataFile {
	private Scanner scanner;

	public void saveToFile(String fileName, String data) {

		try {
			PrintWriter out = new PrintWriter(fileName);
			out.println(data);
			out.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error, Can't create the file");
		}
	}

	public String readToFile(String fileName) {

		File fileData = new File(fileName);
		String data = "";
		try {
			scanner = new Scanner(fileData);

			while (scanner.hasNextLine()) {
				data = data + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return data;
	}
	
	public boolean netIsAvailable() {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			return true;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			return false;
		}
	}
}
