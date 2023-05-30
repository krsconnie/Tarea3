package org.example;
/**
 * Se declara Excepción personalizada,
 * cuando el pago es incorrecto (null)
 */
public class PagoIncorrectoException extends Exception{
    /**
     * Se define método que etrega el mensaje de error
     * @param msg mensaje de error
     */
    public PagoIncorrectoException(String msg){
        super(msg);
    }
}