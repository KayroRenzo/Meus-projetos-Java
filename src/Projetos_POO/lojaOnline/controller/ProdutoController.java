package POO.Projetos_POO.lojaOnline.controller;

import POO.Projetos_POO.lojaOnline.model.Produto;

import java.util.HashMap;
import java.util.Scanner;

public class ProdutoController {
    private Scanner scanner;
    private HashMap<Integer, Produto> produtos;

    public ProdutoController() {
        this.scanner = new Scanner(System.in);
        this.produtos = new HashMap<>();
    }

    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto() {
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a quantidade de produto no estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        int id = produtos.size() + 1;
        Produto produto = new Produto(nome, preco, quantidade);
        produtos.put(id, produto);
        System.out.println("Produto adicionado!");
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados");
            return;
        } else {
            for (Produto p : produtos.values()) {
                System.out.println(p);
            }
        }
    }

    public void procurarProdutos() {
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (Produto p : produtos.values()) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Produto encontrado: " + p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
        }
    }

    public void procurarEDeletar() {
        System.out.println("Digite o nome do produto que deseja excluir: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (int id : produtos.keySet()) {
            Produto p = produtos.get(id);

            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Produto encontrado!");
                System.out.println("ID: " + id + " | " + p);
                System.out.println("---");

                System.out.println("Deseja excluir este produto? (S/N)");
                String confirmacao = scanner.nextLine();

                if (confirmacao.equalsIgnoreCase("S")) {
                    produtos.remove(id);
                    System.out.println("Produto removido com sucesso!");
                } else {
                    System.out.println("Exclusão cancelada!");
                }

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto com nome '" + nome + "' não encontrado!");
        }
    }

    public void editarProduto() {
        System.out.println("Digite o ID do produto que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (produtos.containsKey(id)) {
            Produto produto = produtos.get(id);

            System.out.println("Produto atual: " + produto);
            System.out.println("---");

            System.out.println("Digite o novo nome (ou pressione Enter para manter): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                produto.setNome(nome);
            }

            System.out.println("Digite o novo preço (ou 0 para manter): ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            if (preco > 0) {
                produto.setPreco(preco);
            }

            System.out.println("Digite a nova quantidade (ou -1 para manter): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            if (quantidade >= 0) {
                produto.setQuantidade(quantidade);
            }

            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado!");
        }
    }
}