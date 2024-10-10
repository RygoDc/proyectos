import java.io.*;
import java.util.Scanner;

public class Ejercicio2Oc10 {
    public static void main(String[] args) throws IOException {
        String fichero = "C:\\Users\\ALUMNO\\Documents\\VSCODE\\Acceso a Datos\\estructuras_basicas\\src\\prueba.txt";
        String letras = "aeiou";
        File f = new File(fichero);

        try {
            if(f.exists()) {
                Scanner lector = new Scanner(fichero);
                int contadorLetras=0;
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    for (char c : linea.toCharArray()) {
                        if (Character.isLetter(c)) {
                            contadorLetras++;
                        }
                    }
                }
                lector.close();
                System.out.println("El archivo contiene " + contadorLetras + " letras.");
            }
            else
                System.out.println(f.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
