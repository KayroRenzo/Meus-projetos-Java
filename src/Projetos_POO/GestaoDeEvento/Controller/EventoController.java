package POO.Projetos_POO.GestaoDeEventos.Controller;

import POO.Projetos_POO.GestaoDeEventos.Exceptions.DadoNaoEncontradoException;
import POO.Projetos_POO.GestaoDeEventos.Exceptions.TipoDoEventoInvalido;
import POO.Projetos_POO.GestaoDeEventos.Model.CategoriaEvento;
import POO.Projetos_POO.GestaoDeEventos.Model.Evento;
import POO.Projetos_POO.GestaoDeEventos.Model.TipoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoController {
    private Scanner scanner;
    private List<Evento> eventos;

    public EventoController() {
        this.scanner = new Scanner(System.in);
        this.eventos = new ArrayList<>();
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    private Evento buscarDadosEventoPorNome(String nomeEvento) throws DadoNaoEncontradoException {
        for (Evento evento : eventos) {
            if (evento.getTitulo().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        throw new DadoNaoEncontradoException("Evento " + nomeEvento + " não encontrado");
    }

    public void criarEvento() throws TipoDoEventoInvalido{
        System.out.println("== CRIAR EVENTO ==");
        System.out.println("Digite o titulo: ");
        String titulo = scanner.nextLine().trim();

        System.out.println("Digite o descrição: ");
        String descricao = scanner.nextLine().trim();

        System.out.println("Digite a data: ");
        String dataStr = scanner.nextLine().trim();

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataStr, formatadorData);

        if (data.isBefore(LocalDate.now())) {
            System.out.println("Não pode ser data passada.");
            return;
        }

        System.out.println("Digite o horário: ");
        String horaStr = scanner.nextLine();

        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora = LocalTime.parse(horaStr, formatadorHora);

        System.out.println("Digite o local: ");
        String local = scanner.nextLine().trim();

        System.out.println("Digite a quantidades de vagas: ");
        int quantidadeDeVagas = scanner.nextInt();
        scanner.nextLine();

        TipoEvento tipo = null;
        try {
            System.out.println("PALESTRA, WORKSHOP, CURSO, SEMINARIO, CONFERENCIA");
            System.out.println("Digite o tipo: ");
            String novoTipo = scanner.nextLine().trim();
            tipo = TipoEvento.valueOf(novoTipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TipoDoEventoInvalido();
        }

        CategoriaEvento categoria = null;
        try {
            System.out.println("TECNOLOGIA, EDUCACAO, SAUDE, NEGOCIOS, ARTES\n");
            System.out.println("Digite a categoria: ");
            String novaCategoria = scanner.nextLine().trim();
            categoria = CategoriaEvento.valueOf(novaCategoria.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Digite o valor da inscrição: ");
        double valorInscricao = scanner.nextDouble();
        scanner.nextLine();

        Evento novoEvento = new Evento(titulo, descricao, data, hora, local, quantidadeDeVagas, tipo, categoria, valorInscricao);
        eventos.add(novoEvento);
        System.out.println("Evento criado!");
    }

    public void mostrarEventos() {
        System.out.println("=== EVENTOS ===");
        if (eventos.isEmpty()) {
            System.out.println("Não há nenhum evento");
            return;
        }
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    public void procurarEventos() {
        System.out.println("=== PROCURAR EVENTO ===");
        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine().trim();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarDadosEventoPorNome(nomeEvento);
            System.out.println(eventoEncontrado);
        } catch (DadoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
    }

    public void editarEvento() {
        System.out.println("=== EDITAR EVENTO ===");

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado!");
            return;
        }

        // LISTAR EVENTOS
        System.out.println("\nEventos cadastrados:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + " - " + eventos.get(i).getTitulo() +
                    " (" + eventos.get(i).getData() + ")");
        }

        System.out.print("\nDigite o numero do evento que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > eventos.size()) {
            System.out.println("Numero invalido!");
            return;
        }

        Evento evento = eventos.get(indice - 1);

        // MOSTRAR DADOS ATUAIS
        System.out.println("\nDados atuais:");
        System.out.println(evento);

        System.out.println("\n=== O QUE DESEJA EDITAR? ===");
        System.out.println("1 - Titulo");
        System.out.println("2 - Descricao");
        System.out.println("3 - Data");
        System.out.println("4 - Horario");
        System.out.println("5 - Local");
        System.out.println("6 - Quantidade de Vagas");
        System.out.println("7 - Categoria");
        System.out.println("8 - Tipo");
        System.out.println("9 - Valor da Inscricao");
        System.out.println("0 - Cancelar");
        System.out.print("Escolha uma opcao: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo titulo: ");
                String novoTitulo = scanner.nextLine().trim();
                if (!novoTitulo.isEmpty()) {
                    evento.setTitulo(novoTitulo);
                    System.out.println("Titulo atualizado com sucesso!");
                } else {
                    System.out.println("Titulo nao pode ser vazio!");
                }
                break;

            case 2:
                System.out.print("Digite a nova descricao: ");
                String novaDescricao = scanner.nextLine().trim();
                if (!novaDescricao.isEmpty()) {
                    evento.setDescricao(novaDescricao);
                    System.out.println("Descricao atualizada com sucesso!");
                } else {
                    System.out.println("Descricao nao pode ser vazia!");
                }
                break;

            case 3:
                System.out.print("Digite a nova data (dd/MM/yyyy): ");
                String dataStr = scanner.nextLine().trim();
                if (!dataStr.isEmpty()) {
                    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate novaData = LocalDate.parse(dataStr, formatadorData);

                    if (novaData.isBefore(LocalDate.now())) {
                        System.out.println("Data nao pode ser no passado!");
                        return;
                    }
                    evento.setData(novaData);
                    System.out.println("Data atualizada com sucesso!");
                } else {
                    System.out.println("Data nao pode ser vazia!");
                }
                break;

            case 4:
                System.out.print("Digite o novo horario (HH:mm): ");
                String horarioStr = scanner.nextLine().trim();
                if (!horarioStr.isEmpty()) {
                    DateTimeFormatter formatadorHorario = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime novoHorario = LocalTime.parse(horarioStr, formatadorHorario);
                    evento.setHorario(novoHorario);
                    System.out.println("Horario atualizado com sucesso!");
                } else {
                    System.out.println("Horario nao pode ser vazio!");
                }
                break;

            case 5:
                System.out.print("Digite o novo local: ");
                String novoLocal = scanner.nextLine().trim();
                if (!novoLocal.isEmpty()) {
                    evento.setLocal(novoLocal);
                    System.out.println("Local atualizado com sucesso!");
                } else {
                    System.out.println("Local nao pode ser vazio!");
                }
                break;

            case 6:
                System.out.print("Digite a nova quantidade de vagas: ");
                int novasVagas = scanner.nextInt();
                scanner.nextLine();
                if (novasVagas >= 0) {
                    evento.setVagas(novasVagas);
                    System.out.println("Quantidade de vagas atualizada com sucesso!");
                } else {
                    System.out.println("Quantidade de vagas nao pode ser negativa!");
                }
                break;

            case 7:
                System.out.println("\nCategorias disponiveis:");
                System.out.println("TECNOLOGIA, EDUCACAO, SAUDE, NEGOCIOS, ARTES");
                System.out.print("Digite a nova categoria: ");
                String categoriaStr = scanner.nextLine().trim().toUpperCase();
                try {
                    CategoriaEvento novaCategoria = CategoriaEvento.valueOf(categoriaStr);
                    evento.setCategoria(novaCategoria);
                    System.out.println("Categoria atualizada com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Categoria invalida!");
                }
                break;

            case 8:
                System.out.println("\nTipos disponiveis:");
                System.out.println("PALESTRA, WORKSHOP, CURSO, SEMINARIO, CONFERENCIA");
                System.out.print("Digite o novo tipo: ");
                String tipoStr = scanner.nextLine().trim().toUpperCase();
                try {
                    TipoEvento novoTipo = TipoEvento.valueOf(tipoStr);
                    evento.setTipo(novoTipo);
                    System.out.println("Tipo atualizado com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo invalido!");
                }
                break;

            case 9:
                System.out.print("Digite o novo valor da inscricao: ");
                double novoValor = scanner.nextDouble();
                scanner.nextLine();
                if (novoValor >= 0) {
                    evento.setValorInscricao(novoValor);
                    System.out.println("Valor da inscricao atualizado com sucesso!");
                } else {
                    System.out.println("Valor nao pode ser negativo!");
                }
                break;

            case 0:
                System.out.println("Operacao cancelada!");
                break;

            default:
                System.out.println("Opcao invalida!");
        }
    }

    public void removerEvento() {
        System.out.println("=== REMOVER EVENTO ===");

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado!");
            return;
        }

        // LISTAR EVENTOS
        System.out.println("\nEventos cadastrados:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + " - " + eventos.get(i).getTitulo() +
                    " (" + eventos.get(i).getData() + ")");
        }

        System.out.print("\nDigite o numero do evento que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > eventos.size()) {
            System.out.println("Numero invalido!");
            return;
        }

        Evento evento = eventos.get(indice - 1);

        // CONFIRMAR REMOCAO
        System.out.println("\nEvento selecionado:");
        System.out.println(evento);

        System.out.print("\nTem certeza que deseja remover o evento '" +
                evento.getTitulo() + "'? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            eventos.remove(evento);
            System.out.println("Evento removido com sucesso!");
        } else {
            System.out.println("Operacao cancelada!");
        }
    }

    public void visualizarVagasDisponiveis() {
        System.out.println("=== VISUALIZAR VAGAS DISPONIVEIS");
        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarDadosEventoPorNome(nomeEvento);
            System.out.println("Vagas disponiveis: " + eventoEncontrado.getVagas());
        } catch (DadoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
    }

    public void listarEventosPorCategoria() {
        System.out.println("=== LISTAR EVENTOS POR CATEGORIA ===");
        System.out.println("CATEGORIA: TECNOLOGIA, EDUCACAO, SAUDE, NEGOCIOS, ARTES");
        System.out.println("Digite o nome da categoria: ");
        String categoriaStr = scanner.nextLine().trim().toUpperCase();

        try {
            CategoriaEvento categoria = CategoriaEvento.valueOf(categoriaStr);
            boolean encontrou = false;

            for (Evento evento : eventos) {
                if (evento.getCategoria() == categoria) {
                    System.out.println(evento);
                    encontrou = true;
                }
            }

            if (!encontrou) {
                System.out.println("Nenhum evento encontrado na categoria " + categoriaStr);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Categoria invalida! Use: TECNOLOGIA, EDUCACAO, SAUDE, NEGOCIOS, ARTES");
        }
    }
}