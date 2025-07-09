def contar_pares_impares(numeros):
    resultado = []
    for num in numeros:
        if not isinstance(num, int):
            raise TypeError("Solo se permiten enteros")
        if num % 2 == 0:
            resultado.append((num, "par"))
        else:
            resultado.append((num, "impar"))
    return resultado


def validar_cantidad(cantidad_str):
    if not cantidad_str.strip():
        raise ValueError("Entrada vacía")
    try:
        cantidad = int(cantidad_str)
    except ValueError:
        raise ValueError("Debe ser un número entero válido")
    if cantidad <= 0:
        raise ValueError("Debe ser un entero positivo mayor que 0")
    return cantidad


def validar_numero(numero_str):
    if not numero_str.strip():
        raise ValueError("Entrada vacía")
    try:
        num = float(numero_str)
    except ValueError:
        raise ValueError("Debe ingresar un número válido")
    if not num.is_integer():
        raise ValueError("Debe ser un número entero")
    return int(num)


def main():
    while True:
        try:
            cantidad_input = input("¿Cuántos números desea ingresar? ")
            cantidad = validar_cantidad(cantidad_input)
            break
        except ValueError as e:
            print(f"¡Error! {e}")

    numeros = []
    for i in range(cantidad):
        while True:
            try:
                entrada = input(f"Ingrese el número {i + 1}: ")
                num = validar_numero(entrada)
                numeros.append(num)
                break
            except ValueError as e:
                print(f"¡Error! {e}")

    print("\nResultados:")
    for num, tipo in contar_pares_impares(numeros):
        print(f"{num} es {tipo}")


if __name__ == "__main__":
    main()
