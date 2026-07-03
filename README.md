# 🚀 Projetos Em Java

Este repositório contém 5 projetos desenvolvidos em Java durante meus estudos. Cada projeto foi criado para praticar diferentes conceitos da linguagem, desde o básico até estruturas mais complexas.

---

## Projetos sem POO (Em ordem de criação)

### 1 - CalculadoraScanner 
**Meu primeiro projeto!** Uma calculadora que realiza operações matemáticas básicas.

**Como funciona:**
- O usuário escolhe a operação (somar, subtrair, multiplicar ou dividir)
- Digita dois números
- O programa chama o método correspondente e exibe o resultado

**Funcionalidades:**
- Soma de dois números
- Subtração de dois números
- Multiplicação de dois números
- Divisão de dois números
- Validação de operação inválida

**Conceitos aplicados:**
- Entrada de dados com `Scanner`
- Estruturas condicionais (`if/else if/else`)
- Métodos estáticos
- Comparação de strings com `.equals()`

---

### 2-  JogoAdivinhacao 
**Meu segundo projeto!** Um jogo interativo onde o usuário tenta adivinhar um número aleatório.

**Como funciona:**
- O usuário define o número máximo para o sorteio
- O programa gera um número aleatório entre 0 e o valor definido
- O usuário tenta adivinhar, recebendo dicas de "maior" ou "menor"
- O jogo continua até o acerto

**Funcionalidades:**
- Sorteio de número aleatório com `Random`
- Definição do limite máximo pelo usuário
- Dicas interativas (maior/menor)
- Loop até o acerto

**Conceitos aplicados:**
- Geração de números aleatórios (`Random`)
- Laços de repetição (`while`)
- Estruturas condicionais aninhadas
- Interação com usuário via console

---

### 3 - SistemaEscolar
**Meu terceiro projeto!** Um sistema para calcular a média de um aluno e verificar sua aprovação.

**Como funciona:**
- O usuário digita o nome do aluno
- Insere as 4 notas (de 0 a 10)
- O programa calcula a média
- Exibe se o aluno foi aprovado (média ≥ 6) ou reprovado

**Funcionalidades:**
- Cadastro do nome do aluno
- Entrada de 4 notas
- Cálculo de média aritmética
- Validação de notas (entre 0 e 10)
- Exibição do resultado com nome personalizado

**Conceitos aplicados:**
- Entrada de dados com `Scanner`
- Validação de dados com `if/else`
- Cálculo de média aritmética
- Estruturas condicionais compostas

---

### 4 - ControleDeGastos 
**Meu quarto projeto!** Um sistema para gerenciar gastos pessoais com menu interativo.

**Como funciona:**
- O usuário navega por um menu com 4 opções
- Pode cadastrar gastos, calcular média, ver o maior gasto ou sair
- Os dados são armazenados em uma lista durante a execução

**Funcionalidades:**
- Cadastro de gastos (valores em R$)
- Cálculo da média total dos gastos
- Identificação do maior gasto e sua posição
- Listagem de todos os gastos cadastrados
- Validação de lista vazia

**Conceitos aplicados:**
- `ArrayList` para armazenar dados
- Laço `while` para menu infinito
- Estrutura `switch/case` para navegação
- Formatação de números com `String.format()`
- Percorrimento de listas com `for`

---

### 5 - OrganizadorDeEstudos 
**Meu quinto projeto!** Um sistema para organizar dias de estudo com controle de conclusão.

**Como funciona:**
- O usuário cadastra matérias e dias da semana
- Cada dia começa com status "Pendente"
- Pode marcar dias como "Concluído"
- O sistema mostra o percentual de conclusão

**Funcionalidades:**
- Cadastro de matérias
- Cadastro de dias da semana com status
- Visualização de todos os dias e seus status
- Cálculo de percentual de conclusão
- Edição de status (Pendente → Concluído)

**Conceitos aplicados:**
- `ArrayList` com tipos genéricos
- Listas paralelas para relacionar dados
- Menu interativo com `switch/case`
- Cálculo de percentuais
- Percorrimento e manipulação de listas

---

## Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Scanner** - Para entrada de dados do usuário
- **Random** - Para geração de números aleatórios
- **ArrayList** - Para armazenamento de dados em lista
