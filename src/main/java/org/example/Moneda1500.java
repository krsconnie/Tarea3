package org.example;
/**
 * Subclase de Moneda, representa la moneda de 1500
 */
public class Moneda1500 extends Moneda {
    /**
     * Constructor de Moneda1500
     * le otorga a la variable valor = 1500
     */
    public Moneda1500() {
        super();
        super.valor = 1500;
    }
    /**
     * metodo getValor() no tiene parametros
     * @return int valor, cantidad de $
     */
    public int getValor() {
        int valor = super.valor;
        return valor;
    }

    @Override
    public int compareTo() {
        return 0;
    }
}