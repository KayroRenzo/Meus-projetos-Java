package POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.model;

public enum Status {
    PENDENTE,        // Aguardando início
    EM_ANDAMENTO,    // Em execução
    BLOQUEADA,       // Aguardando dependência
    CONCLUIDA,       // Finalizada
    CANCELADA        // Não será feita
}