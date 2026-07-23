package POO.Projetos_POO.GestaoDeEventos.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Inscricao {
    private long id;
    private static long proximoId = 0;
    private Evento evento;
    private Participante participante;
    private LocalDateTime dataInscricao;
    private StatusInscricao status;
    private LocalDateTime dataConfirmacao;
    private boolean presencaConfirmada;
    private double valor;

    public Inscricao(Evento evento, Participante participante, double valor) {
        this.id = ++proximoId;
        this.evento = evento;
        this.participante = participante;
        this.dataInscricao = LocalDateTime.now();
        this.status = StatusInscricao.PENDENTE;
        this.dataConfirmacao = null;
        this.presencaConfirmada = false;
        this.valor = valor;
    }

    public Inscricao(Evento evento, Participante participante, StatusInscricao status, double valor) {
        this(evento, participante, valor);
        this.status = status;
    }

    // GETTERS E SETTERS
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public Participante getParticipante() { return participante; }
    public void setParticipante(Participante participante) { this.participante = participante; }

    public LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }

    public StatusInscricao getStatus() { return status; }
    public void setStatus(StatusInscricao status) { this.status = status; }

    public LocalDateTime getDataConfirmacao() { return dataConfirmacao; }
    public void setDataConfirmacao(LocalDateTime dataConfirmacao) { this.dataConfirmacao = dataConfirmacao; }

    public boolean isPresencaConfirmada() { return presencaConfirmada; }
    public void setPresencaConfirmada(boolean presencaConfirmada) { this.presencaConfirmada = presencaConfirmada; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inscricao that = (Inscricao) o;
        return id == that.id &&
                presencaConfirmada == that.presencaConfirmada &&
                Objects.equals(evento, that.evento) &&
                Objects.equals(participante, that.participante) &&
                Objects.equals(dataInscricao, that.dataInscricao) &&
                status == that.status &&
                Objects.equals(dataConfirmacao, that.dataConfirmacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, evento, participante, dataInscricao, status, dataConfirmacao, presencaConfirmada);
    }

    @Override
    public String toString() {
        return "Inscricao: " +
                "\n  id = " + id +
                "\n  evento = " + evento.getTitulo() +
                "\n  participante = " + participante.getNome() +
                "\n  dataInscricao = " + dataInscricao +
                "\n  status = " + status +
                "\n  dataConfirmacao = " + dataConfirmacao +
                "\n  presencaConfirmada = " + presencaConfirmada +
                "\n  valor = " + valor +
                "\n}";
    }
}