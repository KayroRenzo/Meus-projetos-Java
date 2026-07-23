package POO.Projetos_POO.GestaoDeEventos.View;

import POO.Projetos_POO.GestaoDeEventos.Controller.EventoController;
import POO.Projetos_POO.GestaoDeEventos.Exceptions.CategoriaDoEventoInvalido;
import POO.Projetos_POO.GestaoDeEventos.Exceptions.TipoDoEventoInvalido;

import java.util.Scanner;

public class EventoView {
    private Scanner scanner;
    private EventoController evento;

    public EventoView(EventoController evento) {
        this.scanner = new Scanner(System.in);
        this.evento = evento;
    }

    private void menu() {
        System.out.println("\n=== MENU EVENTO ===");
        System.out.println("1 - CRIAR EVENTO");
        System.out.println("2 - MOSTRAR EVENTOS");
        System.out.println("3 - PROCURAR EVENTO");
        System.out.println("4 - EDITAR EVENTO");
        System.out.println("5 - REMOVER EVENTO");
        System.out.println("6 - VISUALIZAR VAGA DISPONIVEL NO EVENTO");
        System.out.println("7 - LISTAR EVENTOS POR CATEGORIA");
        System.out.println("0 - SAIR");
        System.out.print("Escolha uma opcao: ");
    }

    public void menuEvento() {
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

            try {
                switch (opcao) {
                    case 1:
                        evento.criarEvento();
                        break;
                    case 2:
                        evento.mostrarEventos();
                        break;
                    case 3:
                        evento.procurarEventos();
                        break;
                    case 4:
                        evento.editarEvento();
                        break;
                    case 5:
                        evento.removerEvento();
                        break;
                    case 6:
                        evento.visualizarVagasDisponiveis();
                        break;
                    case 7:
                        evento.listarEventosPorCategoria();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } catch (TipoDoEventoInvalido | CategoriaDoEventoInvalido e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }
}