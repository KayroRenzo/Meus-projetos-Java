package POO.Projetos_POO.sistemaBiblioteca.view;

import POO.Projetos_POO.sistemaBiblioteca.controller.UserController;

import java.util.Scanner;

public class UsuarioView {
    private Scanner scanner;
    private UserController userController;

    public UsuarioView(UserController userController) {
        this.scanner = new Scanner(System.in);
        this.userController = userController;
    }

    public void gerenciarUsuarios() {
        int opcao;

        do {
            System.out.println("\n=== ABA DE USUARIOS ===");
            System.out.println("1 - MOSTRAR USUARIOS");
            System.out.println("2 - ADICIONAR USUARIO");
            System.out.println("3 - EDITAR USUARIO");
            System.out.println("4 - EXCLUIR USUARIO");
            System.out.println("0 - VOLTAR");
            System.out.print("Escolha uma opcao: ");

            opcao = lerOpcao();

            try {
                switch (opcao) {
                    case 1:
                        userController.mostrarUsuarios();
                        break;
                    case 2:
                        userController.registrarUsuario();
                        break;
                    case 3:
                        userController.editarUsuario();
                        break;
                    case 4:
                        userController.excluirUsuario();
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Digite apenas numeros!");
            return -1;
        }
    }
}