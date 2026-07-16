package POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.controller;

import POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model.Categoria;
import POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model.Prioridade;
import POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model.Status;
import POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model.Tarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TarefaController {
    private Scanner scanner;
    private ArrayList<Tarefa> tarefas;

    public TarefaController() {
        this.scanner = new Scanner(System.in);
        this.tarefas = new ArrayList<>();
    }

    public void listarTarefas() {
        System.out.println("=== LISTA DE TAREFAS ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa!");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void adicionarTarefa() {
        System.out.println("=== ADICIONAR TAREFA ===");
        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite a Data da sua tarefa: (dd/MM/yyyy)");
        String dataStr = scanner.nextLine();

        System.out.println("Digite a hora da sua tarefa: (HH:mm)");
        String horaStr = scanner.nextLine();

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate data = LocalDate.parse(dataStr, formatadorData);
        LocalTime hora = LocalTime.parse(horaStr, formatadorHora);

        LocalDateTime prazo = LocalDateTime.of(data, hora);

        System.out.println("Digite a categoria da tarefa: ");
        String categoria = scanner.nextLine();

        System.out.println("=== LISTA DE PRIORIDADES ===");
        System.out.println("BAIXA, MEDIA, ALTA, URGENTE");
        System.out.println("Digite a prioridade da tarefa: ");
        String prioridadeStr = scanner.nextLine();
        Prioridade novaPrioridade = Prioridade.valueOf(prioridadeStr.toUpperCase());

        Tarefa novaTarefa = new Tarefa(titulo, descricao, prazo, novaPrioridade, categoria);
        tarefas.add(novaTarefa);

        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void atualizarTarefa() {
        System.out.println("=== ATUALIZAR TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Tarefa encontrada: " + tarefa.getTitulo());
        System.out.println("1 - TITULO");
        System.out.println("2 - DESCRIÇÃO");
        System.out.println("3 - DATA/HORA");
        System.out.println("4 - CATEGORIA");
        System.out.println("5 - PRIORIDADE");
        System.out.println("6 - STATUS");
        System.out.println("0 - CANCELAR");
        System.out.println("Qual campo deseja editar? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo titulo: ");
                String novoTitulo = scanner.nextLine();
                tarefa.setTitulo(novoTitulo);
                System.out.println("Titulo atualizado com sucesso!");
                break;
            case 2:
                System.out.println("Digite a nova descrição: ");
                String novaDescricao = scanner.nextLine();
                tarefa.setDescricao(novaDescricao);
                System.out.println("Descrição atualizada com sucesso!");
                break;
            case 3:
                System.out.println("Digite a nova data: (dd/MM/yyyy)");
                String dataStr = scanner.nextLine();

                System.out.println("Digite a nova hora: (HH:mm)");
                String horaStr = scanner.nextLine();

                DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");

                LocalDate data = LocalDate.parse(dataStr, formatadorData);
                LocalTime hora = LocalTime.parse(horaStr, formatadorHora);

                LocalDateTime novoPrazo = LocalDateTime.of(data, hora);
                tarefa.setPrazo(novoPrazo);
                System.out.println("Data/Hora atualizada com sucesso!");
                break;
            case 4:
                System.out.println("Digite a nova categoria: ");
                String novaCategoria = scanner.nextLine();
                tarefa.setCategoria(new Categoria(novaCategoria));
                System.out.println("Categoria atualizada com sucesso!");
                break;
            case 5:
                System.out.println("=== PRIORIDADES DISPONIVEIS ===");
                System.out.println("BAIXA, MEDIA, ALTA, URGENTE");
                System.out.println("Digite a nova prioridade: ");
                String prioridadeStr = scanner.nextLine().toUpperCase();
                Prioridade novaPrioridade = Prioridade.valueOf(prioridadeStr);
                tarefa.setPrioridade(novaPrioridade);
                System.out.println("Prioridade atualizada com sucesso!");
                break;
            case 6:
                System.out.println("=== STATUS DISPONIVEIS ===");
                System.out.println("PENDENTE, EM_ANDAMENTO, BLOQUEADA, CONCLUIDA, CANCELADA");
                System.out.println("Digite o novo status: ");
                String statusStr = scanner.nextLine().toUpperCase();
                Status novoStatus = Status.valueOf(statusStr);
                tarefa.setStatus(novoStatus);
                System.out.println("Status atualizado com sucesso!");
                break;
            case 0:
                System.out.println("Operação cancelada!");
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }

    public void removerTarefa() {
        System.out.println("=== REMOVER TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa que deseja remover: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Tem certeza que deseja remover a tarefa: " + tarefa.getTitulo() + "? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            tarefas.remove(tarefa);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Operação cancelada!");
        }
    }

    public void buscarPorId() {
        System.out.println("=== BUSCAR TAREFA POR ID ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o ID da tarefa: ");
        long id = Long.parseLong(scanner.nextLine());

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        exibirTarefa(tarefa);
    }

    // ===== 2. GERENCIAMENTO DE STATUS =====
    public void iniciarTarefa() {
        System.out.println("=== INICIAR TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        if (tarefa.getStatus() == Status.PENDENTE) {
            tarefa.setStatus(Status.EM_ANDAMENTO);
            System.out.println("Tarefa iniciada com sucesso!");
        } else {
            System.out.println("Apenas tarefas PENDENTES podem ser iniciadas!");
        }
    }

    public void concluirTarefa() {
        System.out.println("=== CONCLUIR TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        if (tarefa.getStatus() == Status.EM_ANDAMENTO) {
            tarefa.setStatus(Status.CONCLUIDA);
            tarefa.setDataConclusao(LocalDateTime.now());
            System.out.println("Tarefa concluida com sucesso!");
        } else {
            System.out.println("Apenas tarefas EM_ANDAMENTO podem ser concluidas!");
        }
    }

    public void bloquearTarefa() {
        System.out.println("=== BLOQUEAR TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        if (tarefa.getStatus() == Status.EM_ANDAMENTO) {
            tarefa.setStatus(Status.BLOQUEADA);
            System.out.println("Tarefa bloqueada com sucesso!");
        } else {
            System.out.println("Apenas tarefas EM_ANDAMENTO podem ser bloqueadas!");
        }
    }

    public void cancelarTarefa() {
        System.out.println("=== CANCELAR TAREFA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();

        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        if (tarefa.getStatus() != Status.CONCLUIDA) {
            tarefa.setStatus(Status.CANCELADA);
            System.out.println("Tarefa cancelada com sucesso!");
        } else {
            System.out.println("Tarefas concluidas não podem ser canceladas!");
        }
    }

    // ===== 3. SISTEMA DE FILTROS =====
    public void filtrarPorPrioridade() {
        System.out.println("=== FILTRAR POR PRIORIDADE ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("BAIXA, MEDIA, ALTA, URGENTE");
        System.out.println("Digite a prioridade: ");
        String prioridadeStr = scanner.nextLine().toUpperCase();
        Prioridade prioridade = Prioridade.valueOf(prioridadeStr);

        ArrayList<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getPrioridade() == prioridade) {
                filtradas.add(t);
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com esta prioridade!");
            return;
        }

        for (Tarefa t : filtradas) {
            System.out.println(t);
        }
    }

    public void filtrarPorStatus() {
        System.out.println("=== FILTRAR POR STATUS ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("PENDENTE, EM_ANDAMENTO, BLOQUEADA, CONCLUIDA, CANCELADA");
        System.out.println("Digite o status: ");
        String statusStr = scanner.nextLine().toUpperCase();
        Status status = Status.valueOf(statusStr);

        ArrayList<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getStatus() == status) {
                filtradas.add(t);
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com este status!");
            return;
        }

        for (Tarefa t : filtradas) {
            System.out.println(t);
        }
    }

    public void filtrarPorCategoria() {
        System.out.println("=== FILTRAR POR CATEGORIA ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite a categoria: ");
        String categoria = scanner.nextLine();

        ArrayList<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getCategoria().getCategoria().equalsIgnoreCase(categoria)) {
                filtradas.add(t);
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com esta categoria!");
            return;
        }

        for (Tarefa t : filtradas) {
            System.out.println(t);
        }
    }

    public void filtrarPorPrazo() {
        System.out.println("=== FILTRAR POR PRAZO ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("Digite a data inicial: (dd/MM/yyyy)");
        String dataInicioStr = scanner.nextLine();
        System.out.println("Digite a data final: (dd/MM/yyyy)");
        String dataFimStr = scanner.nextLine();

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatadorData);
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatadorData);

        ArrayList<Tarefa> filtradas = new ArrayList<>();
        for (Tarefa t : tarefas) {
            LocalDate dataTarefa = t.getPrazo().toLocalDate();
            if (!dataTarefa.isBefore(dataInicio) && !dataTarefa.isAfter(dataFim)) {
                filtradas.add(t);
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada neste periodo!");
            return;
        }

        for (Tarefa t : filtradas) {
            System.out.println(t);
        }
    }

    // ===== 4. RELATÓRIOS =====
    public void verTarefasAtrasadas() {
        System.out.println("=== TAREFAS ATRASADAS ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        LocalDateTime agora = LocalDateTime.now();
        ArrayList<Tarefa> atrasadas = new ArrayList<>();

        for (Tarefa t : tarefas) {
            if (t.getPrazo().isBefore(agora) && t.getStatus() != Status.CONCLUIDA && t.getStatus() != Status.CANCELADA) {
                atrasadas.add(t);
            }
        }

        if (atrasadas.isEmpty()) {
            System.out.println("Nenhuma tarefa atrasada!");
            return;
        }

        for (Tarefa t : atrasadas) {
            System.out.println(t);
        }
    }

    public void verTarefasUrgentes() {
        System.out.println("=== TAREFAS URGENTES ===");

        if (tarefas.isEmpty()) {
            System.out.println("Não existe nenhuma tarefa cadastrada!");
            return;
        }

        ArrayList<Tarefa> urgentes = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getPrioridade() == Prioridade.URGENTE && t.getStatus() != Status.CONCLUIDA && t.getStatus() != Status.CANCELADA) {
                urgentes.add(t);
            }
        }

        if (urgentes.isEmpty()) {
            System.out.println("Nenhuma tarefa urgente!");
            return;
        }

        for (Tarefa t : urgentes) {
            System.out.println(t);
        }
    }

    public void verTaxaConclusao() {
        System.out.println("=== TAXA DE CONCLUSAO ===");

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada!");
            return;
        }

        int total = tarefas.size();
        int concluidas = 0;

        for (Tarefa t : tarefas) {
            if (t.getStatus() == Status.CONCLUIDA) {
                concluidas++;
            }
        }

        double taxa = (double) concluidas / total * 100;
        System.out.println("Total de tarefas: " + total);
        System.out.println("Tarefas concluidas: " + concluidas);
        System.out.println("Taxa de conclusao: " + String.format("%.2f", taxa) + "%");
    }

    public void verDistribuicaoPrioridade() {
        System.out.println("=== DISTRIBUICAO POR PRIORIDADE ===");

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada!");
            return;
        }

        int baixa = 0, media = 0, alta = 0, urgente = 0;

        for (Tarefa t : tarefas) {
            if (t.getPrioridade() == Prioridade.BAIXA) {
                baixa++;
            } else if (t.getPrioridade() == Prioridade.MEDIA) {
                media++;
            } else if (t.getPrioridade() == Prioridade.ALTA) {
                alta++;
            } else if (t.getPrioridade() == Prioridade.URGENTE) {
                urgente++;
            }
        }

        int total = tarefas.size();
        System.out.println("BAIXA: " + baixa + " (" + String.format("%.1f", (double) baixa / total * 100) + "%)");
        System.out.println("MEDIA: " + media + " (" + String.format("%.1f", (double) media / total * 100) + "%)");
        System.out.println("ALTA: " + alta + " (" + String.format("%.1f", (double) alta / total * 100) + "%)");
        System.out.println("URGENTE: " + urgente + " (" + String.format("%.1f", (double) urgente / total * 100) + "%)");
    }

    // ===== MÉTODOS AUXILIARES =====
    private Tarefa encontrarTarefaPorId(long id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    private void exibirTarefa(Tarefa tarefa) {
        System.out.println("ID: " + tarefa.getId());
        System.out.println("Titulo: " + tarefa.getTitulo());
        System.out.println("Descricao: " + tarefa.getDescricao());
        System.out.println("Prazo: " + tarefa.getPrazo());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("Categoria: " + tarefa.getCategoria().getCategoria());
        System.out.println("Data Criacao: " + tarefa.getDataCriacao());
        System.out.println("Data Conclusao: " + tarefa.getDataConclusao());
    }
}