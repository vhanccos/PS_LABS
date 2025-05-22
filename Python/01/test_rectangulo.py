import unittest
from rectangulo import calcular_area


class TestCalculoAreaRectangulo(unittest.TestCase):
    # Dentro de la caja
    def test_enteros_positivos(self):
        self.assertEqual(calcular_area(4, 5), 20)

    def test_entero_y_decimal(self):
        self.assertAlmostEqual(calcular_area(4, 2.5), 10.0)

    def test_decimal_y_entero(self):
        self.assertAlmostEqual(calcular_area(3.5, 2), 7.0)

    def test_decimales(self):
        self.assertAlmostEqual(calcular_area(2.5, 1.2), 3.0)

    # Fuera de la caja
    def test_valor_vacio(self):
        with self.assertRaises(TypeError):
            calcular_area("", 5)

    def test_valor_nulo(self):
        with self.assertRaises(TypeError):
            calcular_area(None, 3)

    def test_valor_negativo_base(self):
        with self.assertRaises(ValueError):
            calcular_area(-4, 3)

    def test_valor_negativo_altura(self):
        with self.assertRaises(ValueError):
            calcular_area(4, -3)

    def test_valor_no_numerico(self):
        with self.assertRaises(TypeError):
            calcular_area("abc", 3)


if __name__ == "__main__":
    unittest.main()
