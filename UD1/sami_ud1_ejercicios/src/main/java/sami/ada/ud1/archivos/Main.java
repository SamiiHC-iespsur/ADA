package sami.ada.ud1.archivos;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        crearEstructura();

        // Ejercicio 2
        listarDatos();

        // Ejercicio 3
        File base = new File("./d");
        listarTodosDatos(base, "txt");

	// Ejercicio 4
	listarFiltrado("txt");

        // Ejercicio 5
        borrarTxts("./d");
        
        //escribir("prueba2.txt","siguo por aquí");
        // leerCarACar("prueba2.txt");
        //leerLineaALinea("./ud1/prueba.txt");

    }

    public static void crearEstructura(){

        File prueba=new File("./prueba.txt"); 
        File d = new File("./d");
        File d1 = new File(d, "d1"); 
        File d2 = new File(d, "d2"); 
        File d3 = new File(d, "d3");
        File f11 = new File(d1, "f11");
        File f12 = new File(d1, "f12");
        File d21 = new File(d2, "d21");
        File f21 = new File(d2, "f21");
        File d22 = new File(d2, "d22");
        File d31 = new File(d3, "d31");
        File f222 = new File(d22, "f222");

        try {
            if(prueba.createNewFile()){
                System.out.println("He creado " + prueba.getName());
            }
            
            if(d.mkdir()){
                System.out.println("He creado " + d.getName());
            }

            if(d1.mkdir()){
                System.out.println("He creado " + d1.getName());
            }
            
            if(d2.mkdir()){
                System.out.println("He creado " + d2.getName());
            }

            if(d3.mkdir()){
                System.out.println("He creado " + d3.getName());
            }

            if(f11.createNewFile()){
                System.out.println("He creado " + f11.getName());
            }

            if(f12.createNewFile()){
                System.out.println("He creado " + f12.getName());
            }

            if(d21.mkdir()){
                System.out.println("He creado " + d21.getName());
            }

            if(f21.createNewFile()){
                System.out.println("He creado " + f21.getName());
            }

            if(d22.mkdir()){
                System.out.println("He creado " + d22.getName());
            }

            if(d31.mkdir()){
                System.out.println("He creado " + d31.getName());
            }

            if(f222.createNewFile()){
                System.out.println("He creado " + f222.getName());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void listarDatos(){
        File raiz = new File("./d");

        File[] archivos = raiz.listFiles();

        for(File a:archivos){
            System.out.println(a.getName());

            if(a.isDirectory()){
                File[] archivos2 = a.listFiles();

                for(File b:archivos2){
                    System.out.println("\t"+b.getName());

                    if(b.isDirectory()) {
                        File[] archivos3 = b.listFiles();

                        for(File c:archivos3) System.out.println("\t\t"+c.getName());
                    }
                }
            }
        }
    }

    public static void listarTodosDatos(File raiz, String prefijo){
        if(raiz.exists() && raiz.isDirectory()) {
        	File[] archivos = raiz.listFiles();
                
		for(File f:archivos) {
			System.out.println(prefijo + f.getName());
                        
			if (f.isDirectory()) {
				listarTodosDatos(f, prefijo+"\t");
			}
		}
	}
    }
    
    public static void listarFiltrado(String ext) {
        File dir = new File("./d");
        
        File[] archivos = dir.listFiles();
        
        for(File f:archivos) {
            if(f.getName().endsWith(".".concat(ext))) {
                System.out.println(f.getName());
            }
        }
    }
    
    public static void borrarTxts(String ruta) {
        File dir = new File(ruta);
        
        File[] archivos = dir.listFiles();
        
        for(File f:archivos) {
            if(f.getName().endsWith(".txt")) {
                if(f.delete()) System.out.println("He eliminado " + f.getName());
            }
        }
    }

    public static void leerCarACar(String ruta){
        try {
            // 1
            FileReader fr=new FileReader(ruta);

            // 2. Operación

            int caracter=0;
            while (caracter!=-1){
                caracter=fr.read();
                if(caracter!=-1){
                    System.out.print((char)caracter);
                }
    
            }

            System.out.println();
            

            // 3. cerrar
            fr.close();



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void escribir(String ruta,String texto){
        try {
            // 1
            FileWriter fw=new FileWriter(ruta,false);



            // 2. Operación

            fw.write(texto);
            

            // 3. cerrar
            fw.flush();
            fw.close();



        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void leerLineaALinea(String ruta){
        try {
            // 1
            FileReader fr=new FileReader(ruta);
            BufferedReader br=new BufferedReader(fr);

            // 2. Operación

            String linea=br.readLine();
            while (linea!=null){
                System.out.println(linea);
                linea=br.readLine();
    
            }
            

            // 3. cerrar
            fr.close();



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}