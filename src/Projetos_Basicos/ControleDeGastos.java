package projetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeGastos {
    public static void main(String[] args) {
        ArrayList<Double> gastos = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n== CONTROLE DE GASTOS ==");
            System.out.println("1 - Cadastrar gasto");
            System.out.println("2 - Calcular a média total");
            System.out.println("3 - Ver o maior gasto");
            System.out.println("4 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do seu gasto: R$ ");
                    double gasto = input.nextDouble();
                    gastos.add(gasto);
                    System.out.println("Gasto cadastrado com sucesso!");
                    break;

                case 2:
                    if (gastos.isEmpty()) {
                        System.out.println("Nenhum gasto cadastrado!");
                    } else {
                        double soma = 0;
                        System.out.println("\nCálculo da média total");
                        for (int i = 0; i < gastos.size(); i++) {
                            System.out.println("Gasto " + (i+1) + ": R$ " + gastos.get(i));
                            soma += gastos.get(i);
                        }
                        double media = soma / gastos.size();
                        System.out.println("Média total: R$ " + String.format("%.2f", media));
                    }
                    break;

                case 3:
                    if (gastos.isEmpty()) {
                        System.out.println("Nenhum gasto cadastrado!");
                    } else {
                        int indiceMaior = 0;
                        System.out.println("\nMaior gasto");
                        for (int i = 1; i < gastos.size(); i++) {
                            if (gastos.get(i) > gastos.get(indiceMaior)) {
                                indiceMaior = i;
                            }
                        }
                        System.out.println("Maior gasto: R$ " + gastos.get(indiceMaior));
                        System.out.println("Posição: " + (indiceMaior + 1) + "º gasto");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    input.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}