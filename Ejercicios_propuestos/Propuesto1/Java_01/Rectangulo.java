package EjPropuesto.Java_01;

import java.util.Scanner;

public class Rectangulo {

    public double validarValor(String entrada) {
        try {
            double valor = Double.parseDouble(entrada.replace(",", "."));
            if (valor <= 0) {
                throw new IllegalArgumentException("El valor debe ser positivo.");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Entrada inválida. Debe ser un número válido.");
        }
    }

    public double calcularArea(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y altura deben ser positivas.");
        }
        return base * altura;
    }

    public void mostrarResultados(double base, double altura, double area) {
        System.out.println("\nResultados:");
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
        System.out.println("Área del rectángulo: " + area);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Rectangulo rectangulo = new Rectangulo();

        double base = 0;
        double altura = 0;

        while (true) {
            try {
                System.out.print("Ingresa la base del rectángulo: ");
                base = rectangulo.validarValor(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Ingresa la altura del rectángulo: ");
                altura = rectangulo.validarValor(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        double area = rectangulo.calcularArea(base, altura);
        rectangulo.mostrarResultados(base, altura, area);
        scan.close();
    }
}
