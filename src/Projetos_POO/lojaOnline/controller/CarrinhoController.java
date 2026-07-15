package POO.Projetos_POO.lojaOnline.controller;

import POO.Projetos_POO.lojaOnline.model.Carrinho;
import POO.Projetos_POO.lojaOnline.model.Produto;

import java.util.HashMap;
import java.util.Scanner;

public class CarrinhoController {
    private Scanner scanner;
    private HashMap<Integer, Carrinho> carrinho;
    private HashMap<Integer, Produto> produtos;
    private int id;

    public CarrinhoController(HashMap<Integer, Produto> produtos) {
        this.scanner = new Scanner(System.in);
        this.carrinho = new HashMap<>();
        this.produtos = produtos;
        this.id = 1;
    }

    public void adicionarNoCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos disponíveis! Cadastre um produto primeiro.");
            return;
        }

        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        for (Integer key : produtos.keySet()) {
            System.out.println("ID: " + key + " | " + produtos.get(key));
        }

        System.out.println("\nDigite o ID do produto que deseja adicionar: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();

        if (!produtos.containsKey(idProduto)) {
            System.out.println("Produto não encontrado!");
            return;
        }

        Produto produto = produtos.get(idProduto);

        if (produto.getQuantidade() <= 0) {
            System.out.println("Produto sem estoque!");
            return;
        }

        System.out.println("Quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade > produto.getQuantidade()) {
            System.out.println("Estoque insuficiente! Temos apenas " + produto.getQuantidade() + " unidades.");
            return;
        }

        if (carrinho.containsKey(idProduto)) {
            Carrinho item = carrinho.get(idProduto);
            int novaQuantidade = item.getQuantidade() + quantidade;

            if (novaQuantidade > produto.getQuantidade()) {
                System.out.println("Estoque insuficiente! Você já tem " + item.getQuantidade() +
                        " unidades no carrinho. Estoque disponível: " + produto.getQuantidade());
                return;
            }

            item.setQuantidade(novaQuantidade);
            System.out.println("Quantidade atualizada no carrinho!");
        } else {
            Carrinho novoItem = new Carrinho(
                    produto.getNome(),
                    produto.getPreco(),
                    quantidade
            );
            carrinho.put(idProduto, novoItem);
            System.out.println("Produto adicionado ao carrinho!");
        }
    }

    public void removerDoCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        visualizarCarrinho();
        System.out.println("\nDigite o ID do produto que deseja remover: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();

        if (carrinho.containsKey(idProduto)) {
            carrinho.remove(idProduto);
            System.out.println("Produto removido do carrinho!");
        } else {
            System.out.println("Produto não encontrado no carrinho!");
        }
    }

    public void visualizarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("\nCarrinho vazio!");
            return;
        }

        System.out.println("\n=== SEU CARRINHO ===");
        double total = 0;
        for (Integer id : carrinho.keySet()) {
            Carrinho item = carrinho.get(id);
            System.out.println("ID: " + id + " | " + item);
            total += item.calcularSubtotal();
        }
        System.out.println("-----------------------------------");
        System.out.printf("TOTAL: R$%.2f%n", total);
    }

    public void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        visualizarCarrinho();
        System.out.println("\nConfirmar compra? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            // Baixa o estoque dos produtos
            for (Integer idProduto : carrinho.keySet()) {
                Carrinho item = carrinho.get(idProduto);
                Produto produto = produtos.get(idProduto);

                if (produto != null) {
                    int novoEstoque = produto.getQuantidade() - item.getQuantidade();
                    produto.setQuantidade(novoEstoque);
                }
            }

            System.out.println("Compra finalizada com sucesso!");
            carrinho.clear();
        } else {
            System.out.println("Compra cancelada!");
        }
    }

    public void menuCarrinho() {
        int opcao;
        do {
            System.out.println("\n=== MENU CARRINHO ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Visualizar carrinho");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarNoCarrinho();
                    break;
                case 2:
                    removerDoCarrinho();
                    break;
                case 3:
                    visualizarCarrinho();
                    break;
                case 4:
                    finalizarCompra();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
}