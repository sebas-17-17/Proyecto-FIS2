package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Pasaje;
import modelo.ReservaDatos;
import vista.VistaVuelo;
import vista.VistaVentaPasaje;

public class ControladorVuelo {

    private VistaVuelo vista;
    private ReservaDatos reserva;
    private List<Pasaje> asientosSeleccionados = new ArrayList<>();

    public ControladorVuelo(VistaVuelo vista, ReservaDatos reserva) {
        this.vista = vista;
        this.reserva = reserva;
    }

    // Selección de asientos
    public boolean seleccionarAsiento(String fila, String columna) {
        if (reserva.getAsientosSeleccionados().size() >= reserva.getPasajeros()) {
            vista.mostrarMensaje("Ya se seleccionaron todos los asientos");
            return false;
        }

        Pasaje nuevo = new Pasaje(fila, columna);

        for (Pasaje p : reserva.getAsientosSeleccionados()) {
            if (p.getCodigo().equals(nuevo.getCodigo())) {
                vista.mostrarMensaje("Ese asiento ya está seleccionado");
                return false;
            }
        }

        reserva.getAsientosSeleccionados().add(nuevo);

        if (reserva.getAsientosSeleccionados().size() == reserva.getPasajeros()) {
            vista.habilitarBotonSiguiente(true);
        }

        return true;
    }

    // Ir a la vista de venta de pasajes
    public void irAVistaVenta() {
        VistaVentaPasaje vistaVenta = new VistaVentaPasaje();
        ControladorVenta controladorVenta = new ControladorVenta(vistaVenta, reserva);
        vistaVenta.setControlador(controladorVenta);
        vistaVenta.setVisible(true);
        vista.dispose(); // ⚡ corregido
    }

    // --- Getters de la reserva ---
    public String getIdVueloSeleccionado() {
        return reserva.getRuta().getIdVuelo();
    }

    public double getPrecioVueloSeleccionado() {
        return reserva.getRuta().getPrecio();
    }

    public int getNumeroPasajeros() {
        return reserva.getPasajeros();
    }

    public LocalDate getFechaIda() {
        return reserva.getFechaIda();
    }

    public LocalDate getFechaRegreso() {
        return reserva.getFechaRegreso();
    }

    // Inicializar la vista de vuelo
    public void iniciarVistaVuelo() {
        vista.setTitle("Selección de Asientos");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public List<Pasaje> getAsientosSeleccionados() {
    return asientosSeleccionados;
}

}