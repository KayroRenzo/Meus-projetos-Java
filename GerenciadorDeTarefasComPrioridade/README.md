# 📋 Gerenciador de Tarefas com Prioridade

Sistema para gerenciar tarefas com prioridades, status, filtros e relatórios, desenvolvido em Java com POO e MVC.

---

## 🎯 Funcionalidades

### 📝 CRUD Completo
- Adicionar tarefas (título, descrição, prazo, categoria, prioridade)
- Listar todas as tarefas
- Atualizar tarefas
- Remover tarefas

### 🔄 Gerenciamento de Status
- Iniciar tarefa (PENDENTE → EM_ANDAMENTO)
- Concluir tarefa (EM_ANDAMENTO → CONCLUIDA)
- Bloquear tarefa (EM_ANDAMENTO → BLOQUEADA)
- Cancelar tarefa (qualquer status → CANCELADA)

### 🔍 Filtros
- Filtrar por prioridade (BAIXA, MEDIA, ALTA, URGENTE)
- Filtrar por status (PENDENTE, EM_ANDAMENTO, BLOQUEADA, CONCLUIDA, CANCELADA)
- Filtrar por categoria
- Filtrar por período de prazo

### 📊 Relatórios
- Ver tarefas atrasadas
- Ver tarefas urgentes
- Taxa de conclusão
- Distribuição por prioridade

---

## 🛠️ Tecnologias

| Tecnologia | Descrição |
|------------|-----------|
| Java 17 | Linguagem de programação |
| POO | Programação Orientada a Objetos |
| Collections | ArrayList |
| Java Time API | LocalDateTime, LocalDate, LocalTime |
| MVC | Model-View-Controller |

---

## 🚀 Como Executar

```bash
cd src
javac POO/Projetos_POO/GerenciadorDeTarefasComPrioridade/**/*.java
java POO.Projetos_POO.GerenciadorDeTarefasComPrioridade.Main