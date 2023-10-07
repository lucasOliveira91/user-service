# Sistema de Gerenciamento de Usuários TailorIT - Lucas Oliveira

O Sistema de Gerenciamento de Usuários TailorIT é uma aplicação web projetada para gerenciar credenciais 
de usuários e avaliar a força das senhas.

## Tecnologias Utilizadas

- **Backend**:
    - Java 17
    - Spring Boot
    - Hibernate ORM
    - Banco de Dados H2 (configuração padrão)
    - MySQL (configuração opcional)
    - Flyway

- **Testes**:
    - JUnit
    - Spring Boot Test

## Funcionalidades

1. **Registro de Usuários**:
    - Registrar usuários com nome de usuário e senha.
    - Avaliar a força da senha com base em determinados critérios.
    - Exibir a força da senha em porcentagem.

2. **Hierarquia de Usuários**:
    - Estabelecer relações de parentesco entre usuários.
    - Exibir hierarquias de usuários.

3. **Listagem de Usuários**:
    - Listar todos os usuários registrados.
    - Exibir seu nome de usuário, força da senha e usuário pai (se houver).

## Como Executar

1. **Clonar o Repositório**:
   ```bash
   git clone <url-do-repositório>
   cd <nome-do-repositório>

## Configuração do Banco de Dados
Para iniciar o banco de dados Mysql

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=mydb -p 3306:3306 -d mysql:latest
```

## Executando a Aplicação
Utilize o Maven para iniciar o servidor Spring Boot:
```bash
./mvnw spring-boot:run
```

