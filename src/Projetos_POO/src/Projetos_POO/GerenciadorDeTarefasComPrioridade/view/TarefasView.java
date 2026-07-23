package POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.view;

import POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.controller.TarefaController;

import java.util.Scanner;

public class TarefasView {
    private Scanner scanner;
    private TarefaController controller;

    public TarefasView() {
        this.scanner = new Scanner(System.in);
        this.controller = new TarefaController();
    }

    public void menuPrincipal() {
        int opcao = 0;

        while (opcao != 10) {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1 - LISTAR TAREFAS");
            System.out.println("2 - ADICIONAR TAREFA");
            System.out.println("3 - ATUALIZAR TAREFA");
            System.out.println("4 - REMOVER TAREFA");
            System.out.println("5 - BUSCAR POR ID");
            System.out.println("6 - GERENCIAR STATUS");
            System.out.println("7 - FILTRAR TAREFAS");
            System.out.println("8 - RELATORIOS");
            System.out.println("9 - TAREFAS ATRASADAS");
            System.out.println("10 - SAIR");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    controller.listarTarefas();
                    break;
                case 2:
                    controller.adicionarTarefa();
                    break;
                case 3:
                    controller.atualizarTarefa();
                    break;
                case 4:
                    controller.removerTarefa();
                    break;
                case 5:
                    controller.buscarPorId();
                    break;
                case 6:
                    menuGerenciarStatus();
                    break;
                case 7:
                    menuFiltrarTarefas();
                    break;
                case 8:
                    menuRelatorios();
                    break;
                case 9:
                    controller.verTarefasAtrasadas();
                    break;
                case 10:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private void menuGerenciarStatus() {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== GERENCIAR STATUS ===");
            System.out.println("1 - INICIAR TAREFA");
            System.out.println("2 - CONCLUIR TAREFA");
            System.out.println("3 - BLOQUEAR TAREFA");
            System.out.println("4 - CANCELAR TAREFA");
            System.out.println("5 - VOLTAR");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    controller.iniciarTarefa();
                    break;
                case 2:
                    controller.concluirTarefa();
                    break;
                case 3:
                    controller.bloquearTarefa();
                    break;
                case 4:
                    controller.cancelarTarefa();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private void menuFiltrarTarefas() {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== FILTRAR TAREFAS ===");
            System.out.println("1 - FILTRAR POR PRIORIDADE");
            System.out.println("2 - FILTRAR POR STATUS");
            System.out.println("3 - FILTRAR POR CATEGORIA");
            System.out.println("4 - FILTRAR POR PRAZO");
            System.out.println("5 - VOLTAR");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    controller.filtrarPorPrioridade();
                    break;
                case 2:
                    controller.filtrarPorStatus();
                    break;
                case 3:
                    controller.filtrarPorCategoria();
                    break;
                case 4:
                    controller.filtrarPorPrazo();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private void menuRelatorios() {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n=== RELATORIOS ===");
            System.out.println("1 - TAREFAS URGENTES");
            System.out.println("2 - TAXA DE CONCLUSAO");
            System.out.println("3 - DISTRIBUICAO POR PRIORIDADE");
            System.out.println("4 - VOLTAR");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    controller.verTarefasUrgentes();
                    break;
                case 2:
                    controller.verTaxaConclusao();
                    break;
                case 3:
                    controller.verDistribuicaoPrioridade();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}