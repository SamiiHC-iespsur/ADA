package sami.ada.ud1.archivos;

import java.io.*;

public class EjsFlujo {
    public static void main(String[] args) {
        // Ejercicio 1
        escribirHolaMundo("./prueba.txt");
        
        // Ejercicio 2
        escribirAlFinal("./prueba.txt", "Mi nombre es Samii");
        
        // Ejercicio 3
        leer1aLinea("./prueba.txt");
        
        // Ejercicio 4
        leerLineas("./prueba.txt");
        
        // Ejercicio 5
        contPalabras("./prueba.txt");
        
        // Ejercicio 6
        copiarMayusSinEspacios("./prueba.txt", ".d/d2/f21");
    }
    
    public static void escribirHolaMundo(String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write("Hola mundo\n");
            System.out.println("Texto escrito en " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirAlFinal(String ruta, String texto) {
        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(texto.concat("\n"));
            System.out.println("Texto añadido al final de " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void leer1aLinea(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine();
            if (linea != null) System.out.println(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void leerLineas(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void contPalabras(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.trim().split("\\s+");
                cont += palabras.length;
            }
            System.out.println("Número de palabras en " + ruta + ": " + cont);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void copiarMayusSinEspacios(String origen, String destino) {
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaProcesada = linea.replaceAll("\\s+", "").toUpperCase();
                bw.write(lineaProcesada);
                bw.newLine();
            }

            System.out.println("Contenido procesado en: " + destino);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
