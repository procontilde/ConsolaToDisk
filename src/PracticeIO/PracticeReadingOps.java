package PracticeIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PracticeReadingOps {

    private static BufferedReader bR = null;
    private static BufferedWriter bW = null;
    private static String line, path;
    private static char c1, c2;
    private static Scanner miScan = new Scanner(System.in);

    public static void main(String[] args) {

        String choice;
        int iChoice = -1;

        System.out.println("Elija entre las siguientes opciones:\n\na. Leer de fichero\nb. Cambiar caracteres\nc. Mayúsculas a minúsculas o viceversa");
        choice = miScan.nextLine().toLowerCase();

        if (choice.equals("a")) {

            iChoice = 1;

        } else if (choice.equals("b")) {

            iChoice = 2;

        } else if (choice.equals("c")) {

            iChoice = 3;

        }

        switch (iChoice) {

            case 1:

                System.out.println("Introduzca la ruta: ");
                path = miScan.nextLine();

                reading(path);
                break;

            case 2:

                System.out.println("Introduzca la ruta: ");
                path = miScan.nextLine();
                System.out.println("Introduzca la letra original: ");
                c1 = miScan.nextLine().charAt(0);
                System.out.println("Introduzca la nueva letra: ");
                c2 = miScan.nextLine().charAt(0);

                    changeSpecificChar(path, c1, c2);

                break;

            case 3:

                System.out.println("Introduzca la ruta: ");
                path = miScan.nextLine();

                upperToLowerToUpper(path);

                break;

        }

        miScan.close();

    }

    private static String reading(String path) {

        try {

        	bR = new BufferedReader(new FileReader(path));

            while ((line = bR.readLine()) != null) System.out.println(line);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bR != null) bR.close();

            } catch (IOException iE) {

                iE.printStackTrace();

            }

        }

        return "";

    }

    private static void changeSpecificChar(String path, char oldChar, char newChar) {

        try {

        	bR = new BufferedReader(new FileReader(path));
        	bW = new BufferedWriter(new FileWriter(path + "Copia"));

            while ((line = bR.readLine()) != null) {

                String newLine = line.replace(oldChar, newChar);
                
                bW.write(newLine);
                bW.newLine();
                
                System.out.println(newLine);

            }

        } catch (IOException iOe) {

            iOe.printStackTrace();

        } finally {

            try {

                if (bR != null) 	bR.close();
                if (bW != null) bW.close();

            } catch (IOException iOe) {

                iOe.printStackTrace();

            }

        }

    }

    private static void upperToLowerToUpper(String path) {

        try {

        	bR = new BufferedReader(new FileReader(path));
        	bW = new BufferedWriter(new FileWriter(path + "Copia"));

            while ((line = bR.readLine()) != null) {

                StringBuilder newLine = new StringBuilder();

                for (char c : line.toCharArray()) {

                    if (Character.isUpperCase(c)) {

                        newLine.append(Character.toLowerCase(c));

                    } else if (Character.isLowerCase(c)) {

                        newLine.append(Character.toUpperCase(c));

                    } else {

                        newLine.append(c);

                    }

                }

                System.out.println(newLine);
                
                bW.write(newLine.toString());
                bW.newLine();

            }

        } catch (IOException eIo) {

            eIo.printStackTrace();

        } finally {

            try {

                if (bR != null) bR.close();
                if (bW != null) bW.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}
