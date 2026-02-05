package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PagoDao {
    private File archivoTarjetas;
    private File archivoPagos;
    
    public PagoDao() {
        archivoTarjetas = new File("Tarjetas.txt");
        archivoPagos = new File("pago.txt");
    }
    // Guarda los datos de la tarjeta ingresada, en el archivo Tarjetas.txt
    public boolean guardarPago(Pago p) {
        try (FileWriter fw = new FileWriter (archivoTarjetas, true); 
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(p.toString());
            bw.newLine();
            return true;
        } catch (IOException event) {
            event.printStackTrace();
            return false;
        }
    }
    /*
    // TODO: Actualizar este metodo cuando tengamos los setters y getters
    // Guarda el resumen del pago
    public boolean guardarPagoResumen(String cedula, String metodo, double total) {
        try (FileWriter fw = new FileWriter(archivoPagos, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(cedula + "," + metodo + "," + total);
            bw.newLine();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    */
    
}
