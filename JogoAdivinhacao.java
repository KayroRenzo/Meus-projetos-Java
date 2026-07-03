package projetos;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número máximo: ");
        int numeroMaximo = scanner.nextInt();

        int numeroSorteado = random.nextInt(numeroMaximo + 1);

        System.out.println("Digite seu número: ");
        int tentativa = scanner.nextInt();

        while (tentativa != numeroSorteado) {
            if (tentativa > numeroSorteado) {
                System.out.println("O número é menor!");

            } else if (tentativa < numeroSorteado) {
                System.out.println("O número é maior!");
            } else {
                System.out.println("Você acertou! O número é " + numeroSorteado);
            }
            System.out.println("Tente novamente");
            tentativa = scanner.nextInt();
        }
        System.out.println("Você acertou");
    }
}