# Demo

API Spring Boot com PostgreSQL.

## O que precisa ter instalado

- Java 17
- PostgreSQL rodando na máquina

## Preparando o banco

Abre o psql (ou pgAdmin) e cria o banco:

```sql
CREATE DATABASE demo;
```

O projeto espera usuário `postgres` e senha `1234`, Se a senha do seu PostgreSQL for outra, ajusta em `src/main/resources/application.properties`:

```properties
spring.datasource.password=sua_senha
```

Não precisa criar tabela nenhuma, o Hibernate cria tudo sozinho na primeira vez que subir.

## Rodando

Na raiz do projeto:

Windows:
```
.\mvnw spring-boot:run
```

Linux/Mac:
```
./mvnw spring-boot:run
```

Sobe em http://localhost:8080
