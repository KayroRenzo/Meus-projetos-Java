package POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model;

import java.time.LocalDateTime;

public class Tarefa {
    private long id;
    private static long contadorId;
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private Prioridade prioridade;
    private Status status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private Categoria categoria;

    public Tarefa(String titulo, String descricao, LocalDateTime prazo, Prioridade prioridade, String categoria) {
        this.id = ++contadorId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.status = Status.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = null;
        this.categoria = new Categoria (categoria);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarefa: " +
                "id =" + id +
                ", titulo ='" + titulo + '\'' +
                ", descricao ='" + descricao + '\'' +
                ", prazo =" + prazo +
                ", prioridade =" + prioridade +
                ", status =" + status +
                ", dataCriacao =" + dataCriacao +
                ", dataConclusao =" + dataConclusao +
                ", categoria =" + categoria +
                '}';
    }
}
