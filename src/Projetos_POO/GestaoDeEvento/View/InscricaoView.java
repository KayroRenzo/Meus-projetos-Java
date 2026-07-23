package POO.Projetos_POO.GestaoDeEventos.View;

import POO.Projetos_POO.GestaoDeEventos.Controller.InscricaoController;
import POO.Projetos_POO.GestaoDeEventos.Model.Evento;
import POO.Projetos_POO.GestaoDeEventos.Model.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscricaoView {
    private Scanner scanner;
    private InscricaoController inscricao;

    public InscricaoView(List<Participante> participantes, List<Evento> eventos) {
        this.scanner = new Scanner(System.in);
        this.inscricao = new InscricaoController(participantes, eventos);
    }

    private void menu() {
        System.out.println("\n=== MENU INSCRICAO ===");
        System.out.println("1 - FAZER INSCRICAO");
        System.out.println("2 - LISTAR INSCRICAO");
        System.out.println("3 - CONFIRMAR INSCRICAO");
        System.out.println("4 - CANCELAR INSCRICAO");
        System.out.println("5 - CONFIRMAR PRESENCA");
        System.out.println("6 - LISTAR INSCRICAO POR EVENTO");
        System.out.println("7 - LISTAR INSCRICAO POR PARTICIPANTE");
        System.out.println("8 - LISTAR INSCRICAO POR PARTICIPANTE CONFIRMADOS");
        System.out.println("0 - SAIR");
        System.out.print("Escolha uma opcao: ");
    }

    public void menuInscricao() {
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
                    inscricao.fazerInscricao();
                    break;
                case 2:
                    inscricao.listarInscricoes();
                    break;
                case 3:
                    inscricao.confirmarInscricao();
                    break;
                case 4:
                    inscricao.cancelarInscricao();
                    break;
                case 5:
                    inscricao.confirmarPresenca();
                    break;
                case 6:
                    inscricao.listarInscricoesPorEvento();
                    break;
                case 7:
                    inscricao.listarInscricoesPorParticipante();
                    break;
                case 8:
                    inscricao.listarInscricoesPorParticipanteConfirmados();
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