package org.example;

/**
 *Subclase de Producto,
 *representa modelo para Bebida
 */
public abstract class Bebida extends Producto{
    private int serie;
    /**
     * Constructor de Producto
     * @param s único int
     */
    public Bebida(int s) {
        super(s);
    }

    public abstract String consumir();
    public int getSerie() {
        int s = serie;
        return serie;
    }
}