package POO.Projetos_POO.miniCrm.controller;

import POO.Projetos_POO.miniCrm.model.Cliente;
import POO.Projetos_POO.miniCrm.model.Interacao;
import POO.Projetos_POO.miniCrm.model.StatusCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteController {
    private Scanner scanner;
    private ArrayList<Cliente> clientes;

    public ClienteController() {
        this.scanner = new Scanner(System.in);
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente() {
        boolean valido = true;
        System.out.println("=== CADASTRO DE CLIENTES ===");
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Campo vazio! Digite algo");
            valido = false;
        }

        System.out.println("Digite o email: ");
        String email = scanner.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Campo vazio! Digite algo");
            valido = false;
        }

        //Verifica se tem o @ ou o ., se n tiver vai ser inválido
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email inválido");
            valido = false;
        }

        System.out.println("Digite o telefone: ");
        String telefone = scanner.nextLine().trim();

        if (telefone.isEmpty()) {
            System.out.println("Campo vazio! Digite algo");
            valido = false;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome já cadastrado");
                valido = false;
            }
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email já cadastrado");
                valido = false;
            }
            if (cliente.getTelefone().equals(telefone)) {
                System.out.println("Telefone já cadastrado");
                valido = false;
            }
        }

        if (valido) {
            Cliente cliente = new Cliente(nome, email, telefone);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
        } else {
            System.out.println("Cadastro cancelado devido a erros.");
        }
    }

    public void listarClientes() {
        System.out.println("=== LISTA DE TODOS OS CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarClienteEmNegociacao() {
        System.out.println("=== LISTA DE CLIENTES EM NEGOCIAÇÃO ===");
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getStatus() == StatusCliente.NEGOCIACAO) {
                System.out.println(cliente.getNome());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum cliente em Negociação");
        }
    }

    public void registrarInteracao() {
        System.out.println("=== REGISTRAR INTERAÇÃO COM O CLIENTE ===");
        boolean encontrado = false;
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine().trim();


        if (nomeCliente.isEmpty()) {
            System.out.println("Campo vazio! Digite algo");
            return;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Cliente encontrado! O que aconteceu? ");
                String descricao = scanner.nextLine();

                Interacao interacao = new Interacao(descricao);
                cliente.getInteracao().add(interacao);

                System.out.println("Interação registrada");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado");
            return;
        }
    }

    public void listarInteracao() {
        System.out.println("=== LISTA DE INTERAÇÃO ===");
        boolean encontrado = false;
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                for (Interacao interacao : cliente.getInteracao()) {
                    System.out.println("Interação: ");
                    System.out.println(interacao);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado");
            return;
        }
    }

    public void trocarStatus() {
        System.out.println("=== TROCAR STATUS DO CLIENTE ===");
        boolean encontrado = false;
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Cliente encontrado! Qual status deseja mudar? ");
                System.out.println("PROSPECTO, NEGOCIACAO, CLIENTE, INATIVO, PERDIDO");
                String statusDigitado = scanner.nextLine().toUpperCase();

                try {
                    //Vai converter o texto em enum
                    StatusCliente novoStatus = StatusCliente.valueOf(statusDigitado);
                    cliente.setStatus(novoStatus);
                    System.out.println("Status alterado para: " + novoStatus);
                    encontrado = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Status inválido!");
                }
            }
        }
        if (!encontrado) {
            System.out.println("Cliente não encontrado");
            return;
        }
    }

    public void adicionarAcao() {
        System.out.println("=== ADICIONAR AÇÃO ===");
        boolean encontrado = false;
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("O que precisa fazer? ");
        String proximaAcao = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                cliente.setProximaAcao(proximaAcao);
                encontrado = true;
                System.out.println("Ação adicionada com sucesso!");
            }
        }
        if (!encontrado) {
            System.out.println("Cliente não encontrado");
            return;
        }
    }

    public void mostrarAcoes() {
        boolean temAcao = false;

        for (Cliente cliente : clientes) {
            if (cliente.getProximaAcao() != null) {
                System.out.println(cliente.getNome() + " - " + cliente.getProximaAcao());
                temAcao = true;
            }
        }

        if (!temAcao) {
            System.out.println("Nenhuma ação pendente.");
        }
    }
}