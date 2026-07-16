📋 MiniCRM - Sistema de Gerenciamento de Relacionamento com Clientes
Sistema de CRM (Customer Relationship Management) desenvolvido em Java para gerenciar contatos, interações e acompanhamento de clientes potenciais e existentes.

🎯 Sobre o Projeto
A ideia central:
Imagine que você é um vendedor que conversa com vários clientes potenciais todos os dias. Alguns viram clientes, outros somem, outros vão para o concorrente. Você precisa de um lugar para anotar tudo isso e não se perder.

Este projeto substitui o "caderninho" ou planilha bagunçada por um programa de terminal organizado, permitindo que você gerencie todo o ciclo de relacionamento com seus clientes de forma eficiente.

🚀 Funcionalidades
1️⃣ Cadastrar Cliente
Adiciona novos contatos informando:

Nome

E-mail

Telefone

O programa automaticamente:

Marca o cliente como "Prospecto" (alguém que pode virar cliente, mas ainda não é)

Registra a data de cadastro

Armazena na lista de clientes

2️⃣ Listar Clientes
Exibe todos os clientes cadastrados com suas informações.
Funcionalidades futuras:

Filtrar por status (ex: "Em Negociação")

Buscar por nome

3️⃣ Registrar Interação
Registra conversas reais com o cliente fora do sistema.
Exemplos:

"Liguei dia 15/07, cliente pediu para enviar proposta"

"Mandei email com orçamento, aguardando resposta"

"Reunião presencial, cliente gostou do produto"

Cada interação guarda:

📅 Data da conversa

📝 Descrição detalhada

4️⃣ Gerenciar Status
Conforme o relacionamento avança, você pode atualizar o status do cliente:

Status	Significado
🟡 Prospecto	Contato novo, ainda não conversou de verdade
🔵 Em Negociação	Já conversou, enviou proposta, está tentando fechar
🟢 Cliente	Fechou! Virou cliente de verdade
⚪ Inativo	Já foi cliente, mas sumiu
🔴 Perdido	Desistiu ou foi para o concorrente
5️⃣ Próximas Ações
Cada cliente pode ter uma próxima ação anotada.
Exemplos:

"Enviar contrato até sexta"

"Ligar amanhã para saber resposta"

"Marcar reunião com financeiro"

Assim você nunca esquece de acompanhar ninguém!

🛠️ Tecnologias Utilizadas
Tecnologia	Descrição
☕ Java	Linguagem principal
📦 POO	Encapsulamento, Classes, Objetos
🏗️ MVC	Padrão de arquitetura
📚 Collections	ArrayList, HashSet, HashMap
🔢 Enum	StatusCliente
📅 LocalDate	Registro de datas
🚀 Como Executar
bash
# Navegue até a pasta do projeto
cd miniCrm/src

# Compile os arquivos
javac Main.java

# Execute o programa
java Main
📋 Exemplo de Uso
text
===== MINI CRM =====
1. Cadastrar Cliente
2. Listar Clientes
3. Registrar Interação
4. Alterar Status
5. Ver Próximas Ações
0. Sair

Escolha uma opção: 1

Nome: João Silva
Email: joao@email.com
Telefone: (11) 99999-9999

✅ Cliente cadastrado com sucesso!
Status: Prospecto
Data: 15/07/2026