package org.example;
/**
 * Superclase "modelo" para las bebidas y los dulces
 */

public abstract class Producto {

    /**
     *se declara int que funciona como un identificador
     *del producto
     */
    private int serie;
    /**
     * Constructor de Producto
     * @param s único int
    el valor entero de s
     */
    public Producto(int s) {
        serie = s;
    }
    public abstract String consumir();
    /**
     *  getSerie no tiene parametro de entrada.
     * @return el valor entero de s
     */
    public int getSerie() {
        int s = serie;
        return serie;
    }
}