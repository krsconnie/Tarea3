package org.example;
/**
 * Se declara Excepción personalizada,
 cuando no hay bebida en el deposito
 */
public class NoHayProductoException extends Exception{
    /**
     * Se define método que etrega el mensaje de error
     * @param msg mensaje de error
     */
    public NoHayProductoException(String msg){
        super(msg);
    }
}