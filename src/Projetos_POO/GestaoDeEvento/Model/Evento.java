package POO.Projetos_POO.GestaoDeEventos.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Evento {
    private long id;
    private static long proximoId = 0;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private LocalTime horario;
    private String local;
    private int vagas;
    private TipoEvento tipo;
    private CategoriaEvento categoria;
    private double valorInscricao;

    public Evento(String titulo, String descricao, LocalDate data, LocalTime horario, String local, int vagas, TipoEvento tipo, CategoriaEvento categoria, double valorInscricao) {
        this.id = ++proximoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.vagas = vagas;
        this.tipo = tipo;
        this.categoria = categoria;
        this.valorInscricao = valorInscricao;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }


    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public CategoriaEvento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEvento categoria) {
        this.categoria = categoria;
    }

    public double getValorInscricao() {
        return valorInscricao;
    }

    public void setValorInscricao(double valorInscricao) {
        this.valorInscricao = valorInscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return id == evento.id && vagas == evento.vagas && Objects.equals(titulo, evento.titulo) && Objects.equals(descricao, evento.descricao) && Objects.equals(data, evento.data) && Objects.equals(horario, evento.horario) && Objects.equals(local, evento.local) && tipo == evento.tipo && categoria == evento.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, data, horario, local, vagas, tipo, categoria);
    }

    @Override
    public String toString() {
        return "Evento: " +
                "\n  id = " + id +
                "\n  titulo = '" + titulo + '\'' +
                "\n  descricao = '" + descricao + '\'' +
                "\n  data = " + data +
                "\n  horario = " + horario +
                "\n  local = '" + local + '\'' +
                "\n  vagas = " + vagas +
                "\n  tipo = " + tipo +
                "\n  categoria = " + categoria +
                "\n}";
    }
}
