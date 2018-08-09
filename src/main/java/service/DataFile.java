package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataFile {
	public void saveToFile(String fileName,String data) {           
		   
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
	            Scanner scanner = new Scanner(fileData);
	           
	            while (scanner.hasNextLine()) {
	                data = data + scanner.nextLine() + "\n";
	            }   
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found");
	        }
	        return data;
	    }
}
