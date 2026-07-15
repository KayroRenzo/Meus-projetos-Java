package POO.Projetos_POO.sistemaBiblioteca.model;

public class Emprestimo {
    private Usuarios usuario;
    private Livro livro;
    private String status;

    public Emprestimo(Usuarios usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.status = "pendente";
    }

    // Getters e Setters
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario.getNomeUsuario() +
                " | Livro: " + livro.getNomeLivro() +
                " | Status: " + status;
    }
}