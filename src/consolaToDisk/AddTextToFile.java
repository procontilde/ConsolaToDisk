package consolaToDisk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTextToFile {

	public static void main(String[] args) {
		
		AddTextToFile.appendText("/Users/manuelpalomo/Downloads/programacion23_24/teoriaProgramacion/ficheros/miFichero.txt");

	}
	
	private static void appendText(String path) {
		
		BufferedReader bR =null;
		BufferedWriter bW = null;
		
		try {
		
			bR = new BufferedReader(new FileReader(path));
			bW = new BufferedWriter(new FileWriter(path, true));
			String linea;
			
			while(true) {
				
				System.out.println("Introduzca la línea (deje en blanco para terminar:) ");
				linea = new BufferedReader(new InputStreamReader(System.in)).readLine();
				
				if(linea.isEmpty()) {
					
					System.out.println("La escritura en archivo ha terminado.");
					return;
					
				}
				
				bW.write(linea);
				bW.newLine();
			
			}
			
		}catch(IOException iE) {
			
			iE.printStackTrace();
			
		}finally {
			
			try {
			
				if(bR != null) bR.close();
				if(bW != null) bW.close();
			
			}catch(IOException iO) {
				
				iO.printStackTrace();
				
			}
			
		}
		
	}

}
