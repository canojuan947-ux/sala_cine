package sala_cine;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
public class App {

    // Variables globales
    public static File ARCHIVOLECTURA = new File("puestosDisponibles.txt");

    public static void main(String[] args) {

// Leer el archivo con las sillas disponibles
try (FileReader fr = new FileReader(ARCHIVOLECTURA);
    BufferedReader br = new BufferedReader(fr)
) {                                                                                             
        // Variables
        int cantidaDeSillas = 0, fila = 0, columna = 0, continuar = 0;
        String nombre = "";

        Scanner sc = new Scanner(System.in);

        // mostrar menu
        System.out.println("\n======================\n" + 
                           "¡Bienvenido a Cinemax!\n" +
                           "======================\n");
        System.out.print("¿Desea ver el menú de opciones? \n1. Si \n2. No \n\n-> ");
        int opcion = sc.nextInt();
        sc.nextLine();

            if (opcion == 1) {
                String menu = mostrarMenu(true);

                System.out.print(menu);
                int opcionMenu = sc.nextInt();
                sc.nextLine();
                
                if (opcionMenu == 1) {

                    System.out.print("\nIngrese su nombre completo, por favor.\n-> ");
                    nombre = sc.nextLine();
                    do{

                        String linea;

                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }

                    do {fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la fila de su asiento"));
                    } while (fila < 1 || fila > 6);
                    do {columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la columna de su asiento"));
                    } while (columna < 1 || columna > 9);
                    continuar = JOptionPane.showConfirmDialog(null, "¿Desea reservar otra silla?");
                    }while(continuar == 0);

                } else {
                    String salida = mostrarMenu(false);
                    System.out.println(salida);;
                };
                
            } else{
                String salida = mostrarMenu(false);
                System.out.println(salida);;
            }

} catch (IOException e) {
    System.out.println("Error de lectura de archivos " + e);
} catch (Exception e){
    System.out.println("Error: " + e.getMessage());
}
        
        
    }

    // Funcion para mostrar el menú
    public static String mostrarMenu (boolean a){

        String menu = "                                                 \n" + //
                        "          ▀                                      \n" + //
                        "  ▄▄▄   ▄▄▄    ▄ ▄▄    ▄▄▄   ▄▄▄▄▄   ▄▄▄   ▄   ▄ \n" + //
                        " █▀  ▀    █    █▀  █  █▀  █  █ █ █  ▀   █   █▄█  \n" + //
                        " █        █    █   █  █▀▀▀▀  █ █ █  ▄▀▀▀█   ▄█▄  \n" + //
                        " ▀█▄▄▀  ▄▄█▄▄  █   █  ▀█▄▄▀  █ █ █  ▀▄▄▀█  ▄▀ ▀▄ \n" + //
                        "                                                 \n" + //
                        "                                                 \n" +
                        "1. Reservar un asiento \n2. Salir\n\n-> ";

        String salidaMenu = "¡Hasta luego!"; 
        
        if(a == true){
            return menu;
        } else {
            return salidaMenu;
        }
    } 
}