package POO.Projetos_POO.miniCrm.view;

import POO.Projetos_POO.miniCrm.controller.ClienteController;

import java.util.Scanner;

public class ClienteView {
    private Scanner scanner;
    private ClienteController clienteController;

    public ClienteView(ClienteController clienteController) {
        this.scanner = new Scanner(System.in);
        this.clienteController = clienteController;
    }

    public void iniciarCrm() {
        int opcao;
        do {
            System.out.println("=== SISTEMA DE CRM ===");
            System.out.println("1 - CADASTRAR CLIENTE");
            System.out.println("2 - LISTAR CLIENTES");
            System.out.println("3 - LISTAR CLIENTES EM NEGOCIAÇÃO");
            System.out.println("4 - REGISTRAR INTERAÇÃO");
            System.out.println("5 - LISTAR INTERAÇÃO");
            System.out.println("6 - TROCAR STATUS");
            System.out.println("7 - ADICIONAR AÇÃO");
            System.out.println("8 - MOSTRAR AÇÕES");
            System.out.println("0 - SAIR DO SISTEMA");
            System.out.println("Digite alguma opcão: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    clienteController.cadastrarCliente();
                    break;
                case 2:
                    clienteController.listarClientes();
                    break;
                case 3:
                    clienteController.listarClienteEmNegociacao();
                    break;
                case 4:
                    clienteController.registrarInteracao();
                    break;
                case 5:
                    clienteController.listarInteracao();
                    break;
                case 6:
                    clienteController.trocarStatus();
                    break;
                case 7:
                    clienteController.adicionarAcao();
                    break;
                case 8:
                    clienteController.mostrarAcoes();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcão inválida");
            }
        } while (opcao != 0);
    }

}
