package POO.Projetos_POO.sistemaBancario.controller;

import POO.Projetos_POO.sistemaBancario.model.UserModel;
import java.util.Scanner;

public class UserController {
    private Scanner scanner;

    public UserController(){
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarName(){
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();

        UserModel user = new UserModel(name);
        System.out.println("Conta criada com sucesso.");
    }
}