package POO.Projetos_POO.GestaoDeEventos.Exceptions;

public class TipoDoEventoInvalido extends EventoException {
    public TipoDoEventoInvalido() {
        super("Tipo do evento inválido! Digite uma dessas opções");
    }
}
