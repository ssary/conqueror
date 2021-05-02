package engine;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;


public class ReadingCSVFile {
	
	public static ArrayList<String [] > readFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		ArrayList<String [] > v = new ArrayList<String [] >();
		
		while ((currentLine = br.readLine()) != null)
		{
		String [] tmp = currentLine.split(",") ;
		v.add(tmp);
		//System.out.println(currentLine);
		// Parsing the currentLine String
		
		}
		return v ;
		}
	
	/*public static void main(String[] args) throws IOException{
			readFile("Database-Spells.csv");
			}*/
}