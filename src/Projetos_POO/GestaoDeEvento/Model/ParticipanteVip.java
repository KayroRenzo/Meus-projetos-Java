package POO.Projetos_POO.GestaoDeEventos.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParticipanteVip extends Participante {
    private String empresaParceira;
    private boolean credenciado;

    public ParticipanteVip(String nome, String email, String telefone,
                           TipoParticipante tipo,
                           String empresaParceira) {
        super(nome, email, telefone, tipo);
        this.empresaParceira = empresaParceira;
        this.credenciado = false;
    }

    public String getEmpresaParceira() {
        return empresaParceira;
    }

    public void setEmpresaParceira(String empresaParceira) {
        this.empresaParceira = empresaParceira;
    }

    public boolean isCredenciado() {
        return credenciado;
    }

    public void setCredenciado(boolean credenciado) {
        this.credenciado = credenciado;
    }

    @Override
    public String toString() {
        return "Participante Vip: " +
                "\n    id = " + getId() +
                "\n    nome = '" + getNome() + '\'' +
                "\n    email = '" + getEmail() + '\'' +
                "\n    telefone = '" + getTelefone() + '\'' +
                "\n    tipo = " + getTipo() +
                "\n    dataCadastro = " + getDataCadastro() + '\'' +
                "\n    empresaParceira = '" + empresaParceira + '\'' +
                "\n    credenciado = " + credenciado +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParticipanteVip that = (ParticipanteVip) o;
        return credenciado == that.credenciado && Objects.equals(empresaParceira, that.empresaParceira);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), empresaParceira, credenciado);
    }
}