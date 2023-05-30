package org.example;
/**Un
 * expendedor que tendrá depositos para cada producto
 * y para el vuelto
 */
public class Expendedor {
    /**
     * Se declaran enteros que hacen referencia a cada deposito según su tipo de producto
     * Se declara un entero que será el precio del producto escogido
     * Se declaran depositos de cada producto, de vuelto y uno auxiliar
     */
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int SNICKER = 3;
    public static final int SUPER8 = 4;
    private int precio;
    private Deposito<CocaCola> depCoca;
    private Deposito<Sprite> depSprite;
    private Deposito<Snickers> depSnick;
    private Deposito<Super8> depSup8;

    private Deposito<Moneda> depVuelto;
    private Deposito<Moneda100> aux;
    /**
     * Constructor de Expendedor
     * @param n numero de bebidas
     * @param precio precio de la bebida
     */
    public Expendedor(int n, int precio) {
        this.precio = precio;
        this.depVuelto = new Deposito<Moneda>();
        depCoca = new Deposito<>();
        depSprite = new Deposito<>();
        depSnick = new Deposito<>();
        depSup8 = new Deposito<>();
        aux = new Deposito<>();

        for (int i = 0; i < n; i++) {
            depCoca.addItem(new CocaCola(200 + i));
            depSprite.addItem(new Sprite(200 + i));
            depSnick.addItem(new Snickers ( 300 + i));
            depSup8.addItem(new Super8(300 + i));
        }

        for (int i = 0; i < 100; i++) {
            aux.addItem(new Moneda100());
        }
    }
    /**
     *Método comprarProducto permite comprar
     *(o no en caso de no ser posible)
     *un producto de la maquina expendedora
     *@param peseta , moneda
     * @param cual, el tipo de producto a comprar
     * @return  ret
     */
    public Producto comprarProducto(Moneda peseta, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto ret = null;
        int vuelto = 0;

        if (peseta == null) {
            throw new PagoIncorrectoException("No se recibió el pago.");
        }

        switch (cual) {
            case 1: {
                if (peseta.getValor() >= precio) {
                    vuelto = peseta.getValor() - precio;
                    ret = depCoca.getItem();
                    break;
                }else throw new PagoInsuficienteException("El pago efectuado no es suficiente.");
            }
            case 2: {
                if (peseta.getValor() >= precio) {
                    vuelto = peseta.getValor() - precio;
                    ret = depSprite.getItem ();
                    break;
                }else throw new PagoInsuficienteException("El pago efectuado no es suficiente.");
            }
            case 3: {
                if (peseta.getValor() >= precio) {
                    vuelto = peseta.getValor() - precio;
                    ret = depSnick.getItem();
                    break;
                }else throw new PagoInsuficienteException("El pago efectuado no es suficiente.");
            }
            case 4: {
                if (peseta.getValor() >= precio) {
                    vuelto = peseta.getValor() - precio;
                    ret = depSup8.getItem();
                    break;
                }else throw new PagoInsuficienteException("El pago efectuado no es suficiente.");
            }
        }
        if (ret != null) {
            vuelto = vuelto / 100;
            for (int i = 0; i < vuelto; i++) {
                depVuelto.addItem(aux.getItem());
            }
            peseta = null;
        } else {
            depVuelto.addItem(peseta);
            throw new NoHayProductoException("No hay stock del producto seleccionado.");
        }
        return ret;
    }
    /**
     * Método getVuelto, para entregar el vuelto
     */
    public Moneda getVuelto() {
        return depVuelto.getItem();
    }
}