package POO.Projetos_POO.sistemaBiblioteca.controller;

import POO.Projetos_POO.sistemaBiblioteca.model.Emprestimo;
import POO.Projetos_POO.sistemaBiblioteca.model.Livro;
import POO.Projetos_POO.sistemaBiblioteca.model.Usuarios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmprestimoController {
    private Scanner scanner;
    private HashSet<Usuarios> usuarios;
    private HashMap<Integer, Livro> livros;
    private HashSet<Emprestimo> emprestimos;

    // Construtor com HashMap
    public EmprestimoController(HashSet<Usuarios> usuarios, HashMap<Integer, Livro> livros) {
        this.scanner = new Scanner(System.in);
        this.usuarios = usuarios;
        this.livros = livros;
        this.emprestimos = new HashSet<>();
    }

    public void fazerEmprestimo() {
        System.out.println("=== FAZER EMPRESTIMO ===");

        if (usuarios.isEmpty()) {
            System.out.println("Erro: Nenhum usuario cadastrado!");
            return;
        }
        if (livros.isEmpty()) {
            System.out.println("Erro: Nenhum livro disponivel!");
            return;
        }

        System.out.println("Usuarios disponiveis:");
        for (Usuarios user : usuarios) {
            System.out.println(user);
        }

        System.out.print("Digite o nome do usuario: ");
        String nomeUsuario = scanner.nextLine();

        Usuarios usuarioEncontrado = null;
        for (Usuarios user : usuarios) {
            if (user.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = user;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Erro: Usuario nao encontrado!");
            return;
        }

        System.out.println("Livros disponiveis:");
        for (Livro livro : livros.values()) {
            System.out.println(livro);
        }

        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();

        Livro livroEncontrado = null;
        Integer idEncontrado = null;
        for (Integer id : livros.keySet()) {
            Livro livro = livros.get(id);
            if (livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
                livroEncontrado = livro;
                idEncontrado = id;
                break;
            }
        }

        if (livroEncontrado == null) {
            System.out.println("Erro: Livro nao encontrado!");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(usuarioEncontrado, livroEncontrado);
        emprestimos.add(emprestimo);
        livros.remove(idEncontrado);

        System.out.println("Livro emprestado com sucesso!");
        System.out.println("Detalhes: " + emprestimo);
    }

    public void mostrarEmprestimos() {
        System.out.println("=== EMPRESTIMOS ===");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo encontrado.");
            return;
        }
        for (Emprestimo emp : emprestimos) {
            System.out.println(emp);
        }
    }

    public void mostrarEmprestimoAtrasados() {
        System.out.println("=== EMPRESTIMOS ATRASADOS ===");
        boolean encontrou = false;

        for (Emprestimo emp : emprestimos) {
            if (emp.getStatus().equalsIgnoreCase("Atrasado")) {
                System.out.println(emp);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum emprestimo atrasado.");
        }
    }
}