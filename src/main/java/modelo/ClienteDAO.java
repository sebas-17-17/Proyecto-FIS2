
package modelo;

public class ClienteDAO {
    
    public boolean guardar(Cliente cliente) {
        
        System.out.println("Cliente guardado: " + cliente.getNombre() + " " + cliente.getApellido());
        return true; 
    }
}