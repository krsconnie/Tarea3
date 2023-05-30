package org.example;
/**
 * Subclase de Producto,
 * representa modelo para Dulce
 */
public abstract class Dulce extends Producto{
    private int serie;
    public Dulce(int s) {
        super(s);
    }
    public abstract String consumir();
    public int getSerie() {
        int s = serie;
        return serie;
    }
}