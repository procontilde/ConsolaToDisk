package PracticeIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PracticeReadFile {

	public static void main(String[] args) {
		
		Scanner miScan = new Scanner(System.in);
	
		System.out.println("Path: ");
		String path = miScan.nextLine();
		
		read(path);
		
		miScan.close();

	}
	
	private static void read(String path) {
		
		BufferedReader bR = null;
		
		try {
			
			bR = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = bR.readLine()) != null) System.out.println(line);
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally{
			
			try {
				
				if(bR != null) bR.close();
				
			}catch(IOException iE) {
				
				iE.printStackTrace();
				
			}
			
		}
		
	}

}
