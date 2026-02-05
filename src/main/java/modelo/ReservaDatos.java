package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDatos {
    private Ruta ruta;
    private int pasajeros;
    private LocalDate fechaIda;
    private LocalDate fechaRegreso;
    
    private List<Pasaje> asientosSeleccionados = new ArrayList<>();
    
    private Cliente cliente;
    private String metodoPago;

    // Getters y setters
    public Ruta getRuta() { return ruta; }
    public void setRuta(Ruta ruta) { this.ruta = ruta; }

    public int getPasajeros() { return pasajeros; }
    public void setPasajeros(int pasajeros) { this.pasajeros = pasajeros; }

    public LocalDate getFechaIda() { return fechaIda; }
    public void setFechaIda(LocalDate fechaIda) { this.fechaIda = fechaIda; }

    public LocalDate getFechaRegreso() { return fechaRegreso; }
    public void setFechaRegreso(LocalDate fechaRegreso) { this.fechaRegreso = fechaRegreso; }

    public List<Pasaje> getAsientosSeleccionados() { return asientosSeleccionados; }
    public void setAsientosSeleccionados(List<Pasaje> asientosSeleccionados) { this.asientosSeleccionados = asientosSeleccionados; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    
    private double totalP;

    public double getTotal() { return totalP; }
    public void setTotal(double total) { this.totalP = total; }
    

}