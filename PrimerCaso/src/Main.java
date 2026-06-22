import java.util.Scanner;
import pilaDinamica.Analizador;

public class Main {

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n=== MENU ANALIZADOR DE EXPRESIONES ===");
            System.out.println("1. Convertir infija a postfija");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese expresión infija: ");
                    String expresion = leer.nextLine();

                    String resultado =
                            Analizador.infijaAPostfija(expresion);

                    System.out.println("\nResultado postfija: " + resultado);

                    break;

                case 2:

                    System.out.println("Saliendo del programa...");
                    break;

                default:

                    System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (opcion != 2);

        leer.close();
    }
}