package POO.Projetos_POO.sistemaBiblioteca.view;

import POO.Projetos_POO.sistemaBiblioteca.controller.EmprestimoController;
import POO.Projetos_POO.sistemaBiblioteca.controller.LivroController;
import POO.Projetos_POO.sistemaBiblioteca.model.Livro;
import POO.Projetos_POO.sistemaBiblioteca.model.Usuarios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LivroView {
    private Scanner scanner;
    private LivroController livroController;
    private EmprestimoController emprestimoController;
    private int opcao;

    public LivroView(LivroController livroController, HashSet<Usuarios> usuarios, HashMap<Integer, Livro> livros) {
        this.scanner = new Scanner(System.in);
        this.livroController = livroController;
        this.emprestimoController = new EmprestimoController(usuarios, livros);
    }

    public void gerenciarLivros() {
        int opcao;

        do {
            System.out.println("=== ABA DE LIVROS ===");
            System.out.println("1 - VER LIVROS");
            System.out.println("2 - PROCURAR LIVRO");
            System.out.println("3 - ADICIONAR LIVRO");
            System.out.println("4 - EDITAR LIVRO");
            System.out.println("5 - EXCLUIR UM LIVRO");
            System.out.println("6 - FAZER EMPRESTIMO");
            System.out.println("7 - MOSTRAR EMPRESTIMOS");
            System.out.println("8 - MOSTRAR EMPRESTIMOS ATRASADOS");
            System.out.println("0 - VOLTAR");
            System.out.print("Escolha uma opcao: ");

            opcao = lerOpcao();
            try {
                switch (opcao) {
                    case 1:
                        livroController.listarLivros();
                        break;
                    case 2:
                        livroController.procurarLivro();
                        break;
                    case 3:
                        livroController.adicionarLivro();
                        break;
                    case 4:
                        livroController.editarLivro();
                        break;
                    case 5:
                        livroController.deletarLivro();
                        break;
                    case 6:
                        emprestimoController.fazerEmprestimo();
                        break;
                    case 7:
                        emprestimoController.mostrarEmprestimos();
                        break;
                    case 8:
                        emprestimoController.mostrarEmprestimoAtrasados();
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