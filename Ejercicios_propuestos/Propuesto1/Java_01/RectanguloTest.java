package EjPropuesto.Java_01;

import static org.junit.Assert.*;
import org.junit.Test; 

public class RectanguloTest {


    @Test // Dentro de la caja, valor ingresado es entero positivo
    public void testValorEnteroPositivo() {
        Rectangulo r = new Rectangulo();
        assertEquals(10.0, r.validarValor("10"),0.1);
    }

    @Test // Dentro de la caja, valor ingresado es decimal positivo
    public void testValorDecimalPositivo() {
        Rectangulo r = new Rectangulo();
        assertEquals(5.75, r.validarValor("5.75"),0.1);
    }

    @Test // Fuera de la caja, valor ingresado es negativo
    public void testValorNegativo() {
        Rectangulo r = new Rectangulo();
        Exception e = assertThrows(IllegalArgumentException.class, () -> r.validarValor("-4"));
        assertEquals("El valor debe ser positivo.", e.getMessage());
    }

    @Test // Fuera de la caja, valor ingresado es cero
    public void testValorCero() {
        Rectangulo r = new Rectangulo();
        Exception e = assertThrows(IllegalArgumentException.class, () -> r.validarValor("0"));
        assertEquals("El valor debe ser positivo.", e.getMessage());
    }

    @Test // Fuera de la caja, valor ingresado no es numérico
    public void testValorNoNumerico() {
        Rectangulo r = new Rectangulo();
        assertThrows(NumberFormatException.class, () -> r.validarValor("abc"));
    }
    
    @Test // Fuera de la caja, valor es vacio
    public void testValorVacio() {
        Rectangulo r = new Rectangulo();
        assertThrows(NumberFormatException.class, () -> r.validarValor("abc"));
    }

    @Test // Dentro de la caja, base y altura son enteros positivos
    public void testCalculoAreaSoloValoresEnterosPositivos() {
        Rectangulo r = new Rectangulo();
        assertEquals(20.0, r.calcularArea(4, 5),0.1);
    }

    @Test // Dentro de la caja, base y altura son decimales positivos
    public void testCalculoAreaSoloValoresDecimalesPositivos() {
        Rectangulo r = new Rectangulo();
        assertEquals(7.5, r.calcularArea(2.5, 3.0),0.1);
    }

    @Test // Dentro de la caja, calculo de area con valor decimal y positivo
    public void testCalculoAreaConValorDecimalYEntero() {
        Rectangulo r = new Rectangulo();
        assertEquals(7.5, r.calcularArea(2.5, 3.0),0.1);
    }


}
