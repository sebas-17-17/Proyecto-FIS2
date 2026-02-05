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
                if (linea.trim().isEmpty()) continue;
                String[] dat = linea.split(",");
                if (dat.length >= 7) {
                    try{
                        int id = Integer.parseInt(dat[0].trim());
                        String Nombre = dat[1].trim(); 
                        Cliente c = new Cliente();
                        c.setNombre(Nombre);
                        String ruta = dat[2].trim();
                        String fecha = dat[3].trim();
                        String hora = dat[4].trim();
                        String asiento = dat[5].trim();
                        double total = Double.parseDouble(dat[6].trim());
                    lista.add(new Venta(id, c, ruta, fecha, hora, asiento, total));
                }catch (NumberFormatException e) {
                        System.out.println(" Error de número: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Línea ignorada, no cumple el formato de comas");
                }
            }
        } catch (IOException e) {
            System.err.println("¡Ocurrió un error al leer el archivo!: " + e.getMessage());
        }
        return lista;
       }
}
