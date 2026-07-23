package POO.Projetos_POO.sistemaBiblioteca.src;

import POO.Projetos_POO.sistemaBiblioteca.controller.LivroController;
import POO.Projetos_POO.sistemaBiblioteca.controller.UserController;
import POO.Projetos_POO.sistemaBiblioteca.model.Livro;
import POO.Projetos_POO.sistemaBiblioteca.model.Usuarios;
import POO.Projetos_POO.sistemaBiblioteca.view.BibliotecaView;
import POO.Projetos_POO.sistemaBiblioteca.view.LivroView;
import POO.Projetos_POO.sistemaBiblioteca.view.UsuarioView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private int opcao;
    private Scanner scanner;
    private UsuarioView usuarioView;
    private LivroView livroView;

    public Main() {
        this.scanner = new Scanner(System.in);
        UserController userController = new UserController();
        LivroController livroController = new LivroController();

        HashSet<Usuarios> usuarios = userController.getUsuarios();
        HashMap<Integer, Livro> livros = livroController.getLivros();

        this.usuarioView = new UsuarioView(userController);
        this.livroView = new LivroView(livroController, usuarios, livros);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciar();
    }

    public void iniciar() {
        do {
            BibliotecaView.exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuarioView.gerenciarUsuarios();
                    break;
                case 2:
                    livroView.gerenciarLivros();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}