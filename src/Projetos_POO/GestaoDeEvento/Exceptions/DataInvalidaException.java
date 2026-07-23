package POO.Projetos_POO.GestaoDeEventos.Exceptions;

public class DataInvalidaException extends EventoException {
    public DataInvalidaException() {
        super("Data do evento deve ser futuro!");
    }
}
