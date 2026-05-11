package sala_cine;
import java.io.*;
import javax.swing.*;
public class App {

    // Variables globales
    public static File ARCHIVOLECTURA = new File("puestosDisponibles.txt");

    public static void main(String[] args) {

        // Variables
        int cantidaDeSillas = 0, fila = 0, columna = 0, continuar = 0;
        String nombre = "";

        JOptionPane.showMessageDialog(null, "¡Bienvenido a Cinemax!");
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ver el menú de opciones?");
            if (opcion == 0) {
                String menu = mostrarMenu(true);
                JOptionPane.showInputDialog(null, menu);
            } else{
                String salida = mostrarMenu(false);
                JOptionPane.showMessageDialog(null, salida);
            }
        /*if(opcion == 1 || opcion == 2){
            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
        } else if (opcion == 0){
            do{
                nombre = JOptionPane.showInputDialog("Ingrese su nombre completo, por favor.");
                do {fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la fila de su asiento"));
                } while (fila < 1 || fila > 6);
                do {columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la columna de su asiento"));
                } while (columna < 1 || columna > 9);
                continuar = JOptionPane.showConfirmDialog(null, "¿Desea reservar otra silla?");
            }while(continuar == 0);
        }
            */
        
        // Leer el archivo con las sillas disponibles
        try (FileReader fr = new FileReader(ARCHIVOLECTURA);
             BufferedReader br = new BufferedReader(fr)
    ) {
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error de lectura de archivos " + e);
        } catch (Exception e){
            System.out.println("Error " + e);
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
                        "1. Reservar un asiento \n2. Salir";

        String salidaMenu = "¡Hasta luego!"; 
        
        if(a == true){
            return menu;
        } else {
            return salidaMenu;
        }
    } 
}