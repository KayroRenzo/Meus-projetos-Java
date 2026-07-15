package POO.Projetos_POO.sistemaBiblioteca.controller;

import POO.Projetos_POO.sistemaBiblioteca.model.Livro;
import POO.Projetos_POO.sistemaBiblioteca.model.Usuarios;

import java.util.HashSet;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private HashSet<Usuarios> usuarios;
    private HashSet<Livro> catalogoLivros;

    public UserController() {
        this.scanner = new Scanner(System.in);
        this.usuarios = new HashSet<>();
        this.catalogoLivros = new HashSet<>();
    }

    public HashSet<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void registrarUsuario() {
        System.out.println("=== REGISTRAR USUARIO ===");
        System.out.print("Digite nome do usuario: ");
        String name = scanner.nextLine();

        // Verifica se o usuario ja existe
        for (Usuarios user : usuarios) {
            if (user.getNomeUsuario().equalsIgnoreCase(name)) {
                System.out.println("Erro: Usuario \"" + name + "\" ja esta cadastrado!");
                return;
            }
        }

        Usuarios novoUsuario = new Usuarios(name);
        usuarios.add(novoUsuario);
        System.out.println("Usuario \"" + name + "\" cadastrado com sucesso!");
    }

    public void mostrarUsuarios() {
        System.out.println("=== USUARIOS CADASTRADOS ===");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        int contador = 1;
        for (Usuarios user : usuarios) {
            System.out.println(contador++ + ". " + user.getNomeUsuario());
        }
        System.out.println("Total: " + usuarios.size() + " usuario(s)");
    }

    public void excluirUsuario() {
        System.out.println("=== EXCLUIR USUARIO ===");

        if (usuarios.isEmpty()) {
            System.out.println("Erro: Nenhum usuario cadastrado!");
            return;
        }

        mostrarUsuarios();

        System.out.print("Digite o nome do usuario que deseja excluir: ");
        String nomeUsuario = scanner.nextLine().trim();

        Usuarios usuarioParaRemover = null;

        for (Usuarios user : usuarios) {
            if (user.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                usuarioParaRemover = user;
                break;
            }
        }

        if (usuarioParaRemover != null) {
            usuarios.remove(usuarioParaRemover);
            System.out.println("Usuario \"" + nomeUsuario + "\" excluido com sucesso!");
        } else {
            System.out.println("Erro: Usuario \"" + nomeUsuario + "\" nao encontrado!");
        }
    }

    public void editarUsuario() {
        System.out.println("=== EDITAR USUARIO ===");

        if (usuarios.isEmpty()) {
            System.out.println("Erro: Nenhum usuario cadastrado!");
            return;
        }

        mostrarUsuarios();

        System.out.print("Digite o nome do usuario que deseja editar: ");
        String nomeAntigo = scanner.nextLine().trim();

        Usuarios usuarioEncontrado = null;

        for (Usuarios user : usuarios) {
            if (user.getNomeUsuario().equalsIgnoreCase(nomeAntigo)) {
                usuarioEncontrado = user;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Erro: Usuario \"" + nomeAntigo + "\" nao encontrado!");
            return;
        }

        System.out.println("\nNome atual: " + usuarioEncontrado.getNomeUsuario());

        System.out.print("Digite o novo nome: ");
        String novoNome = scanner.nextLine().trim();

        if (novoNome.isEmpty()) {
            System.out.println("Erro: Nome nao pode ser vazio!");
            return;
        }

        for (Usuarios user : usuarios) {
            if (user.getNomeUsuario().equalsIgnoreCase(novoNome) && user != usuarioEncontrado) {
                System.out.println("Erro: Usuario \"" + novoNome + "\" ja existe!");
                return;
            }
        }

        usuarioEncontrado.setNomeUsuario(novoNome);
        System.out.println("Nome atualizado com sucesso!");
    }
}