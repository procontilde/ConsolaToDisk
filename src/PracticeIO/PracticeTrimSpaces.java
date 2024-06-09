package PracticeIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *                ################ EJERCICIO 1 ################  
 * 
 * https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-de-ficheros-en-java/
 * 
 * Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora crea una aplicación que lea este fichero de texto carácter a carácter y muestre su contenido por pantalla  sin espacios. Por ejemplo, si un fichero tiene el siguiente texto «Esto es una prueba», deberá mostrar «Estoesunaprueba».

Captura las excepciones que veas necesario.
 * 
 */

public class PracticeTrimSpaces {

	public static void main(String[] args) {
		
		Scanner miScan = new Scanner(System.in);
		
		try {
			
			System.out.println("Introduzca la ruta del archivo: ");
			String path = miScan.nextLine();
			System.out.println("Introduzca el caracter a cambiar: ");
			String letra = miScan.nextLine();
			
			PracticeTrimSpaces.trimSpaces(path, letra);
			
		}catch(InputMismatchException iM) {
			
			iM.printStackTrace();
			
		}finally {
			
			miScan.close();
			
		}

	}
	
	private static void trimSpaces(String path, String letter) {
		
		BufferedReader bR = null;
		
		try {
			
			bR = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = bR.readLine()) != null) {
				
				line = line.replaceAll(letter, "");
				System.out.println(line);
				
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
	
	/*
	 * ############### SOLUCIÓN DE LA PÁGINA (USA read() Y ASCII) ###############  
	 * 
	 * import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1App {
 
    public static void main(String[] args) {
 
        // Definición de la ruta del archivo
        final String nomFichero = "D:\\pruebas.txt";
        
        try (FileReader fr = new FileReader(nomFichero)) {
            // Inicio del bloque try-with-resources para garantizar el cierre automático del recurso FileReader
            
            int valor = fr.read(); // Lectura del primer carácter del archivo
            
            while (valor != -1) {
                // Inicio del bucle while para leer el archivo caracter a caracter
                
                // Si el carácter leído no es un espacio en blanco (código ASCII 32)
                if (valor != 32) {
                    // Imprimir el carácter en la consola
                    System.out.print((char) valor);
                }
                
                valor = fr.read(); // Leer el siguiente carácter del archivo
            }
        } catch (IOException e) {
            // Captura y manejo de excepciones de E/S
            System.out.println("Problemas con el E/S " + e);
        }
    }
}

	 * 
	 */

}
