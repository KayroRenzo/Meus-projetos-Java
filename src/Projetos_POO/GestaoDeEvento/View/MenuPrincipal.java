package POO.Projetos_POO.GestaoDeEventos.View;

import POO.Projetos_POO.GestaoDeEventos.Controller.EventoController;
import POO.Projetos_POO.GestaoDeEventos.Controller.ParticipanteController;
import POO.Projetos_POO.GestaoDeEventos.Exceptions.CategoriaDoEventoInvalido;
import POO.Projetos_POO.GestaoDeEventos.Exceptions.TipoDoEventoInvalido;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private ParticipanteView participante;
    private EventoView evento;
    private InscricaoView inscricao;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);

        // Criar controllers primeiro
        ParticipanteController participanteController = new ParticipanteController();
        EventoController eventoController = new EventoController();

        // Passar controllers para as Views
        this.participante = new ParticipanteView(participanteController);
        this.evento = new EventoView(eventoController);

        // Passar as listas para InscricaoView
        this.inscricao = new InscricaoView(
                participanteController.getParticipantes(),
                eventoController.getEventos()
        );
    }

    private void menu() {
        System.out.println("\n=== GESTAO DE EVENTOS ===");
        System.out.println("1 - MENU DE PARTICIPANTES");
        System.out.println("2 - MENU DE EVENTOS");
        System.out.println("3 - MENU DE INSCRICAO");
        System.out.println("0 - SAIR DO SISTEMA");
        System.out.print("Digite uma das opcoes: ");
    }

    public void menuPrincipal() {
        int opcao;
        do {
            menu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        participante.menuParticipante();
                        break;
                    case 2:
                        evento.menuEvento();
                        break;
                    case 3:
                        inscricao.menuInscricao();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opcao invalida! Digite um numero entre 0 e 4.");
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite um numero.");
                scanner.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }
}