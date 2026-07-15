package POO.Projetos_POO.sistemaBancario.Exceptions;

public class SaldoInsuficiente extends RuntimeException {
    public SaldoInsuficiente(String message) {
        super(message);
    }
}
