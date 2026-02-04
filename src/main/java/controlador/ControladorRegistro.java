package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;
import modelo.VentaDAO;
import vista.VistaMenu;

public class ControladorRegistro implements ActionListener {
    private VistaMenu vista;
    private VentaDAO modeloDAO;
    private DefaultTableModel modeloTabla;

    public ControladorRegistro(VistaMenu vista) {
        this.vista = vista;
        this.modeloDAO = new VentaDAO();
        this.modeloTabla = (DefaultTableModel) this.vista.tblHistorial.getModel();
        this.vista.btnRecibo.addActionListener(this);
        cargarDatos();
    }

    public void iniciar() {
        cargarDatos();
    }

    private void cargarDatos() {
        List<Venta> ventas = modeloDAO.listar();
        modeloTabla.setRowCount(0);
        for (Venta v : ventas) {
            modeloTabla.addRow(new Object[]{
                v.getNroRecibo(), 
                v.getCliente().getNombre(), 
                v.getRuta(), 
                v.getFechaVuelo(),
                v.getHoraVuelo(),
                v.getAsiento(),
                v.getTotal()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRecibo) {
            mostrarRecibo();
        }
    }

    private void mostrarRecibo() {
        int fila = vista.tblHistorial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione una venta primero, porfavor.");
            return;
        }

        String recibo = vista.tblHistorial.getValueAt(fila, 0).toString();
        String cliente = vista.tblHistorial.getValueAt(fila, 1).toString();
        String ruta = vista.tblHistorial.getValueAt(fila, 2).toString();
        String fecha = vista.tblHistorial.getValueAt(fila, 3).toString();
        String hora = vista.tblHistorial.getValueAt(fila, 4).toString();
        String asiento = vista.tblHistorial.getValueAt(fila, 5).toString();
        String total = vista.tblHistorial.getValueAt(fila, 6).toString();
        
        String mensaje = """
            ------------------------------------------------
                         RECIBO ELECTRÓNICO
            ------------------------------------------------
            Empresa: Aerolíneas FIS
            RUC: 1799999999001
            Recibo N°: %s
            
            DETALLE DE LA COMPRA
            ------------------------------------------------
            Pasajero: %s
            Ruta: %s
            Fecha de vuelo: %s
            Hora: %s
            Asiento: %s
            
            PAGO
            ------------------------------------------------
            Total pagado: %s
            Estado: PAGADO ✔
            ------------------------------------------------
            Gracias por volar con nosotros.
            """.formatted(recibo, cliente, ruta, fecha, hora, asiento, total);

        JOptionPane.showMessageDialog(vista, mensaje, "Recibo N° " + recibo, JOptionPane.INFORMATION_MESSAGE);
    }
}