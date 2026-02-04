package modelo;

public class Pago {
    // Declaramiento de Variables
    // Coloco los comentarios para acordarme lo que hago incluso si es muy basico XD
    private String numTarjeta;
    private String fechaExpiracion;
    private String cedula;
    private String codigo;
    // Creo el constructor
    public Pago(String numTarjeta, String fechaExpiracion, String cedula, String codigo) {
        this.numTarjeta = numTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cedula = cedula;
        this.codigo = codigo;
    }
    public Pago() {}
    // Solo para obtener la cedula en caso de necesitarlo en la factura
    public String getCedula() {
        return cedula;
    }
    // Para guardar en un archivo, ya en aplicando esto no seria lo ideal, se aplicaria con otro metodo, creo porque son datos sensibles
    @Override
    public String toString() {
        return numTarjeta+","+fechaExpiracion+","+cedula+","+codigo;
    }
}
