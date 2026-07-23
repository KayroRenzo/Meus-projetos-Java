# 🎯 Sistema de Gestão de Eventos

Sistema completo para gerenciar eventos, participantes e inscrições, desenvolvido em Java com Programação Orientada a Objetos e padrão MVC.

---

## 📋 Descrição

O **Sistema de Gestão de Eventos** é uma aplicação console que permite gerenciar eventos, participantes e inscrições de forma organizada e eficiente. O sistema suporta diferentes tipos de participantes e oferece validações robustas para garantir a integridade dos dados.

---

## ✨ Funcionalidades

### 📅 Gerenciamento de Eventos
- ✅ Cadastrar novos eventos
- ✅ Editar eventos existentes
- ✅ Excluir eventos
- ✅ Listar todos os eventos
- ✅ Buscar eventos por categoria
- ✅ Buscar eventos por tipo

### 👥 Gerenciamento de Participantes
- ✅ Cadastrar participantes (4 tipos diferentes)
  - 🎓 **Estudante** - com instituição de ensino
  - 🏢 **Empresa** - com CNPJ e nome da empresa
  - 👤 **Individual** - participante comum
  - ⭐ **VIP** - com benefícios especiais
- ✅ Editar participantes
- ✅ Excluir participantes
- ✅ Listar todos os participantes
- ✅ Buscar participantes por tipo

### 📝 Gerenciamento de Inscrições
- ✅ Inscrever participantes em eventos
- ✅ Cancelar inscrições
- ✅ Confirmar inscrições
- ✅ Listar inscrições de um evento
- ✅ Listar inscrições de um participante
- ✅ Visualizar status das inscrições

### 🎯 Status das Inscrições
- ⏳ **PENDENTE** - Aguardando confirmação
- ✅ **CONFIRMADA** - Inscrição aprovada
- ❌ **CANCELADA** - Inscrição cancelada

---

## 🏗️ Arquitetura (MVC)

O projeto segue o padrão **MVC (Model-View-Controller)***

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java 17** | Linguagem de programação |
| **POO** | Programação Orientada a Objetos |
| **Herança** | Classes Participante (Estudante, Empresa, Individual, VIP) |
| **Polimorfismo** | Métodos sobrescritos nas classes filhas |
| **Encapsulamento** | Atributos privados com getters/setters |
| **Enums** | CategoriaEvento, TipoEvento, StatusInscricao, TipoParticipante |
| **Collections** | ArrayList, HashSet, HashMap |
| **MVC** | Model-View-Controller |
| **Exceções** | Tratamento de erros personalizado |

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Git (opcional)

### Execução

```bash
# Navegue até a pasta do projeto
cd GestaoDeEventos

# Compile os arquivos
javac src/Main.java

# Execute o programa
java src/Main
