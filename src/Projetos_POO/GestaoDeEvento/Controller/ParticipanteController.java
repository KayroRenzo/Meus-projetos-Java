package POO.Projetos_POO.GestaoDeEventos.Controller;

import POO.Projetos_POO.GestaoDeEventos.Exceptions.ParticipanteNaoEncontradoException;
import POO.Projetos_POO.GestaoDeEventos.Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParticipanteController {
    private Scanner scanner;
    private List<Participante> participantes;

    public ParticipanteController() {
        this.scanner = new Scanner(System.in);
        this.participantes = new ArrayList<>();
    }

    private Participante buscarParticipantePorNome(String nomeParticipante) throws ParticipanteNaoEncontradoException {
        for (Participante participante : participantes) {
            if (participante.getNome().equalsIgnoreCase(nomeParticipante)) {
                return participante;
            }
        }
        throw new ParticipanteNaoEncontradoException("Participante '" + nomeParticipante + "' não encontrado!");
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void cadastrarParticipante() {
        System.out.println("== CADASTRAR PARTICIPANTE ==");

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio");
            return;
        }

        System.out.println("Digite o email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            System.out.println("Email não pode ser vazio");
            return;
        }

        System.out.println("Digite o telefone: ");
        String telefone = scanner.nextLine().trim();
        if (telefone.isEmpty()) {
            System.out.println("Telefone não pode ser vazio");
            return;
        }

        // MOSTRAR MENU DE TIPOS
        System.out.println("\n=== TIPOS DE PARTICIPANTE ===");
        System.out.println("1 - INDIVIDUAL");
        System.out.println("2 - EMPRESA");
        System.out.println("3 - ESTUDANTE");
        System.out.println("4 - PALESTRANTE");
        System.out.println("5 - VIP");
        System.out.println("0 - CANCELAR");
        System.out.print("Digite a opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        Participante participante = null;

        switch (opcao) {
            case 1:
                System.out.print("Digite o seu CPF: ");
                String cpfIndividual = scanner.nextLine().trim();

                System.out.print("Digite a sua data de nascimento (dd/MM/yyyy): ");
                String dataStr = scanner.nextLine().trim();

                DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(dataStr, formatarData);

                participante = new ParticipanteIndividual(nome, email, telefone, TipoParticipante.INDIVIDUAL, cpfIndividual, data);
                break;

            case 2:
                System.out.print("Digite o nome da empresa: ");
                String nomeEmpresa = scanner.nextLine().trim();

                System.out.print("Digite o nome do(a) representante: ");
                String nomeRepresentante = scanner.nextLine().trim();

                System.out.print("Digite o CNPJ: ");
                String cnpj = scanner.nextLine().trim();

                System.out.print("Digite o cargo: ");
                String cargo = scanner.nextLine().trim();

                System.out.print("Digite a quantidade de funcionários: ");
                int quantidadeDeFuncionarios = scanner.nextInt();
                scanner.nextLine();

                participante = new ParticipanteEmpresa(nome, email, telefone, TipoParticipante.EMPRESA, cnpj, nomeEmpresa, nomeRepresentante, cargo, quantidadeDeFuncionarios);
                break;

            case 3:
                System.out.print("Digite o nome da instituição de ensino: ");
                String nomeInstituicao = scanner.nextLine().trim();

                System.out.print("Digite a sua série: ");
                String serie = scanner.nextLine().trim();

                System.out.print("Digite a sua idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o seu CPF: ");
                String cpfEstudante = scanner.nextLine().trim();

                participante = new ParticipanteEstudante(nome, email, telefone, TipoParticipante.ESTUDANTE, nomeInstituicao, serie, idade, cpfEstudante);
                break;

            case 4:
                System.out.print("Digite sua especialidade: ");
                String especialidade = scanner.nextLine().trim();

                System.out.print("Digite o título da palestra: ");
                String tituloPalestra = scanner.nextLine().trim();

                System.out.print("Digite o resumo do seu currículo: ");
                String curriculo = scanner.nextLine().trim();

                System.out.print("Digite o nome do evento: ");
                String nomeEvento = scanner.nextLine().trim();

                participante = new Palestrante(nome, email, telefone, TipoParticipante.PALESTRANTE, especialidade, tituloPalestra, curriculo, nomeEvento);
                break;

            case 5:
                System.out.print("Digite o nome da empresa parceira: ");
                String empresaParceira = scanner.nextLine().trim();

                participante = new ParticipanteVip(nome, email, telefone, TipoParticipante.VIP, empresaParceira);
                break;

            case 0:
                System.out.println("Operação cancelada!");
                return;

            default:
                System.out.println("Opção inválida! Digite alguma dessas opções.");
        }

        participantes.add(participante);
        System.out.println("Participante cadastrado com sucesso!");
    }

    public void listarParticipantes() {
        System.out.println("=== LISTA DE PARTICIPANTES ===");

        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado");
            return;
        }

        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    public void buscarParticipantes() {
        System.out.println("Digite o nome do participante: ");
        boolean encontrado = false;
        String nomeParticipante = scanner.nextLine().trim();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
            System.out.println(participanteEncontrado);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            System.out.println("Nenhum participante encontrado!");
            return;
        }
    }

    public void editarParticipante() {
        System.out.println("=== EDITAR PARTICIPANTE ===");

        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado!");
            return;
        }

        // LISTAR PARTICIPANTES
        System.out.println("\nParticipantes cadastrados:");
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println((i + 1) + " - " + participantes.get(i).getNome() + " (" + participantes.get(i).getTipo() + ")");
        }

        System.out.print("\nDigite o numero do participante que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > participantes.size()) {
            System.out.println("Numero inválido");
            return;
        }

        Participante participante = participantes.get(indice - 1);

        // MOSTRAR DADOS ATUAIS
        System.out.println("\nDados atuais:");
        System.out.println(participante);

        System.out.println("\n=== O QUE DESEJA EDITAR? ===");
        System.out.println("1 - Nome");
        System.out.println("2 - Email");
        System.out.println("3 - Telefone");
        System.out.println("4 - Tipo de Participante");
        System.out.println("0 - Cancelar");
        System.out.print("Escolha uma opcao: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine().trim();
                if (!novoNome.isEmpty()) {
                    participante.setNome(novoNome);
                    System.out.println("Nome atualizado com sucesso!");
                } else {
                    System.out.println("Nome nao pode ser vazio!");
                    return;
                }
                break;

            case 2:
                System.out.print("Digite o novo email: ");
                String novoEmail = scanner.nextLine().trim();
                if (!novoEmail.isEmpty()) {
                    participante.setEmail(novoEmail);
                    System.out.println("Email atualizado com sucesso!");
                } else {
                    System.out.println("Email nao pode ser vazio!");
                    return;
                }
                break;

            case 3:
                System.out.print("Digite o novo telefone: ");
                String novoTelefone = scanner.nextLine().trim();
                if (!novoTelefone.isEmpty()) {
                    participante.setTelefone(novoTelefone);
                    System.out.println("Telefone atualizado com sucesso!");
                } else {
                    System.out.println("Telefone nao pode ser vazio!");
                    return;
                }
                break;

            case 4:
                System.out.println("\n=== EDITAR TIPO DO PARTICIPANTE ===");
                System.out.println("Tipo atual: " + participante.getTipo());
                System.out.println("1 - INDIVIDUAL");
                System.out.println("2 - EMPRESA");
                System.out.println("3 - ESTUDANTE");
                System.out.println("4 - PALESTRANTE");
                System.out.println("5 - VIP");
                System.out.print("Digite o novo tipo: ");

                int novoTipoOpcao = scanner.nextInt();
                scanner.nextLine();

                TipoParticipante novoTipo = null;
                switch (novoTipoOpcao) {
                    case 1:
                        novoTipo = TipoParticipante.INDIVIDUAL;
                        break;
                    case 2:
                        novoTipo = TipoParticipante.EMPRESA;
                        break;
                    case 3:
                        novoTipo = TipoParticipante.ESTUDANTE;
                        break;
                    case 4:
                        novoTipo = TipoParticipante.PALESTRANTE;
                        break;
                    case 5:
                        novoTipo = TipoParticipante.VIP;
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        return;
                }

                if (participante.getTipo() == novoTipo) {
                    System.out.println("O participante ja e deste tipo!");
                    return;
                }

                System.out.print("Deseja continuar? (S/N): ");
                String confirmacao = scanner.nextLine();

                if (!confirmacao.equalsIgnoreCase("S")) {
                    System.out.println("Operação cancelada!");
                    return;
                }

                // Criar novo participante com o novo tipo
                Participante novoParticipante = null;

                switch (novoTipoOpcao) {
                    case 1:
                        System.out.print("Digite o CPF: ");
                        String cpfIndividual = scanner.nextLine();
                        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                        String dataStr = scanner.nextLine();
                        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate data = LocalDate.parse(dataStr, formatarData);
                        novoParticipante = new ParticipanteIndividual(participante.getNome(), participante.getEmail(), participante.getTelefone(), novoTipo, cpfIndividual, data);
                        break;

                    case 2:
                        System.out.print("Digite o CNPJ: ");
                        String cnpj = scanner.nextLine();
                        System.out.print("Digite o nome da empresa: ");
                        String nomeEmpresa = scanner.nextLine();
                        System.out.print("Digite o nome do representante: ");
                        String representante = scanner.nextLine();
                        System.out.print("Digite o cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Digite a quantidade de funcionarios: ");
                        int qtdFuncionarios = scanner.nextInt();
                        scanner.nextLine();
                        novoParticipante = new ParticipanteEmpresa(participante.getNome(), participante.getEmail(), participante.getTelefone(), novoTipo, cnpj, nomeEmpresa, representante, cargo, qtdFuncionarios);
                        break;

                    case 3:
                        System.out.print("Digite o nome da instituicao: ");
                        String instituicao = scanner.nextLine();
                        System.out.print("Digite a serie: ");
                        String serie = scanner.nextLine();
                        System.out.print("Digite a idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpfEstudante = scanner.nextLine();
                        novoParticipante = new ParticipanteEstudante(participante.getNome(), participante.getEmail(), participante.getTelefone(), novoTipo, instituicao, serie, idade, cpfEstudante);
                        break;

                    case 4:
                        System.out.print("Digite a especialidade: ");
                        String especialidade = scanner.nextLine();
                        System.out.print("Digite o titulo da palestra: ");
                        String tituloPalestra = scanner.nextLine();
                        System.out.print("Digite o curriculo: ");
                        String curriculo = scanner.nextLine();
                        System.out.print("Digite o nome do evento: ");
                        String nomeEvento = scanner.nextLine();
                        novoParticipante = new Palestrante(participante.getNome(), participante.getEmail(), participante.getTelefone(), novoTipo, especialidade, tituloPalestra, curriculo, nomeEvento);
                        break;

                    case 5:
                        System.out.print("Digite a empresa parceira: ");
                        String empresaParceira = scanner.nextLine();
                        novoParticipante = new ParticipanteVip(participante.getNome(), participante.getEmail(), participante.getTelefone(), novoTipo, empresaParceira);
                        break;
                }

                int index = participantes.indexOf(participante);
                participantes.set(index, novoParticipante);
                System.out.println("Tipo do participante atualizado com sucesso!");

                break;

            case 0:
                System.out.println("Operacao cancelada!");
                break;

            default:
                System.out.println("Opcao invalida!");
        }
    }

    public void excluirParticipante() {
        System.out.println("=== EXCLUIR PARTICIPANTE ===");

        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante encontrado");
            return;
        }

        // LISTAR PARTICIPANTES
        System.out.println("\nParticipantes cadastrados:");
        for (Participante p : participantes) {
            System.out.println("ID: " + p.getId() + " - Nome: " + p.getNome() + " (" + p.getTipo() + ")");
        }

        // PEDIR O ID UMA VEZ SÓ
        System.out.print("\nDigite o ID do participante que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // BUSCAR O PARTICIPANTE PELO ID
        Participante participanteEncontrado = null;
        for (Participante p : participantes) {
            if (p.getId() == id) {
                participanteEncontrado = p;
                break;
            }
        }

        if (participanteEncontrado == null) {
            System.out.println("Participante nao encontrado!");
            return;
        }

        // CONFIRMAR EXCLUSÃO
        System.out.print("Tem certeza que deseja excluir o participante '" + participanteEncontrado.getNome() + "'? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            participantes.remove(participanteEncontrado);
            System.out.println("Participante excluido com sucesso!");
        } else {
            System.out.println("Operacao cancelada!");
        }
    }

    public void listarParticipantePorTipo() {
        System.out.println("=== LISTAR PARTICIPANTE POR TIPO ===");
        System.out.println("INDIVIDUAL, EMPRESA, ESTUDANTE, PALESTRANTE, VIP");
        System.out.println("Digite o tipo do participante: ");
        String tipo = scanner.nextLine().toUpperCase().trim();

        if (tipo.isEmpty()) {
            System.out.println("Digite alguma das opções");
            return;
        }

        boolean encontrou = false;

        switch (tipo) {
            case "INDIVIDUAL" -> {
                System.out.println("\n=== PARTICIPANTES INDIVIDUAIS ===");
                for (Participante p : participantes) {
                    if (p.getTipo() == TipoParticipante.INDIVIDUAL) {
                        System.out.println(p);
                        encontrou = true;
                    }
                }
            }
            case "EMPRESA" -> {
                System.out.println("\n=== PARTICIPANTES EMPRESAS ===");
                for (Participante p : participantes) {
                    if (p.getTipo() == TipoParticipante.EMPRESA) {
                        System.out.println(p);
                        encontrou = true;
                    }
                }
            }
            case "ESTUDANTE" -> {
                System.out.println("\n=== PARTICIPANTES ESTUDANTES ===");
                for (Participante p : participantes) {
                    if (p.getTipo() == TipoParticipante.ESTUDANTE) {
                        System.out.println(p);
                        encontrou = true;
                    }
                }
            }
            case "PALESTRANTE" -> {
                System.out.println("\n=== PARTICIPANTES PALESTRANTES ===");
                for (Participante p : participantes) {
                    if (p.getTipo() == TipoParticipante.PALESTRANTE) {
                        System.out.println(p);
                        encontrou = true;
                    }
                }
            }
            case "VIP" -> {
                System.out.println("\n=== PARTICIPANTES VIP ===");
                for (Participante p : participantes) {
                    if (p.getTipo() == TipoParticipante.VIP) {
                        System.out.println(p);
                        encontrou = true;
                    }
                }
            }
            default -> {
                System.out.println("Tipo inválido!");
                return;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum participante encontrado com o tipo " + tipo);
            return;
        }
    }
}