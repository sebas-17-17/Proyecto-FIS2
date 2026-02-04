/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Master
 */
public class Pasaje {
     private String fila;
    private String columna;

    public Pasaje (String fila, String columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public String getCodigo() {
        return fila + columna;
    }
}
