package projetos;

import java.util.Scanner;

public class SistemaEscolar {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA ESCOLAR ===");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno: ");
        String aluno = scanner.nextLine();

        System.out.println("Primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.println("Segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.println("Terceira nota: ");
        double nota3 = scanner.nextDouble();

        System.out.println("Quarta nota: ");
        double nota4 = scanner.nextDouble();

        if (nota1 < 0 || nota2 < 0 || nota3 < 0 || nota4 < 0) {
            System.out.println("Insira uma nota maior que 0");
        } else if (nota1 > 10 || nota2 > 10 || nota3 > 10 || nota4 > 10) {
            System.out.println("Insira uma nota menor que 10");
        } else {
            System.out.println("Média geral do aluno:");
            double media = (nota1 + nota2 + nota3 + nota4) / 4;

            if (media >= 6) {
                System.out.println("Sua média foi: " + media);
                System.out.println("Parabéns " + aluno + ", você foi aprovado");
            } else {
                System.out.println("Sua média foi: " + media);
                System.out.println(aluno + " Você foi reprovado");
            }
        }
    }
}