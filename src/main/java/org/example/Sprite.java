package org.example;
/**
 *Subclase de Bebida,
 *representa la bebida Sprite
 */
public class Sprite extends Bebida {
    /**
     *Constructor para los productos Sprite
     *@param s1 int
     */
    public Sprite(int s1) {
        super(s1);
    }
    /**
     *Se sobreescribe el metodo consumir()
     *@return "sprite"
     */
    @Override
    public String consumir() {
        return "sprite";
    }
}