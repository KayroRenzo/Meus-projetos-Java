package POO.Projetos_POO.GestaoDeEventos.Controller;

import POO.Projetos_POO.GestaoDeEventos.Exceptions.*;
import POO.Projetos_POO.GestaoDeEventos.Model.Evento;
import POO.Projetos_POO.GestaoDeEventos.Model.Inscricao;
import POO.Projetos_POO.GestaoDeEventos.Model.Participante;
import POO.Projetos_POO.GestaoDeEventos.Model.StatusInscricao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InscricaoController {
    private Scanner scanner;
    private List<Inscricao> inscricoes;
    private List<Participante> participantes;
    private List<Evento> eventos;

    public InscricaoController(List<Participante> participantes, List<Evento> eventos) {
        this.scanner = new Scanner(System.in);
        this.inscricoes = new ArrayList<>();
        this.participantes = participantes;
        this.eventos = eventos;
    }

    // METODOS AUXILIAR PARA A BUSCA
    private Evento buscarEventoPorNome(String nomeEvento) throws EventoNaoEncontradoException {
        for (Evento evento : eventos) {
            if (evento.getTitulo().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        throw new EventoNaoEncontradoException("Evento '" + nomeEvento + "' não encontrado!");
    }

    private Participante buscarParticipantePorNome(String nomeParticipante) throws ParticipanteNaoEncontradoException {
        for (Participante participante : participantes) {
            if (participante.getNome().equalsIgnoreCase(nomeParticipante)) {
                return participante;
            }
        }
        throw new ParticipanteNaoEncontradoException("Participante '" + nomeParticipante + "' não encontrado!");
    }

    public void fazerInscricao() {
        System.out.println("=== FAZER INSCRIÇÃO ===");

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine().trim();

        System.out.println("Digite o seu nome: ");
        String nomeParticipante = scanner.nextLine().trim();

        // BUSCAR O EVENTO
        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarEventoPorNome(nomeEvento);
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        // BUSCAR O PARTICIPANTE
        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // VERIFICA SE O PARTICIPANTE FOI ENCONTRADO, SE NÃO FOR, ELE LANCA UMA EXCEÇÃO
        if (participanteEncontrado == null) {
            System.out.println("O participante " + nomeParticipante + " não foi encontrado");
            return;
        }

        // VERIFICAR SE JA ESTA INSCRITO
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getEvento().equals(eventoEncontrado) && inscricao.getParticipante().equals(participanteEncontrado)) {
                System.out.println("Participante ja esta inscrito neste evento!");
                return;
            }
        }

        // CRIAR INSCRICAO
        Inscricao novaInscricao = new Inscricao(eventoEncontrado, participanteEncontrado, eventoEncontrado.getValorInscricao());
        int vagasAtuais = eventoEncontrado.getVagas();
        eventoEncontrado.setVagas(vagasAtuais - 1);

        inscricoes.add(novaInscricao);

        System.out.println("Inscricao realizada com sucesso!");
        System.out.println("Valor: R$ " + eventoEncontrado.getValorInscricao());
    }

    public void listarInscricoes() {
        System.out.println("=== LISTA DE INSCRICOES ===");

        if (inscricoes.isEmpty()) {
            System.out.println("Nenhuma inscricao encontrada!");
            return;
        }

        for (Inscricao inscricao : inscricoes) {
            System.out.println(inscricao);
        }
    }

    public void confirmarInscricao() {
        System.out.println("=== CONFIRMAR INSCRICAO ===");

        System.out.println("Digite seu nome: ");
        String nomeParticipante = scanner.nextLine().trim();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine().trim();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarEventoPorNome(nomeEvento);
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        boolean inscricaoEncontrada = false;

        for (Inscricao inscricao : inscricoes) {
            String nomeParticipanteInscrito = inscricao.getParticipante().getNome();
            String nomeEventoInscrito = inscricao.getEvento().getTitulo();

            if (nomeParticipanteInscrito.equals(participanteEncontrado.getNome()) &&
                    nomeEventoInscrito.equals(eventoEncontrado.getTitulo())) {
                inscricao.setStatus(StatusInscricao.CONFIRMADA);
                inscricao.setDataConfirmacao(LocalDateTime.now());
                inscricaoEncontrada = true;
                System.out.println("Inscricao confirmada com sucesso!");
                break;
            }
        }

        if (!inscricaoEncontrada) {
            System.out.println(
                    "Inscricao nao encontrada para o participante '" + nomeParticipante +
                            "' no evento '" + nomeEvento + "'"
            );
        }
    }

    public void cancelarInscricao() {
        System.out.println("=== CANCELAR INSCRIÇÃO ===");
        boolean inscricaoEncontrada = false;
        System.out.println("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine().trim();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarEventoPorNome(nomeEvento);
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        for (Inscricao inscrito : inscricoes) {
            String nomeParticipanteInscrito = inscrito.getParticipante().getNome();
            String nomeEventoInscrito = inscrito.getEvento().getTitulo();

            if (nomeParticipanteInscrito.equalsIgnoreCase(participanteEncontrado.getNome()) && nomeEventoInscrito.equalsIgnoreCase(eventoEncontrado.getTitulo())) {
                inscrito.setStatus(StatusInscricao.CANCELADA);
                inscrito.setDataConfirmacao(LocalDateTime.now());
                inscricaoEncontrada = true;
                System.out.println("Inscrição cancelada com sucesso");
                break;
            }
        }
        if (!inscricaoEncontrada) {
            System.out.println("Inscrição não encontrada");
            return;
        }
    }

    public void confirmarPresenca() {
        System.out.println("=== CONFIRMAR PRESENCA NO EVENTO ===");
        boolean encontrado = false;

        System.out.println("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine().trim();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarEventoPorNome(nomeEvento);
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        for (Inscricao inscrito : inscricoes) {
            String nomeParticipanteInscrito = inscrito.getParticipante().getNome();
            String nomeEventoInscrito = inscrito.getEvento().getTitulo();

            if (nomeParticipanteInscrito.equalsIgnoreCase(participanteEncontrado.getNome()) &&
                    nomeEventoInscrito.equalsIgnoreCase(eventoEncontrado.getTitulo())) {

                // Pega a data do evento da propria inscricao
                LocalDate dataEvento = inscrito.getEvento().getData();
                LocalDate hoje = LocalDate.now();

                // Verifica se a data do evento e igual a hoje
                // isEqual =>  compara se duas datas são exatamente iguais.
                if (dataEvento.isEqual(hoje)) {
                    inscrito.setPresencaConfirmada(true);
                    encontrado = true;
                    System.out.println("Presenca confirmada com sucesso!");
                    // isAfter => verifica se uma data e posterior a outra data.
                } else if (dataEvento.isAfter(hoje)) {
                    System.out.println("Evento ainda não aconteceu. So pode confirmar no dia do evento.");
                    return;
                } else {
                    System.out.println("Evento ja passou. Nao e possivel confirmar presenca.");
                    return;
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Inscricao nao encontrada");
        }
    }

    public void listarInscricoesPorEvento() {
        System.out.println("=== LISTAR INSCRICOES POR EVENTO ===");
        System.out.println("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();

        Evento eventoEncontrado = null;
        try {
            eventoEncontrado = buscarEventoPorNome(nomeEvento);
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        int contadorInscricoes = 0;
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getEvento().getTitulo().equalsIgnoreCase(eventoEncontrado.getTitulo())) {
                if (contadorInscricoes == 0) {
                    System.out.println("Inscricoes para o evento '" + nomeEvento + "':");
                }
                System.out.println(inscricao);
                contadorInscricoes++;
            }
        }

        if (contadorInscricoes == 0) {
            System.out.println("Nenhuma inscricao encontrada para o evento '" + nomeEvento + "'");
        }
    }

    public void listarInscricoesPorParticipante() {
        System.out.println("=== LISTAR INSCRICOES POR PARTICIPANTE ===");
        System.out.println("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        boolean encontrou = false;
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getParticipante().getNome().equalsIgnoreCase(participanteEncontrado.getNome())) {
                if (!encontrou) {
                    System.out.println("Inscricoes do participante '" + nomeParticipante + "':");
                }
                System.out.println(inscricao);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma inscricao encontrada para o participante '" + nomeParticipante + "'");
        }
    }

    public void listarInscricoesPorParticipanteConfirmados() {
        System.out.println("=== LISTAR INSCRICOES DO PARTICIPANTE QUE ESTA CONFIRMADO ===");
        System.out.println("Digite o nome do participante: ");
        String nomeParticipante = scanner.nextLine();

        Participante participanteEncontrado = null;
        try {
            participanteEncontrado = buscarParticipantePorNome(nomeParticipante);
        } catch (ParticipanteNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        boolean encontrou = false;
        String nomeParticipanteInscrito = participanteEncontrado.getNome();

        for (Inscricao inscricao : inscricoes) {
            String nomeInscrito = inscricao.getParticipante().getNome();

            if (nomeInscrito.equalsIgnoreCase(nomeParticipanteInscrito) &&
                    inscricao.getStatus() == StatusInscricao.CONFIRMADA) {
                System.out.println(inscricao);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma inscricao confirmada encontrada para o participante '" + nomeParticipante + "'");
        }
    }
}