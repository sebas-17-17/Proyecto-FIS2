package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private String Archivo = "ventas.txt";

    public void guardarVenta(Venta venta) {
        try (BufferedWriter b = new BufferedWriter(new FileWriter(Archivo, true))) {
            b.write(venta.toCSV());
            b.newLine();
        } catch (IOException e) {
            System.err.println("¡Ocurrió un error al guardar la venta!: " + e.getMessage());
        }
    }
    
    public List<Venta> listar() {
        List<Venta> lista = new ArrayList<>();
        File f = new File(Archivo);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dat = linea.split(",");
                if (dat.length == 7) {
                    String Nombre = dat[1]; 
                    Cliente c = new Cliente();
                    c.setNombre(Nombre);
                    lista.add(new Venta(Integer.parseInt(dat[0]), c, dat[2], dat[3], dat[4], dat[5], Double.parseDouble(dat[6])));
                }
            }
        } catch (IOException e) {
            System.err.println("¡Ocurrió un error al leer las ventas!: " + e.getMessage());
        }
        return lista;
    }
}
