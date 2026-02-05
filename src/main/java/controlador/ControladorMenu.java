package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.RutaDAO;
import vista.VistaMenu;
import modelo.Ruta;
import vista.VistaVuelo;
import controlador.ControladorRegistro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import modelo.ReservaDatos;

public class ControladorMenu implements ActionListener, MouseListener {
    
    private VistaMenu VistaMenu;
    private RutaDAO rutaDAO;
    
    //Constructor del controlador
    public ControladorMenu(VistaMenu vista, RutaDAO dao) {
        this.VistaMenu = vista;
        this.rutaDAO = dao;

        // rutaDao recive las listas de origen y destino
        ArrayList<String> ciudadesOrigen = this.rutaDAO.obtenerListaOrigenes();
        ArrayList<String> ciudadesDestino = this.rutaDAO.obtenerListaDestinos();

        // se llama a vistaMenu y a su metodo para iyectar listas en los comboBox
        this.VistaMenu.cargarCiudadesEnCombo(ciudadesOrigen);
        this.VistaMenu.cargarCiudadesEnCombo2(ciudadesDestino);
        
        this.VistaMenu.addBtnBuscarListener(this);
        
        inicializarSugerencias();
        new ControladorRegistro(vista); 
    }
    

   //Metodo para abrir vista vuelo cuando se ayan hecho todas las validaciones 
   private void manejarBusqueda() {
    String origen = VistaMenu.getOrigen();
    String destino = VistaMenu.getDestino();
    int pasajeros = VistaMenu.getNumPasajeros();
    LocalDate fechaIda = VistaMenu.getFechaIda();
    LocalDate fechaRegreso = VistaMenu.getFechaRegreso();

    if (!esSeleccionValida(origen, destino)) return;

    Ruta rutaEncontrada = rutaDAO.buscarRuta(origen, destino);
    if (rutaEncontrada == null) {
        mostrarErrorNR("No hay ruta directa.");
        return;
    }

    ReservaDatos reserva = new ReservaDatos();
    reserva.setRuta(rutaEncontrada);
    reserva.setPasajeros(pasajeros);
    reserva.setFechaIda(fechaIda);
    reserva.setFechaRegreso(fechaRegreso);

    abrirVistaVuelo(reserva);
}
   
   //Metodo para validar que el origen y destino no sean iguales
   private boolean esSeleccionValida(String origen, String destino) {
    if (origen.equalsIgnoreCase(destino)) {
        mostrarAdvertenciaOD("El origen y el destino no pueden ser iguales.");
        return false;
    }
    return true;
   }
   
   //Metodo que muestra las adevertencias cuando se selecciona mismo origen y destino 
   private void mostrarAdvertenciaOD(String mensaje) {
    JOptionPane.showMessageDialog(
        VistaMenu,
        mensaje,
        "Advertencia",
        JOptionPane.WARNING_MESSAGE
    );
   }
   
   //Metodo que muestra error cuando la ruta no existe
   private void mostrarErrorNR(String mensaje) {
    JOptionPane.showMessageDialog(
        VistaMenu,
        mensaje,
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
   }
   
   private void abrirVistaVuelo(ReservaDatos reserva) {
    VistaVuelo vistaVuelo = new VistaVuelo();
    ControladorVuelo controlador = new ControladorVuelo(
        vistaVuelo,
        reserva,
        this.VistaMenu,    // referencia de la VistaMenu actual
        this           // referencia del ControladorMenu actual
    );
    vistaVuelo.setControlador(controlador);
    controlador.iniciarVistaVuelo();
    VistaMenu.setVisible(false); // ⚡ oculta la vistaMenu, no VistaMenu.dispose()
}
   
   //Metodo iniciador del menu, se usará en el app(Principal -> ProyectoFIS)
    public void iniciar() {
        VistaMenu.setTitle("Menú Principal");
        VistaMenu.setLocationRelativeTo(null);
        VistaMenu.setVisible(true);
    }
    
    //Metodo para que al hacer click en las tarjetas se llenen los cmapos de origen y destino
    public void inicializarSugerencias() {
    this.VistaMenu.addDestinoCardListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Object fuente = e.getSource();

            VistaMenu.setOrigen("Quito-Ecuador");

            if (fuente == VistaMenu.getLblGuayaquil()) {
                VistaMenu.setDestino("Guayaquil-Ecuador");
            } 
            else if (fuente == VistaMenu.getLblCuenca()) {
                VistaMenu.setDestino("Cuenca-Ecuador");
            } 
            else if (fuente == VistaMenu.getLblRio()) {
                VistaMenu.setDestino("RioJaneiro-Brasil");
            } 
            else if (fuente == VistaMenu.getLblLondres()) {
                VistaMenu.setDestino("Londres-Inglaterra");
            }
        }
    });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaMenu.getBtnBuscar()) {
            manejarBusqueda();
        }
 
    }

    //Al implemnetar mouse clicked hay que implemntar todos sus metodos
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    
}
