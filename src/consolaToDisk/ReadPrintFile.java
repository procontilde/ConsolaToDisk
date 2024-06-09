package consolaToDisk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadPrintFile {

	public static void main(String[] args) {
		
		readFile();

	}

	public static void readFile() {

		Scanner miScan = new Scanner(System.in);
		String path = "";
		String line = "";
		BufferedReader bR = null;

		try {

			while (true) {

				System.out.println("Introduzca la ruta del archivo: ");
				path = miScan.nextLine();

				if (path.isEmpty()) {

					System.out.println("Debe introducir una ruta correcta.");
					miScan.close();
					return;

				}

				bR = new BufferedReader(new FileReader(path));

				while ((line = bR.readLine()) != null)
					System.out.println(line);

				miScan.close();
				return;

			}

		} catch (IOException iE) {

			iE.printStackTrace();

		} finally {

			try {

				if (bR != null)bR.close();

			} catch (IOException iOe) {

				iOe.printStackTrace();

			}
			
			miScan.close();

		}

	}
}