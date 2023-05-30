package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Expendedor.ProductoTipo.COCA;//Se utiliza COCA como caso general


import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    private Expendedor expendedor;
    public Moneda500 moneda500;

    @BeforeEach
    void setUp() {
        expendedor = new Expendedor(3, Expendedor.ProductoTipo.COCA);
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("Test 3 compras exitosas")
    public void TestTresComprasExitosas() throws Exception{
        moneda500 = new Moneda500();
        assertNotNull(expendedor.comprarProducto(moneda500,COCA));
        assertNotNull(expendedor.comprarProducto(moneda500,COCA));
        assertNotNull(expendedor.comprarProducto(moneda500,COCA));
    }
    @Test
    @DisplayName("Test No hay Producto excepcion")
    public void TestCompraConDepositoVacio() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        moneda500 = new Moneda500();
        assertThrows(NoHayProductoException.class, ()->{
        expendedor.comprarProducto(moneda500,COCA);
        expendedor.comprarProducto(moneda500,COCA);
        expendedor.comprarProducto(moneda500,COCA);
        expendedor.comprarProducto(moneda500,COCA);
    });
    }
    @Test
    @DisplayName("Test Pago Incorrecto")
    public void TestPagoIncorrecto()throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        assertThrows(PagoIncorrectoException.class, () -> {
            expendedor.comprarProducto(moneda500, COCA);//moneda500 = null
        });
    }
    @Test
    @DisplayName("Test Pago Insuficiente")
    public void TestPagoInsuficiente() throws NoHayProductoException, PagoInsuficienteException,PagoIncorrectoException {
        assertThrows(PagoInsuficienteException.class, () -> {
            Moneda100 moneda100 = new Moneda100();
            expendedor.comprarProducto(moneda100, COCA);
        });
    }
}