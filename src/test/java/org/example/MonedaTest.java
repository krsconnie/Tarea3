package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {

    private enum TipoMoneda{
        MONEDA100,
        MONEDA500,
        MONEDA1000,
        MONEDA1500
    }

    private Moneda crearMoneda(TipoMoneda tipo){
        switch(tipo){
            case MONEDA100:
                return new Moneda100();

            case MONEDA500:
                return new Moneda500();

            case MONEDA1000:
                return new Moneda1000();

            case MONEDA1500:
                return new Moneda1500();
            
            default:
                return null;
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName ("Test Monedas")
    public void testMoneda(){
        for(TipoMoneda tipo: TipoMoneda.values()){
            Moneda moneda = crearMoneda(tipo);
            assertNotNull(moneda);
            assertEquals(tipo, moneda.getSerie());
        }
    }

    @Test
    @DisplayName ("Test CompareTo")
    public void testCompareTo(){
        Moneda moneda100 = crearMoneda(TipoMoneda.MONEDA100);
        Moneda moneda500 = crearMoneda(TipoMoneda.MONEDA500);
        Moneda moneda1000 = crearMoneda(TipoMoneda.MONEDA1000);
        Moneda moneda1500 = crearMoneda(TipoMoneda.MONEDA1500);

        assertTrue(moneda100.compareTo(moneda500) < 0);
        assertTrue(moneda100.compareTo(moneda1000) < 0);
        assertTrue(moneda100.compareTo(moneda1500) < 0);

        assertTrue(moneda500.compareTo(moneda100) > 0);
        assertTrue(moneda500.compareTo(moneda1000) < 0);
        assertTrue(moneda500.compareTo(moneda1500) < 0);
        
        assertTrue(moneda1000.compareTo(moneda100) > 0);
        assertTrue(moneda1000.compareTo(moneda500) > 0);
        assertTrue(moneda1000.compareTo(moneda1500) < 0);
        
        assertTrue(moneda1500.compareTo(moneda100) > 0);
        assertTrue(moneda1500.compareTo(moneda500) > 0);
        assertTrue(moneda1500.compareTo(moneda1000) > 0);

        assertEquals(0, moneda100.compareTo(moneda100));
        assertEquals(0, moneda500.compareTo(moneda500));
        assertEquals(0, moneda1000.compareTo(moneda1000));
        assertEquals(0, moneda1500.compareTo(moneda1500));
    }

}