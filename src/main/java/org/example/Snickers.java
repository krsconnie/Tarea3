package org.example;
/**
 *Subclase de Dulce,
 *representa los Snickers
 */
public class Snickers extends Dulce{
    /**
     *Constructor para Snickers
     *@param s2 int
     */
    public Snickers(int s2){super(s2);}
    /**
     *Se sobreescribe el metodo consumir()
     *@return "Snicker"
     */
    @Override
    public String consumir() {return "Snicker";}
}