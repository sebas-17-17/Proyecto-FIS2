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
    venta.setNroRecibo(obtenerSiguienteRecibo());

    try (BufferedWriter b = new BufferedWriter(new FileWriter(Archivo, true))) {
        b.write(venta.toCSV());
        b.newLine();
    } catch (IOException e) {
        System.err.println("Error al guardar la venta: " + e.getMessage());
    }
}
    
    private int obtenerSiguienteRecibo() {
    int ultimo = 0;
    File f = new File(Archivo);
    if (!f.exists()) return 1;

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] dat = linea.split(",");
            ultimo = Integer.parseInt(dat[0].trim());
        }
    } catch (Exception e) {
        System.out.println("Error leyendo recibo: " + e.getMessage());
    }
    return ultimo + 1;
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
                    Venta v = new Venta(c, ruta, fecha, hora, asiento, total);
                    v.setNroRecibo(id);
                    lista.add(v);
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
