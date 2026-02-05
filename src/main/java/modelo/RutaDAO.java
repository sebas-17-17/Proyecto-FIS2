
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RutaDAO {
 
    private File fileOrigenes = new File("src/main/resources/origenes.txt");
    private File fileDestinos = new File("src/main/resources/destinos.txt");
    private File fileRutas = new File("src/main/resources/rutas.txt");
    
    
    //Metodo para obtener la lista de origenes
    public ArrayList<String> obtenerListaOrigenes() {
    ArrayList<String> listaOrigenes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileOrigenes))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            listaOrigenes.add(linea.trim());
        }
    } catch (IOException e) { e.printStackTrace(); }
    
      return listaOrigenes;
    }
    
    //Metodo para obtener la lista de destinos
    public ArrayList<String> obtenerListaDestinos() {
    ArrayList<String> listaOrigenes = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileDestinos))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            listaOrigenes.add(linea.trim());
        }
    } catch (IOException e) { e.printStackTrace(); }
    
      return listaOrigenes;
    }

    //Metodo para buscar la ruta (comparar origen, destino y devolver la información completa de la ruta)
    public Ruta buscarRuta(String origenSeleccionado, String destinoSeleccionado) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileRutas))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length < 4) continue; 

            // Limpiar espacios en blanco con .trim()
            String origenTxt = datos[0].trim();
            String destinoTxt = datos[1].trim();
            
            if (origenTxt.equalsIgnoreCase(origenSeleccionado) && 
                destinoTxt.equalsIgnoreCase(destinoSeleccionado)) {
                
                // Retornar el objeto con los datos del CSV
                return new Ruta(origenTxt, destinoTxt, datos[2].trim(), Double.parseDouble(datos[3].trim()));
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.err.println("Error al procesar el archivo de rutas: " + e.getMessage());
    }
    return null; 
    }
    
  
    
}



    

