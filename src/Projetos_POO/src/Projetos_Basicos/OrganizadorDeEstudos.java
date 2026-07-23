package projetos;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizadorDeEstudos {
    public static void main(String[] args) {
        ArrayList<String> materias = new ArrayList<>();
        ArrayList<String> dias = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int opcao;

        System.out.println("== ORGANIZADOR DE ESTUDOS ==");

        while (true) {
            System.out.println("\n1 - Adicionar materia");
            System.out.println("2 - Adicionar dia da semana");
            System.out.println("3 - Ver dias estudados");
            System.out.println("4 - Ver percentual de conclusao");
            System.out.println("5 - Editar status do dia");
            System.out.println("6 - Sair do sistema");
            System.out.print("Escolha uma opcao: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRAR MATERIA ===");
                    System.out.print("Digite a materia: ");
                    String materia = input.nextLine();
                    materias.add(materia);
                    System.out.println("Materia cadastrada!");
                    break;

                case 2:
                    System.out.println("\n=== CADASTRAR DIA ===");
                    System.out.print("Digite o Dia: ");
                    String dia = input.nextLine();
                    dias.add(dia);
                    status.add("Pendente");
                    System.out.println("Dia cadastrado!");
                    break;

                case 3:
                    System.out.println("\n=== DIAS CADASTRADOS ===");
                    if (dias.isEmpty()) {
                        System.out.println("Nenhum dia cadastrado!");
                    } else {
                        System.out.println("POSICAO - DIA - STATUS");
                        for (int i = 0; i < dias.size(); i++) {
                            System.out.println(i + " - " + dias.get(i) + " - " + status.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== PERCENTUAL DE CONCLUSAO ===");
                    if (dias.isEmpty()) {
                        System.out.println("Nenhum dia cadastrado!");
                    } else {
                        int pendentes = 0;
                        for (int i = 0; i < status.size(); i++) {
                            if (status.get(i).equals("Pendente")) {
                                pendentes++;
                            }
                        }
                        int totalDias = status.size();
                        int concluidos = totalDias - pendentes;
                        double percentualConclusao = (concluidos * 100.0) / totalDias;
                        System.out.println("Dias pendentes: " + pendentes);
                        System.out.println("Percentual de conclusao: " + percentualConclusao + "%");
                    }
                    break;

                case 5:
                    System.out.println("\n=== EDITAR STATUS ===");
                    if (dias.isEmpty()) {
                        System.out.println("Nenhum dia cadastrado!");
                    } else {
                        System.out.println("Dias pendentes:");
                        for (int i = 0; i < dias.size(); i++) {
                            if (status.get(i).equals("Pendente")) {
                                System.out.println(i + " - " + dias.get(i));
                            }
                        }

                        System.out.print("Digite a posicao do dia: ");
                        int posicao = input.nextInt();
                        input.nextLine();

                        if (posicao >= 0 && posicao < dias.size()) {
                            if (status.get(posicao).equals("Pendente")) {
                                status.set(posicao, "Concluido");
                                System.out.println("Dia marcado como concluido!");
                            } else {
                                System.out.println("Esse dia ja foi concluido!");
                            }
                        } else {
                            System.out.println("Posicao invalida!");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    input.close();
                    return;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}
