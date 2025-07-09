import unittest
from contador import contar_pares_impares, validar_cantidad, validar_numero


# Dentro de la caja
class TestDentroDeLaCaja(unittest.TestCase):
    def test_lista_un_numero(self):
        self.assertEqual(contar_pares_impares([3]), [(3, "impar")])
        self.assertEqual(contar_pares_impares([4]), [(4, "par")])

    def test_solo_pares(self):
        self.assertEqual(
            contar_pares_impares([2, 4, 6]), [(2, "par"), (4, "par"), (6, "par")]
        )

    def test_solo_impares(self):
        self.assertEqual(
            contar_pares_impares([1, 3, 5]), [(1, "impar"), (3, "impar"), (5, "impar")]
        )

    def test_pares_e_impares(self):
        self.assertEqual(
            contar_pares_impares([1, 2, 3, 4]),
            [(1, "impar"), (2, "par"), (3, "impar"), (4, "par")],
        )

    def test_valor_entero_positivo(self):
        self.assertEqual(contar_pares_impares([7]), [(7, "impar")])

    def test_valor_entero_negativo(self):
        self.assertEqual(contar_pares_impares([-4, -3]), [(-4, "par"), (-3, "impar")])

    def test_valor_cero(self):
        self.assertEqual(contar_pares_impares([0]), [(0, "par")])


# Fuera de la caja
class TestFueraDeLaCajaCantidad(unittest.TestCase):
    def test_valor_negativo_cantidad(self):
        with self.assertRaises(ValueError):
            validar_cantidad("-5")

    def test_valor_decimal_cantidad(self):
        with self.assertRaises(ValueError):
            validar_cantidad("3.14")

    def test_valor_cero_cantidad(self):
        with self.assertRaises(ValueError):
            validar_cantidad("0")

    def test_valor_no_numerico_cantidad(self):
        with self.assertRaises(ValueError):
            validar_cantidad("abc")

    def test_entrada_vacia_cantidad(self):
        with self.assertRaises(ValueError):
            validar_cantidad("")

    def test_cantidad_valida(self):
        self.assertEqual(validar_cantidad("5"), 5)


class TestFueraDeLaCajaNumeros(unittest.TestCase):
    def test_valor_decimal_numero(self):
        with self.assertRaises(ValueError):
            validar_numero("2.5")

    def test_valor_no_numerico_numero(self):
        with self.assertRaises(ValueError):
            validar_numero("hola")

    def test_entrada_vacia_numero(self):
        with self.assertRaises(ValueError):
            validar_numero("")

    def test_numero_valido(self):
        self.assertEqual(validar_numero("7"), 7)

    def test_contar_pares_impares_con_decimal_directo(self):
        # probar que contar_pares_impares no acepta floats directamente
        with self.assertRaises(TypeError):
            contar_pares_impares([2.5])


if __name__ == "__main__":
    unittest.main()
