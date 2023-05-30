package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Expendedor.ProductoTipo.COCA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepositoTest {

    @Test
    @DisplayName("Test getItem cuando hay elementos")
    public void testGetItemCuandoHayElementos() {
        Deposito<Moneda> deposito = new Deposito<>();
        deposito.addItem(new Moneda100());
        deposito.addItem(new Moneda500());

        Moneda moneda1 = deposito.getItem();
        Moneda moneda2 = deposito.getItem();

        assertEquals(Moneda100.class, moneda1.getClass());
        assertEquals(Moneda500.class, moneda2.getClass());
    }

    @Test
    @DisplayName("Test getItem cuando no hay elementos")
    public void testGetItemCuandoNoHayElementos() {
        Deposito<Producto> deposito = new Deposito<>();

        Producto producto = deposito.getItem();

        assertNull(producto);
    }

    @Test
    @DisplayName("Test addItem")
    public void testAddItem() {
        Deposito<Producto> deposito = new Deposito<>();
        CocaCola coca = new CocaCola(1);
        deposito.addItem(coca);

        Producto producto = deposito.getItem();

        assertEquals(CocaCola.class, producto.getClass());
    }
}
