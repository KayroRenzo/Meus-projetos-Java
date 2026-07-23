package POO.Projetos_POO.GestaoDeEventos.Model;

import java.util.Objects;

public class ParticipanteEstudante extends Participante {
    private String nomeInstituicao;
    private String serie;
    private int idade;
    private String cpf;

    public ParticipanteEstudante(String nome, String email, String telefone, TipoParticipante tipo, String nomeInstituicao, String serie, int idade, String cpf) {
        super(nome, email, telefone, tipo);
        this.nomeInstituicao = nomeInstituicao;
        this.serie = serie;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParticipanteEstudante that = (ParticipanteEstudante) o;
        return cpf == that.cpf && Objects.equals(nomeInstituicao, that.nomeInstituicao) && Objects.equals(serie, that.serie) && Objects.equals(idade, that.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomeInstituicao, serie, idade, cpf);
    }

    @Override
    public String toString() {
        return "Participante Estudante: " +
                "\n  id = " + getId() +
                "\n  nome = '" + getNome() + '\'' +
                "\n  email = '" + getEmail() + '\'' +
                "\n  telefone = '" + getTelefone() + '\'' +
                "\n  tipo = " + getTipo() +
                "\n  dataCadastro = " + getDataCadastro() +
                "\n  nomeInstituicao = '" + nomeInstituicao + '\'' +
                "\n  serie = '" + serie + '\'' +
                "\n  idade = " + idade +
                "\n  cpf = '" + cpf + '\'' +
                "\n";
    }
}
