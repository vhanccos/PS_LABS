//package EjPropuesto.Java_03;

import java.util.Scanner;

public class ATM {
    private double saldo;

    public ATM(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Entradas solo numericas, en caso de ingresarse un valor con coma, lo transforma a punto
    public double validarEntradaMonto(String entrada) {
        return Double.parseDouble(entrada.replace(",", ".")); // Lanza NumberFormatException si no es numero
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String depositar(double monto) {
        String msj = "";
        if (monto <= 0) {
            msj = "Error: El monto debe ser mayor que cero.";
            return msj;
        }
        else if(!(monto % 10 == 0)){
            msj = "Error: Solo se permiten montos en billetes";
            return msj;
        }
        saldo += monto;
        msj = "Deposito exitoso. Saldo actual: S/." + saldo;
        return msj;
    }

    public String retirar(double monto) {
        String msj = "";
        if (monto <= 0) {
            msj = "Error: El monto debe ser mayor que cero.";
            return msj;
        }
        else if(!(monto % 10 == 0)){
            msj = "Error: Solo se permiten montos en billetes";
            return msj;
        } 
        else if (monto > saldo) {
            msj = "Error: Fondos insuficientes.";
            return msj;
        }
        // De no haber problemas, se realiza el retiro
        saldo -= monto; 
        msj = "Retiro exitoso. Saldo actual: S/." + saldo;
        return msj;
    }

    // No parte de funcionalidad, auxiliar para mostrar menu
    public static void mostrarMenu() {
        System.out.println("\n=== Cajero Automático ===");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar Dinero");
        System.out.println("3. Retirar Dinero");
        System.out.println("4. Salir");
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        ATM cajero = new ATM(1000.0);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción (1-4): ");
            String opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.printf("\nSaldo actual: " + cajero.consultarSaldo());
                    break;
                case "2":
                    System.out.print("Ingrese el monto a depositar: ");
                    try {
                        double monto = Double.parseDouble(scan.nextLine().replace(",", "."));
                        System.out.println(cajero.depositar(monto));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un numero valido.");
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el monto a retirar: ");
                    try {
                        double monto = Double.parseDouble(scan.nextLine().replace(",", "."));
                        System.out.println(cajero.retirar(monto));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un numero valido.");
                    }
                    break;
                case "4":
                    System.out.println("Finalizando el programa.");
                    scan.close();
                    return;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }

    }
    
}
