package sala_cine;
import java.io.*;
public class App {

    // Variables globales
    public static File ARCHIVOLECTURA = new File("puestosDisponibles.txt");

    public static void main(String[] args) {

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
}