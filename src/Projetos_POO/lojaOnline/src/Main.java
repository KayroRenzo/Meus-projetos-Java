package POO.Projetos_POO.lojaOnline.src;

import POO.Projetos_POO.lojaOnline.controller.CarrinhoController;
import POO.Projetos_POO.lojaOnline.controller.ProdutoController;
import POO.Projetos_POO.lojaOnline.view.CarrinhoView;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        CarrinhoController carrinhoController = new CarrinhoController(produtoController.getProdutos());

        CarrinhoView view = new CarrinhoView(carrinhoController, produtoController);
        view.exibirMenuPrincipal();
    }
}