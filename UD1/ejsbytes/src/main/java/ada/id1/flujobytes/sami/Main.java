package ada.id1.flujobytes.sami;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        copiarImagen();

        // Ejercicio 2
        //paresNum();

        // Ejercicio 3
        //mediaPares();
    }
    
    public static void copiarImagen() {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.home") + "/Desktop/numemon.jpeg");
        FileOutputStream fos = new FileOutputStream("./copiamon.jpeg")) {
            fos.write(fis.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void paresNum() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("./ej2"));
        DataInputStream dis = new DataInputStream(new FileInputStream("./ej2"));
        Scanner sc = new Scanner(System.in)) {
            while(true) {
                String linea = sc.nextLine();
                if (linea.isEmpty()) {
                    break;
                }

                if (linea.matches("^\\d.*\\d$") && linea.contains(" ")) {
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mediaPares() {

    }
}