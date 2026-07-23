package POO.Projetos_POO.GestaoDeEventos.Model;

import java.time.LocalDate;
import java.util.Objects;

public class ParticipanteIndividual extends Participante{
    private String cpf;
    private LocalDate dataNascimento;

    public ParticipanteIndividual(String nome, String email, String telefone, TipoParticipante tipo, String cpf, LocalDate dataNascimento) {
        super(nome, email, telefone, tipo);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParticipanteIndividual that = (ParticipanteIndividual) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, dataNascimento);
    }

    @Override
    public String toString() {
        return "Participante Individual: " +
                "\n  id = " + getId() +
                "\n  nome = '" + getNome() + '\'' +
                "\n  email = '" + getEmail() + '\'' +
                "\n  telefone = '" + getTelefone() + '\'' +
                "\n  tipo = " + getTipo() +
                "\n  dataCadastro = " + getDataCadastro() +
                "\n  cpf = '" + cpf + '\'' +
                "\n  dataNascimento = " + dataNascimento +
                "\n";
    }
}
