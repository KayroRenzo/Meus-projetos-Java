package POO.Projetos_POO.miniCrm.model;

public enum StatusCliente {
    // Contato inicial, frio. Você descobriu que essa pessoa/empresa existe e pode se tornar cliente um dia.
    PROSPECTO,

    // Já está conversando ativamente. Proposta enviada, valores sendo discutidos, reuniões acontecendo.
    NEGOCIACAO,

    // Fechou! Assinou contrato, comprou o produto, virou cliente oficial.
    CLIENTE,

    // Já foi cliente, mas sumiu. Não responde e-mails, não atende ligações, não compra mais.
    INATIVO,

    // Acabou a chance. Foi para o concorrente, desistiu do projeto, disse "não" claramente.
    PERDIDO
}