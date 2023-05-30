package org.example;
/**
 * Se declara Excepción personalizada,
 * cuando el pago es insuficiente
 */
public class PagoInsuficienteException extends Exception{
    /**
     * Se define método que etrega el mensaje de error
     * @param msg mensaje de error
     */
    public PagoInsuficienteException(String msg){
        super (msg);
    }
}