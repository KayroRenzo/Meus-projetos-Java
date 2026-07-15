package POO.Projetos_POO.sistemaBancario.view;

import POO.Projetos_POO.sistemaBancario.controller.BancoController;
import POO.Projetos_POO.sistemaBancario.Exceptions.SaldoInsuficiente;
import java.util.Scanner;

public class BancoView {
    private Scanner scanner;
    private BancoController controller;
    private int opcao;

    public BancoView(){
        this.scanner = new Scanner(System.in);
        this.controller = new BancoController();
    }

    public void executar() {
        do {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        controller.depositar();
                        break;
                    case 2:
                        controller.sacar();
                        break;
                    case 3:
                        controller.verSaldo();
                        break;
                    case 0:
                        System.out.println("Saindo..");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SaldoInsuficiente e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}