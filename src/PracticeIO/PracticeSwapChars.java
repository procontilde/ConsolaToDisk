package PracticeIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PracticeSwapChars {

	public static void main(String[] args) {
		
		Scanner miScan = new Scanner(System.in);
		
		System.out.println("Path: ");
		String path = miScan.nextLine();
		System.out.println("Char 1: ");
		char c1 = miScan.nextLine().charAt(0);
		System.out.println("Char 2: ");
		char c2 = miScan.nextLine().charAt(0);
		
		try {
			
			swap(path, c1, c2);
			
		}catch(IOException eOi) {
			
			eOi.printStackTrace();
			
		}finally {
			
			miScan.close();
			
		}

	}
	
	private static void swap(String path, char c1, char c2) throws IOException {
		
		BufferedReader bR = null;
		BufferedWriter bW = null;
		
		try {
			
			bR = new BufferedReader(new FileReader(path));
			bW = new BufferedWriter(new FileWriter(path + "Copia"));
			String line;
			
			while((line = bR.readLine()) != null) {
				
				if(bR.read() != -1) {
					
					String newLine = line.replace(c1, c2);
					bW.write(newLine);
					bW.newLine();
					
				}

			}
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(bR != null) bR.close();
				if(bW != null) bW.close();
				
			}catch(IOException oE) {
				
				oE.printStackTrace();
				
			}
			
		}
		
		File file = new File(path);
		File tempFile = new File(path + "Copia");
		
		if(tempFile.renameTo(file)) System.out.println("Bien");
		else throw new IOException("Mal");
		
	}

}
