package POO.Projetos_POO.GestaoDeEventos.Model;

import java.util.Objects;

public class Palestrante extends Participante {
    private String especialidade;
    private String tituloPalestra;
    private String curriculo;
    private String nomeEvento;

    public Palestrante(String nome, String email, String telefone, TipoParticipante tipo, String especialidade, String tituloPalestra, String curriculo, String nomeEvento) {
        super(nome, email, telefone, tipo);
        this.especialidade = especialidade;
        this.tituloPalestra = tituloPalestra;
        this.curriculo = curriculo;
        this.nomeEvento = nomeEvento;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTituloPalestra() {
        return tituloPalestra;
    }

    public void setTituloPalestra(String tituloPalestra) {
        this.tituloPalestra = tituloPalestra;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Palestrante that = (Palestrante) o;
        return Objects.equals(especialidade, that.especialidade) && Objects.equals(tituloPalestra, that.tituloPalestra) && Objects.equals(curriculo, that.curriculo) && Objects.equals(nomeEvento, that.nomeEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidade, tituloPalestra, curriculo, nomeEvento);
    }

    @Override
    public String toString() {
        return "Palestrante: " +
                "\n  id = " + getId() +
                "\n  nome = '" + getNome() + '\'' +
                "\n  email = '" + getEmail() + '\'' +
                "\n  telefone = '" + getTelefone() + '\'' +
                "\n  tipo = " + getTipo() +
                "\n  dataCadastro = " + getDataCadastro() +
                "\n  especialidade = '" + especialidade + '\'' +
                "\n  tituloPalestra = '" + tituloPalestra + '\'' +
                "\n  curriculo = '" + curriculo + '\'' +
                "\n  nomeEvento = '" + nomeEvento + '\'' +
                "\n";
    }
}
