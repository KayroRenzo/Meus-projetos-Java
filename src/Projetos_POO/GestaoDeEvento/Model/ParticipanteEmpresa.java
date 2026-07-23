package POO.Projetos_POO.GestaoDeEventos.Model;

import java.util.Objects;

public class ParticipanteEmpresa extends Participante {
    private String cnpj;
    private String nomeDaEmpresa;
    private String nomeDoRepresentante;
    private String cargo;
    private int quantidadeDeFuncionarios;

    public ParticipanteEmpresa(String nome, String email, String telefone, TipoParticipante tipo, String cnpj, String nomeDaEmpresa, String nomeDoRepresentante, String cargo, int quantidadeDeFuncionarios) {
        super(nome, email, telefone, tipo);
        this.cnpj = cnpj;
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.nomeDoRepresentante = nomeDoRepresentante;
        this.cargo = cargo;
        this.quantidadeDeFuncionarios = quantidadeDeFuncionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getNomeDoRepresentante() {
        return nomeDoRepresentante;
    }

    public void setNomeDoRepresentante(String nomeDoRepresentante) {
        this.nomeDoRepresentante = nomeDoRepresentante;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getQuantidadeDeFuncionarios() {
        return quantidadeDeFuncionarios;
    }

    public void setQuantidadeDeFuncionarios(int quantidadeDeFuncionarios) {
        this.quantidadeDeFuncionarios = quantidadeDeFuncionarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParticipanteEmpresa that = (ParticipanteEmpresa) o;
        return quantidadeDeFuncionarios == that.quantidadeDeFuncionarios && Objects.equals(cnpj, that.cnpj) && Objects.equals(nomeDaEmpresa, that.nomeDaEmpresa) && Objects.equals(nomeDoRepresentante, that.nomeDoRepresentante) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cnpj, nomeDaEmpresa, nomeDoRepresentante, cargo, quantidadeDeFuncionarios);
    }

    @Override
    public String toString() {
        return "Participante Empresarial: " +
                "\n  id =  " + getId() +
                "\n  nome = '" + getNome() + '\'' +
                "\n  email = '" + getEmail() + '\'' +
                "\n  telefone = '" + getTelefone() + '\'' +
                "\n  tipo = " + getTipo() +
                "\n  dataCadastro = " + getDataCadastro() +
                "\n  cnpj = '" + cnpj + '\'' +
                "\n  nomeDaEmpresa = '" + nomeDaEmpresa + '\'' +
                "\n  nomeDoRepresentante = '" + nomeDoRepresentante + '\'' +
                "\n  cargo = '" + cargo + '\'' +
                "\n  quantidadeDeFuncionarios = " + quantidadeDeFuncionarios +
                "\n";
    }
}

