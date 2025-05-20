def main():
    while True:
        try:
            cantidad = int(input("¿Cuántos números desea ingresar? "))
            if cantidad <= 0:
                print("Por favor ingrese un número entero positivo.")
                continue
            break
        except ValueError:
            print("¡Error! Debe ingresar un número entero válido.")

    numeros = []

    for i in range(cantidad):
        while True:
            try:
                entrada = input(f"Ingrese el número {i + 1}: ")
                num = float(entrada)
                if not num.is_integer():
                    print("¡Debe ser un número entero!")
                    continue
                numeros.append(int(num))
                break
            except ValueError:
                print("¡Entrada inválida! Ingrese un número entero.")

    print("\nResultados:")
    for num in numeros:
        if num % 2 == 0:
            print(f"{num} es par")
        else:
            print(f"{num} es impar")


if __name__ == "__main__":
    main()
