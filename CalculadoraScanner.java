package projetos;

import java.util.Scanner;

public class CalculadoraScanner {
     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual operação você deseja?");
        String operacao = scanner.nextLine();

        System.out.println("Digite o primeiro número");
        int x = scanner.nextInt();

        System.out.println("Digite o segundo número");
        int y = scanner.nextInt();

        if(operacao.equals("somar")){
            somar(x,y);
        }else if(operacao.equals("subtrair")){
            subtrair(x,y);
        }else if(operacao.equals("multiplicar")){
            multiplicar(x,y);
        }else if(operacao.equals("dividir")){
            dividir(x,y);
        }else{
            System.out.println("Erro: Operação inválida");
        }
    }

    static void somar(int x, int y) {
        System.out.println(x + y);
    }

    static void subtrair(int x, int y) {
        System.out.println(x - y);
    }

    static void multiplicar(int x, int y) {
        System.out.println(x * y);
    }

    static void dividir(int x, int y) {
        System.out.println(x / y);
    }
}