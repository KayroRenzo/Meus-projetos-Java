package POO.Projetos_POO.lojaOnline.view;

import POO.Projetos_POO.lojaOnline.controller.CarrinhoController;
import POO.Projetos_POO.lojaOnline.controller.ProdutoController;

import java.util.Scanner;

public class CarrinhoView {
    private Scanner scanner;
    private CarrinhoController carrinhoController;
    private ProdutoController produtoController;

    public CarrinhoView(CarrinhoController carrinhoController, ProdutoController produtoController) {
        this.scanner = new Scanner(System.in);
        this.carrinhoController = carrinhoController;
        this.produtoController = produtoController;
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA LOJA ONLINE ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Carrinho");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirMenuProdutos();
                    break;
                case 2:
                    exibirMenuCarrinho();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    private void exibirMenuProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Procurar produto");
            System.out.println("4. Editar produto");
            System.out.println("5. Excluir produto");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    produtoController.adicionarProduto();
                    break;
                case 2:
                    produtoController.exibirProdutos();
                    break;
                case 3:
                    produtoController.procurarProdutos();
                    break;
                case 4:
                    produtoController.editarProduto();
                    break;
                case 5:
                    produtoController.procurarEDeletar();
                    break;
                case 6:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void exibirMenuCarrinho() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CARRINHO ===");
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Remover produto do carrinho");
            System.out.println("3. Visualizar carrinho");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    carrinhoController.adicionarNoCarrinho();
                    break;
                case 2:
                    carrinhoController.removerDoCarrinho();
                    break;
                case 3:
                    carrinhoController.visualizarCarrinho();
                    break;
                case 4:
                    carrinhoController.finalizarCompra();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        } while (opcao != 5);
    }
}