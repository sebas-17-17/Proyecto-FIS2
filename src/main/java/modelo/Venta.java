package modelo;

public class Venta {
    private int NroRecibo;
    private Cliente cliente;
    private String ruta; 
    private String fechaVuelo;
    private String horaVuelo;
    private String asiento;
    private double total;

    public Venta(int NroRecibo, Cliente cliente, String ruta, String fechaVuelo, String horaVuelo, String asiento, double total) {
        this.NroRecibo = NroRecibo;
        this.cliente = cliente;
        this.ruta = ruta;
        this.fechaVuelo = fechaVuelo;
        this.horaVuelo = horaVuelo;
        this.asiento = asiento;
        this.total = total;
    }

    public int getNroRecibo() {
        return NroRecibo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getRuta() {
        return ruta;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public String getHoraVuelo() {
        return horaVuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public double getTotal() {
        return total;
    }
    
    public String toCSV() {
        return NroRecibo + "," + cliente.getNombre() + "," + ruta + "," + fechaVuelo + "," + horaVuelo + "," + asiento + "," + total;
    }
}