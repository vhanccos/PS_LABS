import unittest

from cajero import (
    validar_opcion,
    validar_monto,
    deposito,
    retiro,
    mostrar_menu,
)


class TestCajeroAutomatico(unittest.TestCase):
    # def setUp(self):
    #     self.saldo_inicial = 1000.0

    # Dentro de la caja
    def test_validar_opcion_valida(self):
        for opcion in ["1", "2", "3", "4"]:
            self.assertEqual(validar_opcion(opcion), opcion)

    def test_deposito_valido(self):
        saldo = 1000.0
        nuevo_saldo = deposito(saldo, 500)
        self.assertEqual(nuevo_saldo, 1500.0)

    def test_retiro_valido_menor_saldo(self):
        saldo = 1000.0
        nuevo_saldo = retiro(saldo, 400)
        self.assertEqual(nuevo_saldo, 600.0)

    def test_retiro_valido_igual_saldo(self):
        saldo = 1000.0
        nuevo_saldo = retiro(saldo, 1000)
        self.assertEqual(nuevo_saldo, 0.0)

    def test_mostrar_menu_contiene_opciones(self):
        menu = mostrar_menu()
        self.assertIn("1. Consultar Saldo", menu)
        self.assertIn("2. Depositar Dinero", menu)
        self.assertIn("3. Retirar Dinero", menu)
        self.assertIn("4. Salir", menu)

    # Fuera de la caja
    def test_validar_opcion_invalida(self):
        for opcion in ["0", "5", "abc", "", " "]:
            with self.assertRaises(ValueError):
                validar_opcion(opcion)

    def test_deposito_negativo_o_cero(self):
        saldo = 1000.0
        for monto in [-100, 0]:
            with self.assertRaises(ValueError):
                deposito(saldo, monto)

    def test_retiro_negativo_o_cero(self):
        saldo = 1000.0
        for monto in [-50, 0]:
            with self.assertRaises(ValueError):
                retiro(saldo, monto)

    def test_retiro_monto_mayor_al_saldo(self):
        saldo = 1000.0
        with self.assertRaises(ValueError):
            retiro(saldo, 1500)

    def test_validar_monto_valido(self):
        self.assertEqual(validar_monto("100"), 100.0)
        self.assertEqual(validar_monto("100.5"), 100.5)
        self.assertEqual(validar_monto("100,75"), 100.75)
        self.assertEqual(validar_monto(" 200 "), 200.0)

    def test_validar_monto_invalido(self):
        for valor in ["", "abc", "12a", "0", "-5", " ", ","]:
            with self.assertRaises(ValueError):
                validar_monto(valor)


if __name__ == "__main__":
    unittest.main()
