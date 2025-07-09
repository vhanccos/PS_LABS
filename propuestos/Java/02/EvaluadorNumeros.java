//package EjPropuesto.Java_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EvaluadorNumeros {

    // cantidad > 0, es un numero entero
    public int validarCantidad(String entrada) {
        int cantidad = Integer.parseInt(entrada);
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor a 0.");
        }
        return cantidad;
    }

    // datos de la lista son enteros
    public int validarNumero(String entrada) {
        return Integer.parseInt(entrada); // Lanza NumberFormatException si no es numero entero
    }

    // Evaluar si los numeros de la lista son pares
    public List<String> evaluarPares(List<Integer> numeros) {
        if(numeros.size() == 0) throw new IllegalArgumentException("La lista de numeros esta vacia.");

        List<String> resultados = new ArrayList<>();
        String msj = "";
        for (int n : numeros) {
            msj = n + " es " + ((n%2 == 0) ? "par" : "impar");
            resultados.add(msj);
        }
        return resultados;
    }

    public static void main(String[] args) {
        EvaluadorNumeros eval = new EvaluadorNumeros();
        Scanner scan = new Scanner(System.in);
        int cantidad = 0;
        
        // Validar cantidad
        while (true) {
            System.out.print("Ingrese la cantidad de números: ");
            try {
                String entrada = scan.nextLine();
                cantidad = eval.validarCantidad(entrada);
                break;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
            }
        }

        // Leer los numeros
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            while (true) { // Bucle para ingresar numeros validos
                System.out.print("Ingrese el número #" + i + ": ");
                try {
                    String entrada = scan.nextLine();
                    int numero = eval.validarNumero(entrada);
                    numeros.add(numero);
                    break;
                } catch (Exception e) { // por NumberFormatException
                    System.out.println("Debe ingresar un número entero válido.");
                }
            }
        }

        // Mostrar si son pares o impares
        List<String> resultados = eval.evaluarPares(numeros);
        for (String r : resultados) {
            System.out.println(r);
        }

        scan.close();
    }
}
