package POO.Projetos_POO.GestaoDeEventos.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Participante {
    private long id;
    private static long proximoId = 0;
    private String nome;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    private TipoParticipante tipo;

    public Participante(String nome, String email, String telefone, TipoParticipante tipo){
        this.id = ++proximoId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public TipoParticipante getTipo() {
        return tipo;
    }

    public void setTipo(TipoParticipante tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(telefone, that.telefone) && Objects.equals(dataCadastro, that.dataCadastro) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, dataCadastro, tipo);
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", tipo=" + tipo +
                '}';
    }
}
