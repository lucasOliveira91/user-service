# Sistema de Gerenciamento de Usu�rios TailorIT - Lucas Oliveira

O Sistema de Gerenciamento de Usu�rios TailorIT � uma aplica��o web projetada para gerenciar credenciais 
de usu�rios e avaliar a for�a das senhas.

## Tecnologias Utilizadas

- **Backend**:
    - Java 17
    - Spring Boot
    - Hibernate ORM
    - Banco de Dados H2 (configura��o padr�o)
    - MySQL (configura��o opcional)
    - Flyway

- **Testes**:
    - JUnit
    - Spring Boot Test

## Funcionalidades

1. **Registro de Usu�rios**:
    - Registrar usu�rios com nome de usu�rio e senha.
    - Avaliar a for�a da senha com base em determinados crit�rios.
    - Exibir a for�a da senha em porcentagem.

2. **Hierarquia de Usu�rios**:
    - Estabelecer rela��es de parentesco entre usu�rios.
    - Exibir hierarquias de usu�rios.

3. **Listagem de Usu�rios**:
    - Listar todos os usu�rios registrados.
    - Exibir seu nome de usu�rio, for�a da senha e usu�rio pai (se houver).

## Como Executar

1. **Clonar o Reposit�rio**:
   ```bash
   git clone <url-do-reposit�rio>
   cd <nome-do-reposit�rio>

## Configura��o do Banco de Dados
Para iniciar o banco de dados Mysql

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=mydb -p 3306:3306 -d mysql:latest
```

## Executando a Aplica��o
Utilize o Maven para iniciar o servidor Spring Boot:
```bash
./mvnw spring-boot:run
```

