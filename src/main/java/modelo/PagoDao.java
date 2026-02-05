package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PagoDao {
    private File archivoTarjetas;
    
    public PagoDao() {
        archivoTarjetas = new File("Tarjetas.txt");
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
}
