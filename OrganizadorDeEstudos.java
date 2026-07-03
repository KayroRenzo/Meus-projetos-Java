package projetos;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizadorDeEstudos {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> dia_status = new ArrayList<>();
        ArrayList<String> materias = new ArrayList<>();
        ArrayList<String> dia = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("== ORGANIZADOR DE ESTUDOS ==");
            System.out.println("1 - Adicionar matéria");
            System.out.println("2 - Adicionar dia da semana");
            System.out.println("3 - Ver dias estudados");
            System.out.println("4 - Ver percentual de conclusão");
            System.out.println("5 - Editar status do dia");
            System.out.println("6 - Sair do sistema");
            System.out.println("Escola uma opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("=== CADASTRAR MATÉRIA ===");
                    System.out.println("Digite a matéria: ");
                    String materia = input.nextLine();
                    materias.add(materia);
                    System.out.println("Matéria cadastrada");
                    break;

                case 2:
                    System.out.println("=== CADASTRAR DIA ===");
                    System.out.println("Digite o Dia: ");
                    String diaDaSemana = input.nextLine();
                    dia.add(diaDaSemana);
                    status.add("Pendente");
                    System.out.println("Dia cadastrado");
                    break;

                case 3:
                    System.out.println("=== DIAS CADASTRADOS ===");
                    System.out.println("POSIÇÃO - DIA - STATUS");
                    for (int i = 0; i < dia.size(); i++) {
                        System.out.println(i + " - " + dia.get(i) + " - " + status.get(i));
                    }
                    break;

                case 4:
                    System.out.println("=== PERCENTUAL DE CONCLUSÃO ===");
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
                    System.out.println("Percentual de conclusão: " + percentualConclusao + "%");

                case 5:
                    System.out.println("=== EDITAR STATUS ===");
                    for (int i = 0; i < dia.size(); i++) {
                        if (status.get(i).equals("Pendente")) {
                            System.out.println(i + " - " + dia.get(i));
                        }
                    }

                    System.out.println("Digite a posição do dia: ");
                    int posicao = input.nextInt();
                    input.nextLine();

                    status.set(posicao, "Concluido");
                    System.out.println("Dia marcado como concluido");
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    input.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}