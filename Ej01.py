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


def calcular_area_rectangulo():
    print("Cálculo del área de un rectángulo\n")

    base = obtener_valor("Ingresa la base del rectángulo: ")
    altura = obtener_valor("Ingresa la altura del rectángulo: ")

    area = base * altura

    if base % 1 == 0:
        base = int(base)
    if altura % 1 == 0:
        altura = int(altura)
    if area % 1 == 0:
        area = int(area)

    print(f"\nResultados:")
    print(f"Base: {base}")
    print(f"Altura: {altura}")
    print(f"Área del rectángulo: {area}")


if __name__ == "__main__":
    calcular_area_rectangulo()
