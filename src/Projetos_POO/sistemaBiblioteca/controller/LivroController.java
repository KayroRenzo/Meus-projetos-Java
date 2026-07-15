package POO.Projetos_POO.sistemaBiblioteca.controller;

import POO.Projetos_POO.sistemaBiblioteca.model.Livro;

import java.util.HashMap;
import java.util.Scanner;

public class LivroController {
    private Scanner scanner;
    private HashMap<Integer, Livro> livros;
    private int proximoId;

    public LivroController() {
        this.scanner = new Scanner(System.in);
        this.livros = new HashMap<>();
        this.proximoId = 1;
    }

    public HashMap<Integer, Livro> getLivros() {
        return livros;
    }

    public void listarLivros() {
        System.out.println("=== LISTA DOS LIVROS ===");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        for (int id : livros.keySet()) {
            Livro livro = livros.get(id);
            System.out.println("ID: " + id + " - " + livro);
        }
        System.out.println("Total: " + livros.size() + " livro(s)");
    }

    public void adicionarLivro() {
        System.out.println("=== ADICIONAR LIVRO ===");

        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();

        // Validação
        if (nomeLivro.isEmpty() || nomeAutor.isEmpty()) {
            System.out.println("Erro: Nome do livro e autor nao podem ser vazios!");
            return;
        }

        // Verifica se o livro já existe
        for (Livro livro : livros.values()) {
            if (livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
                System.out.println("Erro: Livro \"" + nomeLivro + "\" ja existe!");
                return;
            }
        }

        int id = proximoId++;
        Livro livro = new Livro(nomeLivro, nomeAutor);
        livros.put(id, livro);
        System.out.println("Livro \"" + nomeLivro + "\" adicionado com sucesso! (ID: " + id + ")");
    }

    public void procurarLivro() {
        System.out.println("=== PROCURAR LIVRO ===");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine().trim();

        boolean encontrado = false;
        for (int id : livros.keySet()) {
            Livro livro = livros.get(id);
            if (livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
                System.out.println("Livro encontrado!");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + livro.getNomeLivro());
                System.out.println("Autor: " + livro.getNomeAutor());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Livro \"" + nomeLivro + "\" nao encontrado!");
        }
    }

    public void deletarLivro() {
        System.out.println("=== DELETAR LIVRO ===");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        listarLivros();

        System.out.print("Digite o ID do livro que deseja excluir: ");
        int id = lerInteiro();

        if (livros.containsKey(id)) {
            Livro livro = livros.get(id);
            livros.remove(id);
            System.out.println("Livro \"" + livro.getNomeLivro() + "\" deletado com sucesso!");
        } else {
            System.out.println("Erro: ID " + id + " nao encontrado!");
        }
    }

    public void editarLivro() {
        System.out.println("=== EDITAR LIVRO ===");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        listarLivros();

        System.out.print("Digite o ID do livro que deseja editar (ou 0 para cancelar): ");
        int id = lerInteiro();

        if (id == 0) {
            System.out.println("Operacao cancelada.");
            return;
        }

        if (livros.containsKey(id)) {
            Livro livro = livros.get(id);

            System.out.println("\nDados atuais:");
            System.out.println("Nome: " + livro.getNomeLivro());
            System.out.println("Autor: " + livro.getNomeAutor());

            System.out.println("\nO que deseja editar?");
            System.out.println("1 - Nome do livro");
            System.out.println("2 - Nome do autor");
            System.out.println("3 - Ambos");
            System.out.print("Escolha uma opcao: ");

            int opcao = lerInteiro();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome do livro: ");
                    String novoNome = scanner.nextLine().trim();
                    if (!novoNome.isEmpty()) {
                        livro.setNomeLivro(novoNome);
                        System.out.println("Nome do livro atualizado com sucesso!");
                    } else {
                        System.out.println("Erro: Nome do livro nao pode ser vazio!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o novo nome do autor: ");
                    String novoAutor = scanner.nextLine().trim();
                    if (!novoAutor.isEmpty()) {
                        livro.setNomeAutor(novoAutor);
                        System.out.println("Nome do autor atualizado com sucesso!");
                    } else {
                        System.out.println("Erro: Nome do autor nao pode ser vazio!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o novo nome do livro: ");
                    novoNome = scanner.nextLine().trim();
                    System.out.print("Digite o novo nome do autor: ");
                    novoAutor = scanner.nextLine().trim();

                    if (!novoNome.isEmpty() && !novoAutor.isEmpty()) {
                        livro.setNomeLivro(novoNome);
                        livro.setNomeAutor(novoAutor);
                        System.out.println("Livro atualizado com sucesso!");
                    } else {
                        System.out.println("Erro: Nome do livro e autor nao podem ser vazios!");
                    }
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

            System.out.println("\nDados atualizados:");
            System.out.println("ID: " + id + " - " + livro);

        } else {
            System.out.println("Erro: ID " + id + " nao encontrado!");
        }
    }

    private int lerInteiro() {
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            return numero;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Erro: Digite apenas numeros!");
            return -1;
        }
    }
}