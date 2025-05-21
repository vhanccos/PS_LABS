package EjPropuesto.Java_02;

import static org.junit.Assert.*;
import org.junit.Test; 
import java.util.List;

public class EvaluadorNumerosTest {

    EvaluadorNumeros eval = new EvaluadorNumeros();

    // --- validarCantidad ---

    @Test // Dentro de la caja, cantidad > 0
    public void testCantidadValida() {
        assertEquals(1, eval.validarCantidad("1"));
    }

    @Test // Fuera de la caja, cantidad = 0
    public void testCantidadCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            eval.validarCantidad("0");
        });
        assertEquals("Cantidad debe ser mayor a 0.", exception.getMessage());
    }

    @Test // Fuera de la caja, cantidad < 0
    public void testCantidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> eval.validarCantidad("-5"));
    }

    @Test // Fuera de la caja, cantidad decimal
    public void testCantidadDecimal() {
        assertThrows(NumberFormatException.class, () -> eval.validarCantidad("2.0"));
    }

    @Test // Fuera de la caja, cantidad no numerica
    public void testCantidadNoNumerica() {
        assertThrows(NumberFormatException.class, () -> eval.validarCantidad("abc"));
    }

    @Test // Fuera de la caja, cantidad vacia
    public void testCantidadVacia() {
        assertThrows(NumberFormatException.class, () -> eval.validarCantidad(""));
    }

    // --- validarNumero ---

    @Test // Dentro de la caja, numero entero positivo
    public void testNumeroValidoPositivo() {
        assertEquals(10, eval.validarNumero("10"));
    }
    
    @Test // Dentro de la caja, numero entero negativo 
    public void testNumeroValidoNegativo() {
        assertEquals(-13, eval.validarNumero("-13"));
    }
    @Test // Fuera de la caja, numero decimal
    public void testNumeroDecimal() {
        assertThrows(NumberFormatException.class, () -> eval.validarNumero("2.5"));
    }

    @Test // Fuera de la caja, entrada no es un numero
    public void testNumeroInvalido() {
        assertThrows(NumberFormatException.class, () -> eval.validarNumero("un texto cualquiera"));
    }

    @Test // Fuera de la caja, entrada vacia
    public void testNumeroVacio() {
        assertThrows(NumberFormatException.class, () -> eval.validarNumero(""));
    }

    // --- evaluarPares ---

    @Test // Dentro de la caja, Numeros pares e impares
    public void testEvaluarListaParesEImpares() {
        List<Integer> numeros = List.of(1, 2, 3, 4);
        List<String> esperado = List.of(
            "1 es impar",
            "2 es par",
            "3 es impar",
            "4 es par"
        );
        assertEquals(esperado, eval.evaluarPares(numeros));
    }
    @Test // Dentro de la caja, Solo numeros pares
    public void testEvaluarListaSoloNumerosPares() {
        List<Integer> numeros = List.of(0, 2, 20, 412);
        List<String> esperado = List.of(
            "0 es par",
            "2 es par",
            "20 es par",
            "412 es par"
        );
        assertEquals(esperado, eval.evaluarPares(numeros));
    }

    @Test // Dentro de la caja, Solo Numeros impares
    public void testEvaluarListaSoloNumerosImpares() {
        List<Integer> numeros = List.of(1, 3, 5, 7);
        List<String> esperado = List.of(
            "1 es impar",
            "3 es impar",
            "5 es impar",
            "7 es impar"
        );
        assertEquals(esperado, eval.evaluarPares(numeros));
    }

    @Test // Dentro de la caja, Numeros positivos y negativos
    public void testEvaluarListaNumerosPositivosYNegativos() {
        List<Integer> numeros = List.of(0, -2, 20, -15);
        List<String> esperado = List.of(
            "0 es par",
            "-2 es par",
            "20 es par",
            "-15 es impar"
        );
        assertEquals(esperado, eval.evaluarPares(numeros));
    }

    @Test // Fuera de la caja, en caso de generarse una lista vacia
    public void testEvaluarListaVacia() {
        List<Integer> numeros = List.of();
        assertThrows(IllegalArgumentException.class, () -> eval.evaluarPares(numeros));
    }

}
