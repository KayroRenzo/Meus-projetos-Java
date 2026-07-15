package POO.Projetos_POO.sistemaBancario.controller;

import POO.Projetos_POO.sistemaBancario.Exceptions.SaldoInsuficiente;
import POO.Projetos_POO.sistemaBancario.model.BancoModel;
import java.util.Scanner;

public class BancoController {
    private Scanner scanner;
    private BancoModel banco;

    public BancoController() {
        this.scanner = new Scanner(System.in);
        this.banco = new BancoModel(1000.0);
    }

    public void depositar() {
        System.out.println("Digite o valor do seu deposito: ");
        double valor = scanner.nextDouble();
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");

        double novoSaldo = banco.getSaldo() + valor;
        banco.setSaldo(novoSaldo);
        System.out.println("Deposito feito com sucesso!");
    }

    public void sacar() {
        System.out.println("Digite o valor do seu saque: ");
        double valor = scanner.nextDouble();
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > banco.getSaldo()) {
            throw new SaldoInsuficiente("Valor insuficiente, seu saldo é: " + banco.getSaldo());
        }
        double novoSaldo = banco.getSaldo() - valor;
        banco.setSaldo(novoSaldo);
        System.out.println("Saque realizado com sucesso!");
    }

    public void verSaldo() {
        System.out.println("Seu saldo atual é: " + banco.getSaldo());
    }
}