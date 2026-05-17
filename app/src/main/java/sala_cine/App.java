package sala_cine;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
public class App {

    // Variables globales
    public static String [][] SALA = new String[6][9];

public static void main(String[] args) {

    // Leer el archivo con las sillas disponibles
    try {                                                                            
        // Variables
        int cantidaDeSillas = 0, fila = 0, columna = 0, continuar = 0;
        String nombre = "";

        Scanner sc = new Scanner(System.in);

        // menú bienvenida
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

                inicializarSala();

                String muestraDeSala = mostarSala(SALA,fila,columna);
                System.out.println(muestraDeSala);
                do{
                    do {System.out.println("Ingrese el numero de la fila de su asiento");
                        fila = sc.nextInt(); sc.nextLine();
                    } while (fila < 1 || fila > 6);
                    do {System.out.println("Ingrese el numero de la columna de su asiento");
                        columna = sc.nextInt();sc.nextLine();
                    } while (columna < 1 || columna > 9);
                    do{System.out.println("¿Desea reservar otra silla?\n1. Si\n2. No");   
                        continuar = sc.nextInt(); sc.nextLine();              
                    } while (continuar < 1 || continuar > 2);
                }while(continuar == 1);

                } else {
                    String salida = mostrarMenu(false);
                    System.out.println(salida);;
                };
                
            } else{
                String salida = mostrarMenu(false);
                System.out.println(salida);;
            }
    
    reservarSilla(fila, columna);
    System.out.println("\n" + mostarSala(SALA, fila, columna));
    
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

    // Funcion para guarfar la silla
    public static void reservarSilla (int x, int y){

        SALA[x - 1][y - 1] = "X";
    }

    // Función para mostar la sala
    public static String mostarSala(String[][] sala, int x, int y) {

        String salaMod ="                  PANTALLA\n"+
                        "=================================================\n"+
                        "     1   2   3     4   5   6     7   8   9\n";

        for (int i = 0; i < sala.length; i++) {

            salaMod += (i+1) + "   ";

            for (int j = 0; j < sala[0].length; j++) {

                if (SALA[i][j].equals("X")){
                    salaMod += "[X] ";
                } else {
                    salaMod += "[" + SALA[i][j] + "] ";
                }

                if (((j+1) % 3)== 0){
                    salaMod += "  ";
                }
                    
            }
            
            salaMod += "\n";
        }

        salaMod +="=================================================\n\n" + 
                  "[ ] = Asiento disponible\n[X] = Asiento ocupado\n";  
        return salaMod;
    }

    // Funcion para darle valores a la sala
    public static void inicializarSala() {

        for (int i = 0; i < SALA.length; i++) {
            for (int j = 0; j < SALA[0].length; j++) {
                SALA[i][j] = " ";
            }
        }
    }

}