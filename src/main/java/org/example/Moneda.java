package org.example;
/**
 *Super clase "modelo"
 * para las monedas de distinto valor
 */
public abstract class Moneda implements Comparable {
    protected int valor;
    protected int serie;
    /**
     * Constructor de Moneda
     */
    public Moneda() {
    }
    public abstract int getValor();

    /**
     * getSerie() no tiene parametros de entrada
     * retorna el valor protegido serie
     */
    public Moneda getSerie() {
        return this;
    }

    /**
     * Método compareTo para comparar
     * objetos de tipo Moneda
     */
    public int compareTo(Moneda otraMoneda) {
        if (this.valor < otraMoneda.valor) {
            return -1;
        } else if (this.valor > otraMoneda.valor) {
            return 1;
        } else {
            return 0;
        }
    }
}