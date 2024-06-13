package consolaToDisk;

/*
 *  ########################  ENUNCIADO  #############################
 * 
 * Escribir una clase ConsolaToDisk que pida por consola la ruta completa del fichero de salida a grabar; Si el nombre de fichero se deja en blanco, se cierra el programa mostrando un mensaje
	A continuación, que empiece a solicitar líneas de texto por teclado, y las vaya grabando en el fichero de salida, hasta que reciba una línea en blanco, momento en que se cerrará el fichero y finalizará el programa. Realizar un método main en esa misma clase o en otra para probar el funcionamiento.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolaToDisk {
	
    public static void main(String[] args) {
    	
        ConsolaToDisk cTd = new ConsolaToDisk();
        cTd.writeInFile();
        
    }

    public void writeInFile() {
    	
        try {
        	
            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduzca la ruta:");
            String path = bR.readLine();

            if (path.isEmpty()) {
            	
                System.out.println("Debes proporcionar la ruta del directorio.");
                return;
                
            }

            System.out.println("Introduzca el nombre del archivo:");
            String fileName = bR.readLine();

            if (fileName.isEmpty()) {
            	
                System.out.println("Debe proporcionar el nombre del archivo.");
                return;
                
            }

            String pathFileName = path + "/" + fileName;
            BufferedWriter bW = new BufferedWriter(new FileWriter(pathFileName));

            while (true) {
            	
                System.out.println("Introduzca una línea de texto (deje en blanco para terminar):");
                String line = bR.readLine();

                if (line.isEmpty()) {
                	
                    System.out.println("Cerrando el fichero y el programa.");
                    bW.close();
                    return;
                    
                }

                bW.write(line);
                bW.newLine();
                
            }

        } catch (IOException e) {
        	
            e.printStackTrace();
            
        }
    }
}
