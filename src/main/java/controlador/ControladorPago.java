package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Pago;
import modelo.PagoDao;
import modelo.ReservaDatos;
import modelo.RutaDAO;
import vista.VistaMenu;
import vista.VistaPago;

public class ControladorPago implements ActionListener, KeyListener {

    private VistaPago vista;
    private PagoDao pagoDAO;
    private ReservaDatos reserva;
    private VistaMenu vistaMenu;
    private ControladorMenu controladorMenu;
    private RutaDAO rutaDAO = new RutaDAO();

    public ControladorPago(VistaPago vista, ReservaDatos reserva, VistaMenu vistaMenu, ControladorMenu controladorMenu) {
        this.vista = vista;
        this.reserva = reserva;
        this.vistaMenu = vistaMenu;
        this.controladorMenu = controladorMenu;
      
      
        
    }

    public void iniciarVistaPago() {
        vista.setTitle("Gestión de Pago");
        vista.setLocationRelativeTo(null);
        vista.limpiarCampo();
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnFlecha) {
            vista.dispose();
            // aquí podrías volver a la vistaVenta si la pasas por constructor
        }

        if (e.getSource() == vista.btnValidacion) {
            String cedula = vista.getCedula();
            String tarjeta = vista.getNumTarjeta().replace(" ", "");
            String fecha = vista.getExpiracion().replace("/", "");
            String codigo = vista.getCodigo();

            if (tarjeta.length() < 16) {
                JOptionPane.showMessageDialog(null, "Número de tarjeta incompleto (16 dígitos).");
                return;
            }

            try {
                String[] partes = vista.getExpiracion().split("/");
                int mes = Integer.parseInt(partes[0]);
                int anio = Integer.parseInt("20" + partes[1]);
                java.time.YearMonth fechaActual = java.time.YearMonth.now(); 
                java.time.YearMonth fechaExpiracion = java.time.YearMonth.of(anio, mes);
                if (fechaExpiracion.isBefore(fechaActual)) {
                    JOptionPane.showMessageDialog(null, "La tarjeta ha caducado.");
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use MM/YY.");
                return;
            }

            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Cédula inválida (10 dígitos).");
                return;
            }
            if (codigo.length() < 3) {
                JOptionPane.showMessageDialog(null, "Código CVV inválido (3 dígitos).");
                return;
            }

            Pago p = new Pago(tarjeta, fecha, cedula, codigo);
            if (pagoDAO.guardarPago(p)) {
                JOptionPane.showMessageDialog(null, "Tarjeta validada correctamente");
                vista.limpiarCampo();
            }
        }

        if (e.getSource() == vista.btnCompra) {
            JOptionPane.showMessageDialog(null,
                "Compra registrada exitosamente.\nSu recibo electrónico está en Vuelos Comprados.\nGracias por viajar con nosotros.");
            vista.limpiarCampo();
        }
        
        if (e.getSource() == vista.btnRegresar) {
            System.out.println(vistaMenu); 
    vistaMenu.setVisible(true);   // muestra la ventana original
    // Recargar combos si quieres
    ArrayList<String> ciudadesOrigen = rutaDAO.obtenerListaOrigenes();
    ArrayList<String> ciudadesDestino = rutaDAO.obtenerListaDestinos();
    vistaMenu.cargarCiudadesEnCombo(ciudadesOrigen);
    vistaMenu.cargarCiudadesEnCombo2(ciudadesDestino);

    vista.dispose(); // cierra la vistaPago
}
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
