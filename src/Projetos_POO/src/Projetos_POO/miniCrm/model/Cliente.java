package POO.Projetos_POO.miniCrm.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private StatusCliente status;
    private LocalDateTime dataCadastrado;
    private ArrayList<Interacao> interacao;
    private String proximaAcao;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = StatusCliente.PROSPECTO; // Diz que o status principal é o PROSPECTO
        this.dataCadastrado = LocalDateTime.now(); // Pega a data e a hora atual
        this.interacao = new ArrayList<>();
        this.proximaAcao = "";
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

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public ArrayList<Interacao> getInteracao() {
        return interacao;
    }

    public void setInteracao(ArrayList<Interacao> interacao) {
        this.interacao = interacao;
    }

    public String getProximaAcao() {
        return proximaAcao;
    }

    public void setProximaAcao(String proximaAcao) {
        this.proximaAcao = proximaAcao;
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
                "  Nome: " + nome + "\n" +
                "  Email: " + email + "\n" +
                "  Telefone: " + telefone + "\n" +
                "  Status: " + status + "\n" +
                "  Data Cadastro: " + dataCadastrado + "\n" +
                "  Interações: " + interacao + "\n" +
                "  Próxima Ação: " + proximaAcao;
    }
}