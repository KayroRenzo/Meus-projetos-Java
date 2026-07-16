package POO.Projetos_POO.miniCrm.src;

import POO.Projetos_POO.miniCrm.controller.ClienteController;
import POO.Projetos_POO.miniCrm.view.ClienteView;

public class Main {
    public static void main(String[] args) {
        ClienteController controller = new ClienteController();
        ClienteView view = new ClienteView(controller);
        view.iniciarCrm();
    }
}