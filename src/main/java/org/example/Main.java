package org.example;

import static org.example.Expendedor.ProductoTipo.SUPER8;

/**
 * Tarea 1 Programación II: Una máquina expendedora que venda
 * tanto Bebidas como dulces a un Comprador, al recibir una moneda
 */
public class Main {
    /**
     * Constructor default de Tarea1_PrograII
     */
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(4, SUPER8);
        Moneda m = null;
        Comprador c = null;
        /*
          Se prueba el expendedor con Super8
         */
        try {
            m = null;
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            //e.printStackTrace(System.out);
            System.out.println("No se recibió el pago");
        }

        /*
          Se prueba el expendedor con Super8
         */
        try {
            m = new Moneda100();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            e.printStackTrace(System.out);
            System.out.println("El pago efectuado no es suficiente.");
        }

        try {
            m = new Moneda1500();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

            m = new Moneda1000();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

            m = new Moneda500();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

            m = new Moneda1000();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            e.printStackTrace(System.out);
            System.out.println("No se recibió el pago");
        }

        /*
          Se prueba el momento en el que la máquina
          se queda sin Productos para vender
         */
        try {
            m = new Moneda1000();
            c = new Comprador(m, SUPER8, exp);
            System.out.println(c.queConsumiste() + ", " + c.cuantoVuelto());

        } catch (PagoIncorrectoException e) {
            e.printStackTrace(System.out);
            System.out.println("No hay stock del producto seleccionado.");
        }
    }
}
