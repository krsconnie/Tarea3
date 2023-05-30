package org.example;
import javax.print.event.PrintEvent;
import javax.sound.sampled.SourceDataLine;

/**
 * Clase comprador que crea una entidad "comprador" que tendrá una moneda con la que
 * comprará un cierto producto en un expendedor
 */
public class Comprador {

    /**
     * Declaración de propiedades,
     * Comprador devolverá un String (que consumió)
     * y un entero (el vuelto)
     */
    private String consumir;
    private int vuelto;

    /**
     * Constructor de comprador
     * @param m moneda con la que se comprará
     * @param CualProducto que escoge que tipo de producto ( que tipo de Bebida o Dulce)
     * @param maquina el expendedor en el que se compra
     */
    public Comprador(Moneda m, int CualProducto, Expendedor maquina) throws PagoIncorrectoException{
        vuelto = 0;

        Producto paquete;
        if (m == null){
            throw new PagoIncorrectoException("No se recibió el pago");
        }
        try {
            paquete = maquina.comprarProducto(m,CualProducto);

            while (true) {
                Moneda devuelve = maquina.getVuelto();
                if (devuelve == null) {
                    break;
                }

                vuelto += devuelve.getValor();
            }

            if (paquete != null) {
                consumir = paquete.consumir();
            }
        } catch (PagoInsuficienteException e) {
            //e.printStackTrace(System.out);
            System.out.println("El pago efectuado no es suficiente");
        } catch (NoHayProductoException e) {
            //e.printStackTrace(System.out);
            System.out.println("No hay producto");
        }

    }
    /**
     * Método que permite saber el vuelto resultante
     * después de comprar
     * @return vuelto
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * Método que permite saber
     * que se comsumió después de comprar
     * @return consumir
     */
    public String queConsumiste() {
        return consumir;
    }
}