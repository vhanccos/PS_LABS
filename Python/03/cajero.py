def mostrar_menu():
    menu = (
        "\n=== Cajero Automático ===\n"
        "1. Consultar Saldo\n"
        "2. Depositar Dinero\n"
        "3. Retirar Dinero\n"
        "4. Salir\n"
    )
    return menu


def validar_opcion(opcion_str):
    if opcion_str not in {"1", "2", "3", "4"}:
        raise ValueError("Opción inválida")
    return opcion_str


def validar_monto(monto_str):
    if not monto_str.strip():
        raise ValueError("Entrada vacía")
    try:
        monto = float(monto_str.replace(",", "."))
    except ValueError:
        raise ValueError("Monto no válido")
    if monto <= 0:
        raise ValueError("El monto debe ser mayor que cero")
    return monto


def deposito(saldo, monto):
    if monto <= 0:
        raise ValueError("El monto debe ser mayor que cero")
    saldo += monto
    return saldo


def retiro(saldo, monto):
    if monto <= 0:
        raise ValueError("El monto debe ser mayor que cero")
    if monto > saldo:
        raise ValueError("Fondos insuficientes")
    return saldo - monto


def cajero_automatico():
    saldo = 1000.0

    while True:
        print(mostrar_menu())
        opcion = input("Seleccione una opcion (1-4): ")
        try:
            opcion_valida = validar_opcion(opcion)
        except ValueError:
            print("Opcion invalida. Intente de nuevo.")
            continue

        if opcion_valida == "1":
            print(f"\nSaldo actual: S/.{saldo:.2f}")

        elif opcion_valida == "2":
            entrada = input("Ingrese el monto a depositar: ")
            try:
                monto = validar_monto(entrada)
                saldo = deposito(saldo, monto)
                print(f"Deposito exitoso. Saldo actual: S/.{saldo:.2f}")
            except ValueError as e:
                print(f"Error: {e}")

        elif opcion_valida == "3":
            entrada = input("Ingrese el monto a retirar: ")
            try:
                monto = validar_monto(entrada)
                saldo = retiro(saldo, monto)
                print(f"Retiro exitoso. Saldo actual: S/.{saldo:.2f}")
            except ValueError as e:
                print(f"Error: {e}")

        elif opcion_valida == "4":
            print("Finalizando el programa. ¡Hasta luego!")
            break


if __name__ == "__main__":
    cajero_automatico()
