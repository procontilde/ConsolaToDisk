package consolaToDisk;

import java.io.*;
import java.util.Scanner;

public class ChangeCharacters {

    public static void main(String[] args) {
       
        Scanner miScan = new Scanner(System.in);

        System.out.println("Introduzca la ruta del archivo:");
        String fileName = miScan.nextLine();
        System.out.println("Introduzca la letra original:");
        char originalChar = miScan.nextLine().charAt(0);
        System.out.println("Introduzca la letra cambiada:");
        char newChar = miScan.nextLine().charAt(0);

        try {
           
            changeChar(fileName, originalChar, newChar);
            System.out.println("Las letras han sido cambiadas correctamente.");
            
        } catch (FileNotFoundException e) {
          
            System.out.println("No se encontró el archivo.");
            
        } catch (IOException e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            
        		miScan.close();
        		
        }

    }

    public static void changeChar(String fileName, char originalChar, char newChar) throws IOException {
        
        BufferedReader bR = null;
        BufferedWriter bW = null;

        try {
        	
        	bR = new BufferedReader(new FileReader(fileName));
        	bW = new BufferedWriter(new FileWriter(fileName + "Copia"));

            String line;
            
            while ((line = bR.readLine()) != null) {
               
                String newLine = line.replace(originalChar, newChar);
                
                bW.write(newLine);
                bW.newLine();
                
            }
            
        } finally {
        	
            if (bR != null) bR.close();
            if (bW != null) bW.close();
            
        }

        File originalFile = new File(fileName);
        File tempFile = new File(fileName + "Copia");
        
        if (tempFile.renameTo(originalFile)) System.out.println("Archivo modificado con éxito.");
            else throw new IOException("No se pudo renombrar el archivo temporal.");
        
    }
    
}
