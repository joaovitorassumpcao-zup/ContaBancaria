# Gerenciamento de Contas Bancárias

Este projeto é uma aplicação Spring Boot que fornece uma API REST para gerenciar contas bancárias. Ele permite listar, criar, atualizar e deletar contas, bem como realizar depósitos e saques.

## Funcionalidades

1. **Listar Todas as Contas**: Retorna uma lista de todas as contas bancárias.
2. **Exibir Conta Específica**: Retorna os detalhes de uma conta bancária específica.
3. **Criar Nova Conta**: Permite cadastrar uma nova conta bancária.
4. **Deletar Conta**: Permite deletar uma conta bancária existente.
5. **Depositar**: Permite depositar um valor em uma conta bancária específica.
6. **Sacar**: Permite sacar um valor de uma conta bancária específica.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- JPA / Hibernate
- Banco de Dados H2

## Instalação e Execução

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   ```

2. **Navegue até o Diretório do Projeto**:
   ```bash
   cd seu-projeto
   ```

3. **Compile e Execute o Projeto**:
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints da API

- **GET /contas**: Lista todas as contas.
- **GET /contas/{id}**: Exibe uma conta específica.
- **POST /contas**: Cria uma nova conta.
- **DELETE /contas/{id}**: Deleta uma conta.
- **PUT /contas/{id}/deposito**: Realiza um depósito em uma conta.
- **PUT /contas/{id}/saque**: Realiza um saque de uma conta.

## Modelo de Dados

### ContaBancaria

- `id`: Identificador único da conta (Long).
- `numeroConta`: Número da conta (String).
- `agencia`: Número da agência (String).
- `nomeUsuario`: Nome do titular da conta (String).
- `valorAtual`: Saldo atual da conta (BigDecimal).
- `valorFinal`: Valor final após a transação (BigDecimal).
- `valorTransacao`: Valor da transação (BigDecimal).
- `tipoServico`: Tipo de serviço (depósito ou saque) (Enum).
