package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Expendedor.ProductoTipo.COCA;//Se utiliza COCA como caso general


import static org.junit.jupiter.api.Assertions.*;

class CompradorTest{
    private Comprador comprador;
    public Moneda500 moneda500;
    private Expendedor expendedor;
    @BeforeEach
    void setUp() {
        expendedor = new Expendedor(3,COCA);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test Moneda nula")
    public void TestMonedaNula() throws PagoIncorrectoException {
        assertThrows(PagoIncorrectoException.class, () -> {
            comprador = new Comprador(moneda500, COCA, expendedor);
            expendedor.comprarProducto(moneda500,COCA);
        });
    }
    @Test
    @DisplayName("Test Recibe Vuelto de un producto")
    public void RecibirVuelto1() throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        Moneda1000 moneda1000 = new Moneda1000();
        comprador = new Comprador(moneda1000, COCA, expendedor);
        assertNotNull(expendedor.comprarProducto(moneda1000,COCA));
        assertNotNull(expendedor.getVuelto());
    }

    @Test
    @DisplayName("Test recibe Vuelto multiples compras")
    public void RecibirVuelto2() throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException{
        Moneda1000 moneda1000 = new Moneda1000();
        comprador = new Comprador(moneda1000,COCA, expendedor);
        assertNotNull(expendedor.comprarProducto(moneda1000,COCA));
        assertNotNull(expendedor.getVuelto());
        assertNotNull(expendedor.comprarProducto(moneda1000,COCA));
        assertNotNull(expendedor.getVuelto());
    }
}