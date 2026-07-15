package POO.Projetos_POO.sistemaBiblioteca.model;

public class Livro {
    private String nomeLivro;
    private String nomeAutor;

    public Livro(String nomeLivro, String nomeAutor) {
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    @Override
    public String toString() {
        return nomeLivro + " (Autor: " + nomeAutor + ")";
    }
}
