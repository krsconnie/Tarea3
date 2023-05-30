package org.example;
/**
 Subclase de Moneda,
 representa la moneda de 100 pesos
 */
public class Moneda100 extends Moneda {
    /**
     *Constructor de Moneda100
     *le otorga a la variable (llamada con super)
     *valor = 100
     */
    public Moneda100() {
        super();
        super.valor = 100;
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