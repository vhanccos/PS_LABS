def mostrar_menu():
    print("\n=== Cajero Automático ===")
    print("1. Consultar Saldo")
    print("2. Depositar Dinero")
    print("3. Retirar Dinero")
    print("4. Salir")


def cajero_automatico():
    saldo = 1000.0  # Saldo inicial

    while True:
        mostrar_menu()
        opcion = input("Seleccione una opcion (1-4): ")

        if opcion == "1":
            print(f"\nSaldo actual: S/.{saldo:.2f}")

        elif opcion == "2":
            try:
                entrada = input("Ingrese el monto a depositar: ")
                monto = float(entrada.replace(",", "."))
                if (
                    monto <= 0
                ):  # Si se desea depositar 0 o numeros negativos (invalidos)
                    print("Error: El monto debe ser mayor que cero.")
                else:
                    saldo += monto
                    print(f"Deposito exitoso. Saldo actual: S/.{saldo:.2f}")
            except ValueError:  # Valor introducido no es un numero
                print("Error: Ingrese un numero válido.")

        elif opcion == "3":
            try:
                entrada = input("Ingrese el monto a retirar: ")
                monto = float(entrada.replace(",", "."))
                if monto <= 0:  # Si se desea retirar 0 o numeros negativos (invalidos)
                    print("Error: El monto debe ser mayor que cero.")
                elif (
                    monto > saldo
                ):  # Si el usuario quiere retirar un monto mayor a su saldo disponible
                    print("Error: Fondos insuficientes.")
                else:
                    saldo -= monto
                    print(f"Retiro exitoso. Saldo actual: S/.{saldo:.2f}")
            except ValueError:  # Valor introducido no es un numero
                print("Error: Ingrese un numero válido.")

        elif opcion == "4":
            print("Finalizando el programa. ¡Hasta luego!")
            break

        else:
            print("Opcion invalida. Intente de nuevo.")


# Ejecutar el programa
cajero_automatico()
