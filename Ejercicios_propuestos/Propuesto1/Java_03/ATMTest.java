package EjPropuesto.Java_03;

import static org.junit.Assert.*;
import org.junit.Test; 

public class ATMTest {
    
    // --- CONSULTAR SALDO ---

    @Test // Dentro de la caja, verificar que el saldo inicial sea correcto
    public void testSaldoInicialCorrecto() {
        ATM cajero = new ATM(1000.0);
        assertEquals(1000.0, cajero.consultarSaldo(), 0.01);
    }
    @Test // Dentro de la caja, verificar que el saldo se actualize correctamente
    public void testSaldoSeActualizaCorrectamente() {
        ATM cajero = new ATM(1000.0);
        cajero.depositar(500.0); // 1500
        cajero.retirar(200.0); // 1300
        assertEquals(1300.0, cajero.consultarSaldo(), 0.01);
    }

    // --- DEPOSITOS ---

    @Test // Dentro de la caja, deposito > 0
    public void testDepositoValorMayorQueCero() {
        ATM cajero = new ATM(500.0);
        String resultado = cajero.depositar(200.0);
        assertEquals("Deposito exitoso. Saldo actual: S/.700.0", resultado);
    }

    @Test // Fuera de la caja, deposito no puede pagarse con monedas
    public void testDepositoValorNoMultiploDe10() {
        ATM cajero = new ATM(1000.0);
        String resultado = cajero.depositar(25);
        assertEquals("Error: Solo se permiten montos en billetes", resultado);
    }

    @Test // Fuera de la caja, deposito = 0
    public void testDepositoValorCero() {
        ATM cajero = new ATM(300.0);
        String resultado = cajero.depositar(0);
        assertEquals("Error: El monto debe ser mayor que cero.", resultado);
    }

    @Test // Fuera de la caja, deposito < 0
    public void testDepositoValorNegativo() {
        ATM cajero = new ATM(300.0);
        String resultado = cajero.depositar(-50.0);
        assertEquals("Error: El monto debe ser mayor que cero.", resultado);
    }
    
    @Test // Fuera de la caja, deposito es un valor no numerico
    public void testDepositoValorNoNumerico() {
        ATM cajero = new ATM(1000.0);
        String entrada = "hola mundo"; // Entrada vacia por parte del usuario en el menu

        assertThrows(NumberFormatException.class, () -> {
            double monto = Double.parseDouble(entrada);
            cajero.depositar(monto);
        });
    }

    @Test // Fuera de la caja, deposito es un valor vacio
    public void testDepositoValorVacio() {
        ATM cajero = new ATM(1000.0);
        String entrada = ""; // Entrada vacia por parte del usuario en el menu

        assertThrows(NumberFormatException.class, () -> {
            double monto = Double.parseDouble(entrada);
            cajero.depositar(monto);
        });
    }
    // --- RETIROS ---

    @Test // Dentro de la caja, retiro > 0 && retiro < saldo
    public void testRetiroValorPositivoYMenorQueSaldoDisponible() {
        ATM cajero = new ATM(1000.0);
        String resultado = cajero.retirar(400.0);
        assertEquals("Retiro exitoso. Saldo actual: S/.600.0", resultado);
    }
    @Test // Dentro de la caja, retiro > 0 && retiro = saldo
    public void testRetiroValorPositivoEIgualQueSaldoDisponible() {
        ATM cajero = new ATM(1000.0);
        String resultado = cajero.retirar(1000.0);
        assertEquals("Retiro exitoso. Saldo actual: S/.0.0", resultado);
    }


    @Test // Fuera de la caja, retiro > 0 && retiro > saldo
    public void testRetiroValorPositivoMayorASaldo() {
        ATM cajero = new ATM(200.0);
        String resultado = cajero.retirar(300.0);
        assertEquals("Error: Fondos insuficientes.", resultado);
    }
    
    @Test // Fuera de la caja, No se pueden retirar monedas
    public void testRetiroValorNoMultiploDe10() {
        ATM cajero = new ATM(1000.0);
        String resultado = cajero.retirar(35);
        assertEquals("Error: Solo se permiten montos en billetes", resultado);
    }

    @Test // Fuera de la caja, retiro = 0
    public void testRetiroValorCero() {
        ATM cajero = new ATM(500.0);
        String resultado = cajero.retirar(0.0);
        assertEquals("Error: El monto debe ser mayor que cero.", resultado);
    }

    @Test // Fuera de la caja, retiro < 0
    public void testRetiroValorNegativo() {
        ATM cajero = new ATM(500.0);
        String resultado = cajero.retirar(-100.0);
        assertEquals("Error: El monto debe ser mayor que cero.", resultado);
    }

    @Test // Fuera de la caja, retiro es un valor no numerico
    public void testRetiroValorNoNumerico() {
        ATM cajero = new ATM(1000.0);
        String entrada = "hola mundo"; // Entrada vacia por parte del usuario en el menu

        assertThrows(NumberFormatException.class, () -> {
            double monto = Double.parseDouble(entrada);
            cajero.retirar(monto);
        });
    }

    @Test // Fuera de la caja, el retiro es un valor vacio
    public void testRetiroValorVacio() {
        ATM cajero = new ATM(1000.0);
        String entrada = ""; // Entrada vacia por parte del usuario en el menu

        assertThrows(NumberFormatException.class, () -> {
            double monto = Double.parseDouble(entrada);
            cajero.retirar(monto);
        });
    }
}
