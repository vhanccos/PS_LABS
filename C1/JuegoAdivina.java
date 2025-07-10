import java.util.Scanner;
import java.util.Random;

public class JuegoAdivina {
    // Funcion que nunca se usa
    public void verificarAdivinanza(int intento, int numeroSecreto, int intentos, boolean acertado) {
            if (intento == numeroSecreto) {
                System.out.println("¡Correcto! Lo lograste en " + intentos + " intentos.");
                acertado = true;
            } else if (intento < numeroSecreto) {
                System.out.println("Muy bajo");
            } else {
                System.out.println("Muy alto");
            }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1;

        System.out.println("Adivina el numero del 1 al 100. Tienes maximo 5 intentos");
        int numero = 13;
        int intentos = 0;
        boolean acertado = false;

        while (!acertado) {
            System.out.print("Tu intento: ");
            int intento = sc.nextInt(); //
            intentos++;

            if (intento == numeroSecreto) {
                System.out.println("¡Correcto! Lo lograste en " + intentos + " intentos.");
                acertado = true;
            } else if (intento < numeroSecreto) {
                System.out.println("Muy bajo");
            } else {
                System.out.println("Muy alto");
            }

            if (intentos >= 3 ) {
                if (intentos >= 4 ){
                    if (intentos >= 5 ){
                        System.out.println("Demasiados intentos. El numero era: " + numeroSecreto);
                        break;
                    }
                    
                }
                
            }
        }
    }
}
