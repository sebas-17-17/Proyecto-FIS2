/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

import controlador.ControladorMenu;
import controlador.ControladorRegistro;
import modelo.Ruta;
import modelo.RutaDAO;
import java.util.ArrayList;
import vista.VistaMenu;
import controlador.ControladorVenta;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.VistaVentaPasaje;


public class ProyectoFis {
public static void main(String[] args) {

    VistaMenu vMenu = new VistaMenu();
    RutaDAO dao = new RutaDAO();
    ControladorMenu cMenu = new ControladorMenu(vMenu, dao);
    ControladorRegistro cRegistro = new ControladorRegistro(vMenu);
    cMenu.iniciar();

}
}        
    
