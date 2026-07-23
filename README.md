# ☕ Meus Projetos Java

Repositório com projetos Java organizados por nível de complexidade, desde conceitos básicos até aplicações com Programação Orientada a Objetos e padrão MVC.

---

## 📁 Projetos Básicos (Sem POO)

Projetos iniciais para praticar lógica de programação, sintaxe Java e estruturas de dados.

| Projeto | Descrição | Conceitos |
|---------|-----------|-----------|
| **CalculadoraScanner** | Calculadora com operações básicas | Scanner, if/else, métodos |
| **JogoAdivinhacao** | Jogo de adivinhar números | Random, while, dicas |
| **SistemaEscolar** | Cálculo de média e aprovação | Validação, média aritmética |
| **ControleDeGastos** | Gerenciamento de gastos pessoais | ArrayList, switch/case |
| **OrganizadorDeEstudos** | Organização de dias de estudo | Listas, percentuais |

[▶️ Ver detalhes dos projetos básicos](src/Projetos_Basicos/README.md)

---

## 📁 Projetos com POO (MVC)

Projetos aplicando Programação Orientada a Objetos, Collections Framework e padrão MVC.

### 📚 Sistema de Biblioteca

Sistema completo para gerenciar livros, usuários e empréstimos.

**Funcionalidades:**
- ✅ Cadastrar, editar e excluir usuários
- ✅ Cadastrar, editar e excluir livros
- ✅ Fazer empréstimos (máximo 3 por usuário)
- ✅ Devolver livros
- ✅ Listar empréstimos pendentes

**Tecnologias:** Java, POO, HashSet, HashMap, MVC

[▶️ Ver mais](src/Projetos_POO/sistemaBiblioteca/README.md)

---

### 🏦 Sistema Bancário

Sistema para gerenciar contas e transações bancárias.

**Funcionalidades:**
- ✅ Criar contas corrente e poupança
- ✅ Depositar, sacar e transferir
- ✅ Validar saldo insuficiente
- ✅ Extrato bancário

**Tecnologias:** Java, POO, Herança, Polimorfismo, Exceções

[▶️ Ver mais](src/Projetos_POO/sistemaBancario/README.md)

---

### 🛒 Sistema de Loja

Sistema para gerenciar produtos, estoque e vendas.

**Funcionalidades:**
- ✅ Cadastrar produtos
- ✅ Controlar estoque
- ✅ Gerenciar carrinho de compras
- ✅ Calcular total da compra

**Tecnologias:** Java, POO, Collections, MVC

[▶️ Ver mais](src/Projetos_POO/lojaOnline/README.md)

---

### 🎯 Gestão de Eventos

Sistema completo para gerenciar eventos, participantes e inscrições.

**Funcionalidades:**
- ✅ Cadastrar, editar e excluir eventos
- ✅ Cadastrar diferentes tipos de participantes (Estudante, Empresa, Individual, VIP)
- ✅ Gerenciar inscrições em eventos
- ✅ Validar categorias e tipos de eventos
- ✅ Sistema de status para inscrições (PENDENTE, CONFIRMADA, CANCELADA)
- ✅ Tratamento de exceções personalizadas

**Tecnologias:** Java, POO, Herança, Polimorfismo, Enums, Exceções Personalizadas, MVC

[▶️ Ver mais](src/Projetos_POO/GestaoDeEventos/README.md)

---

### 🏢 Mini CRM

Sistema básico de CRM para gerenciamento de clientes e interações.

**Funcionalidades:**
- ✅ Cadastrar, editar e excluir clientes
- ✅ Registrar interações com clientes
- ✅ Gerenciar status dos clientes
- ✅ Histórico de interações

**Tecnologias:** Java, POO, Collections, MVC

[▶️ Ver mais](src/Projetos_POO/miniCrm/README.md)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java 17** | Linguagem de programação |
| **POO** | Programação Orientada a Objetos |
| **Collections** | HashMap, HashSet, ArrayList |
| **MVC** | Model-View-Controller |
| **Git** | Controle de versão |

---

## 🚀 Como Executar

### Projetos Básicos
```bash
cd src/Projetos_Basicos
javac NomeDoProjeto.java
java NomeDoProjeto
