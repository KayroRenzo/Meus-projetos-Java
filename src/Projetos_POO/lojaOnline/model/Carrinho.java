package POO.Projetos_POO.lojaOnline.model;

public class Carrinho {
    private String nome;
    private double preco;
    private int quantidade;

    public Carrinho(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Carrinho(String nome, double preco) {
        this(nome, preco, 1);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return preco * quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s | Qtd: %d | Subtotal: R$%.2f",
                nome, quantidade, calcularSubtotal());
    }
}