package POO.Projetos_POO.sistemaBiblioteca.model;

public class Usuarios {
    private String nomeUsuario;

    public Usuarios(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public String toString() {
        return nomeUsuario;
    }
}
