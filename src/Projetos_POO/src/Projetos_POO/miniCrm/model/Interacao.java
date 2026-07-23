package POO.Projetos_POO.miniCrm.model;

import java.time.LocalDateTime;

public class Interacao {
    private LocalDateTime data;
    private String descricao;

    public Interacao(String descricao) {
        this.data = LocalDateTime.now();
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return " Descrição: " + descricao + "\n" +
                " Data e Hora: " + data;
    }
}
