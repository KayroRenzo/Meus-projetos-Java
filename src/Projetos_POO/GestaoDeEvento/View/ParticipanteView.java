package POO.Projetos_POO.GestaoDeEventos.View;

import POO.Projetos_POO.GestaoDeEventos.Controller.ParticipanteController;

import java.util.Scanner;

public class ParticipanteView {
    private Scanner scanner;
    private ParticipanteController participante;

    public ParticipanteView(ParticipanteController participante) {
        this.scanner = new Scanner(System.in);
        this.participante = participante;
    }

    private void menu() {
        System.out.println("\n=== MENU PARTICIPANTE ===");
        System.out.println("1 - CADASTRAR PARTICIPANTE");
        System.out.println("2 - LISTAR PARTICIPANTE");
        System.out.println("3 - BUSCAR PARTICIPANTE");
        System.out.println("4 - EDITAR PARTICIPANTE");
        System.out.println("5 - EXCLUIR PARTICIPANTE");
        System.out.println("6 - LISTAR PARTICIPANTE POR TIPO");
        System.out.println("0 - SAIR");
        System.out.print("Escolha uma opcao: ");
    }

    public void menuParticipante() {
        int opcao = 0;

        do {
            menu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Opcao invalida! Digite um numero.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    participante.cadastrarParticipante();
                    break;
                case 2:
                    participante.listarParticipantes();
                    break;
                case 3:
                    participante.buscarParticipantes();
                    break;
                case 4:
                    participante.editarParticipante();
                    break;
                case 5:
                    participante.excluirParticipante();
                    break;
                case 6:
                    participante.listarParticipantePorTipo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }
}