package org.example;
/**
 *Subclase de Bebida,
 * representa la bebida CocaCola
 */
public class CocaCola extends Bebida {
    /**
     *Constructor para los productos CocaCola
     * @param s1 int
     */
    public CocaCola(int s1) {
        super(s1);
    }
    /**
     *Se sobreescribe el método consumir()
     *@return "cocacola
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}