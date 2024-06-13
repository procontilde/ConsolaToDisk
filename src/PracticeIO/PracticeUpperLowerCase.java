package PracticeIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * ################ EJERCICIO 2 ################  
 * 
 * https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-de-ficheros-en-java/
 * 
 * 	Crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que queramos a escribir en el fichero. Deberás mostrar por pantalla el mismo texto pero variando entre mayúsculas y minúsculas, es decir, si escribo «Bienvenido» deberá devolver «bIENVENIDO». Si se escribe cualquier otro carácter, se quedara tal y como se escribió.

	Deberás crear un método para escribir en el fichero el texto introducido y otro para mostrar el contenido en mayúsculas.

	IMPORTANTE: Cuando pidas por teclado una ruta con JOptionPane, no es necesario que insertes caracteres de escape.
 */

public class PracticeUpperLowerCase {

	public static void main(String[] args) {
		
		Scanner miScan = new Scanner(System.in);
		
			while(true) {
				
				System.out.println("Introduzca la ruta del archivo: ");
				String path = miScan.nextLine();
				
				if(path != null) {
					
					UpperLowerCase(path);
					return;
					
				}
				
				miScan.close();
				
			}

	}
	
	private static void UpperLowerCase(String path) {
		
		BufferedReader bR = null;
		
		try {
			
			bR = new BufferedReader(new FileReader(path));
			String line = bR.readLine();
			
			while(line != null) {
					
				char c = (char)bR.read();
				if(Character.isUpperCase(c)) Character.toLowerCase(c);
					else Character.toUpperCase(c);
				
			}
			
		}catch(IOException iE) {
			
			iE.printStackTrace();
			
		}finally {
			
			try {
				
				if(bR != null) bR.close();
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

}

































