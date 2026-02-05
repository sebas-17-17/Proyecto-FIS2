package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ReservaDatos;
import vista.VistaMenu;
import vista.VistaPago;
import vista.VistaVentaPasaje;
import vista.VistaVuelo;

public class ControladorVenta implements ActionListener {
    private VistaVentaPasaje vista;
    private ReservaDatos reserva;
    private VistaMenu vistaMenu;
    private ControladorMenu controladorMenu;

    public ControladorVenta(VistaVentaPasaje vista, ReservaDatos reserva, VistaMenu vistaMenu, ControladorMenu controladorMenu) {
    this.vista = vista;
    this.reserva = reserva;
    this.vistaMenu = vistaMenu;
    this.controladorMenu = controladorMenu;

    // ⚡ Esto es clave:
    this.vista.btnSiguiente.addActionListener(this);
    this.vista.btnRegresar.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnSiguiente) {
            procesarSiguiente();
        } else if (e.getSource() == vista.btnRegresar) {
            regresarAVuelo();
        }
    }

    private void procesarSiguiente() {
        if (hayCamposVacios()) {
            JOptionPane.showMessageDialog(vista, "Complete todos los campos.");
            return;
        }

        // Guardar datos del cliente en la reserva
        Cliente cliente = new Cliente();
        cliente.setNombre(vista.txtNombre.getText());
        cliente.setApellido(vista.txtApellido.getText());
        cliente.setNumDoc(vista.txtNumdoc.getText());
        cliente.setFechaNac(vista.txtNacimiento.getText());
        cliente.setNacionalidad(vista.txtNacionalidad.getText());
        cliente.setEmail(vista.txtEmail.getText());
        cliente.setTelefono(vista.txtTelefono.getText());
        cliente.setTipoDoc(vista.cbTipodoc.getSelectedItem().toString());
        cliente.setGenero(vista.cbGenero.getSelectedItem().toString());

        reserva.setCliente(cliente);

        // Abrir vista de pago
        VistaPago vistaPago = new VistaPago(vistaMenu, reserva);
ControladorPago controladorPago = new ControladorPago(vistaPago, reserva, vistaMenu, controladorMenu);
vistaPago.setControlador(controladorPago);
vistaPago.setVisible(true);

 vista.dispose();
    }

    private void regresarAVuelo() {
    reserva.getAsientosSeleccionados().clear();
    
    VistaVuelo vVuelo = new VistaVuelo();
    ControladorVuelo cVuelo = new ControladorVuelo(
        vVuelo, 
        reserva, 
        this.vistaMenu,        // referencia original del menú
        this.controladorMenu   // referencia original del controlador del menú
    );
    vVuelo.setControlador(cVuelo);
    vVuelo.setVisible(true);
    vVuelo.setLocationRelativeTo(null);
    vista.dispose();
    }

    private boolean hayCamposVacios() {
        return vista.txtNombre.getText().isEmpty() || vista.txtNombre.getText().equals("Nombre") ||
               vista.txtApellido.getText().isEmpty() || vista.txtApellido.getText().equals("Apellido") ||
               vista.txtNumdoc.getText().isEmpty() || vista.txtNumdoc.getText().equals("Numerodoc") ||
               vista.txtEmail.getText().isEmpty() || vista.txtEmail.getText().equals("Email") ||
               vista.txtTelefono.getText().isEmpty() || vista.txtTelefono.getText().equals("Telefono") ||
               vista.txtNacionalidad.getText().isEmpty() || vista.txtNacionalidad.getText().equals("Nacionalidad");
    }
}