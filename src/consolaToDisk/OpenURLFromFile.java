package consolaToDisk;import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class OpenURLFromFile {

    public static void main(String[] args) {
    	
        Scanner miScan = new Scanner(System.in);
        BufferedReader bR = null;
        System.out.println("Introduzca la ruta del archivo:");
        String fileName = miScan.nextLine();

        try {
        	
        	bR = new BufferedReader(new FileReader(fileName));

            String line;
            
            while ((line = bR.readLine()) != null) {
            	
                if (isURL(line)) { 
                	
                    System.out.println("La línea contiene una URL: " + line);
                    System.out.println("¿Quieres abrir esta URL? \na. Sí\nb. No)");
                    String sOption = miScan.nextLine().toLowerCase();
                    
                    if (sOption.equals("a")) openURL(line);
                    
                }
                
            }
            
        } catch (IOException iOe) {
        	
            iOe.printStackTrace();
            
        } finally {
        	
            if (bR != null) {
            	
                try {
                	
                		bR.close();
                    
                } catch (IOException iOe) {
                	
                    iOe.printStackTrace();
                    
                }
                
            }
            
            miScan.close(); 
            
        }
        
    }

    private static boolean isURL(String string) {
    	
        try {
        	
            new URI(string).toURL();
            return true; 
            
        } catch (URISyntaxException uRiE) {
        	
            return false; 
            
        } catch (IllegalArgumentException iAe) {
        	
            return false; 
            
        } catch (NullPointerException nPe) {
        	
            return false; 
            
        } catch (IOException iOe) {
        	
            return false; 
            
        }
        
    }
    
    private static void openURL(String url) {
    	
        try {
        	
            java.awt.Desktop.getDesktop().browse(new URI(url)); 
            
        } catch (IOException iOe) {
        	
        		iOe.printStackTrace(); 
            
        } catch (URISyntaxException uRiE) {
        	
        		uRiE.printStackTrace(); 
            
        }
        
    }
    
}
