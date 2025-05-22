def obtener_valor(mensaje):
    while True:
        entrada = input(mensaje)
        try:
            valor = float(entrada.replace(",", "."))
            if valor <= 0:
                print("Por favor, ingresa un número positivo.")
            else:
                return valor
        except ValueError:
            print(
                "Entrada inválida. Asegúrate de ingresar un número (entero o decimal)."
            )


def calcular_area(base, altura):
    if not isinstance(base, (int, float)) or not isinstance(altura, (int, float)):
        raise TypeError("La base y la altura deben ser números.")
    if base <= 0 or altura <= 0:
        raise ValueError("La base y la altura deben ser valores positivos.")
    return base * altura


def calcular_area_rectangulo():
    print("Cálculo del área de un rectángulo\n")

    base = obtener_valor("Ingresa la base del rectángulo: ")
    altura = obtener_valor("Ingresa la altura del rectángulo: ")

    area = calcular_area(base, altura)

    print(f"\nResultados:")
    print(f"Base: {base}")
    print(f"Altura: {altura}")
    print(f"Área del rectángulo: {area}")


if __name__ == "__main__":
    calcular_area_rectangulo()
