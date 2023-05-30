package org.example;

/**
 * Un expendedor que tendrá depositos para cada producto
 * y para el vuelto
 */
public class Expendedor {
    /**
     * Enumeración que define los tipos de producto y sus precios
     */
    public enum ProductoTipo {
        COCA(1), SPRITE(2), SNICKER(3), SUPER8(4);

        private int precio;

        ProductoTipo(int precio) {
            this.precio = precio;
        }

        public int getPrecio() {
            return precio;
        }
    }

    private ProductoTipo productoSeleccionado;
    private Deposito<CocaCola> depCoca;
    private Deposito<Sprite> depSprite;
    private Deposito<Snickers> depSnick;
    private Deposito<Super8> depSup8;
    private Deposito<Moneda> depVuelto;
    private Deposito<Moneda100> aux;

    /**
     * Constructor de Expendedor
     * @param n número de bebidas
     * @param productoTipo tipo de producto a vender
     */
    public Expendedor(int n, ProductoTipo productoTipo) {
        this.productoSeleccionado = productoTipo;
        this.depVuelto = new Deposito<Moneda>();
        depCoca = new Deposito<>();
        depSprite = new Deposito<>();
        depSnick = new Deposito<>();
        depSup8 = new Deposito<>();
        aux = new Deposito<>();

        for (int i = 0; i < n; i++) {
            depCoca.addItem(new CocaCola(200 + i));
            depSprite.addItem(new Sprite(200 + i));
            depSnick.addItem(new Snickers(300 + i));
            depSup8.addItem(new Super8(300 + i));
        }

        for (int i = 0; i < 100; i++) {
            aux.addItem(new Moneda100());
        }
    }

    /**
     * Método comprarProducto permite comprar (o no en caso de no ser posible) un producto de la maquina expendedora
     *
     * @param peseta       moneda
     * @param productoTipo
     * @return ret
     */
    public Producto comprarProducto(Moneda peseta, ProductoTipo productoTipo) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto ret = null;
        int vuelto = 0;

        if (peseta == null) {
            throw new PagoIncorrectoException("No se recibió el pago.");
        }

        int precioProducto = productoSeleccionado.getPrecio();

        if (peseta.getValor() >= precioProducto) {
            vuelto = peseta.getValor() - precioProducto;

            switch (productoSeleccionado) {
                case COCA:
                    ret = depCoca.getItem();
                    break;
                case SPRITE:
                    ret = depSprite.getItem();
                    break;
                case SNICKER:
                    ret = depSnick.getItem();
                    break;
                case SUPER8:
                    ret = depSup8.getItem();
                    break;
            }
        } else {
            throw new PagoInsuficienteException("El pago efectuado no es suficiente.");
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
