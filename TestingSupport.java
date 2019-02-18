package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestingSupport {
	
	/**
	 * @param filename
	 * @param results
	 * @return true if contents of filename match game results
	 */
	public static boolean correctResults(String filename, String results) {
		String officialResults="";
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
           
            String line;
            while ((line = fin.readLine()) != null) {
                officialResults += line + "\n";
            }
            fin.close();
            
        }catch (IOException e) {
            System.out.println("File opening failed.");
            return false;
        } 
        
        if (results.equals(officialResults)) {
            return true;
        }
        
        return false;
    }
	
	/**
	 * Writes content to a file called filename
	 * @param filename
	 * @param content
	 */
	public static void writeToFile(String filename, String content) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
					filename, false));
			bufferedWriter.write(content);
			
			bufferedWriter.close(); 
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
