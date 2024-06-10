
# Pessoa API - teste 2

Este projeto é uma API REST desenvolvida em Java com o framework Spring Boot. O objetivo é servir como base de estudo para Java Web, Spring Boot e construção de APIs RESTful.

## Índice

- [Introdução](#introdução)
- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Execução](#execução)
- [Endpoints da API](#endpoints-da-api)
  - [Criar uma nova pessoa](#criar-uma-nova-pessoa)
  - [Obter todas as pessoas](#obter-todas-as-pessoas)
  - [Obter uma pessoa pelo ID](#obter-uma-pessoa-pelo-id)
  - [Atualizar uma pessoa pelo ID](#atualizar-uma-pessoa-pelo-id)
  - [Deletar uma pessoa pelo ID](#deletar-uma-pessoa-pelo-id)
- [Contribuindo](#contribuindo)

## Introdução

A Pessoa API permite a criação, leitura, atualização e deleção (CRUD) de registros de pessoas. Este projeto foi desenvolvido para ajudar no aprendizado de conceitos e práticas de desenvolvimento de APIs com Spring Boot.

## Requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/downloads)

## Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/pessoa-api.git
    cd pessoa-api
    ```

2. Configure o banco de dados H2:

    - O banco de dados H2 é um banco de dados em memória e não requer configuração adicional.
    - As informações de configuração do banco de dados já estão definidas no arquivo `application.properties`:

      ```properties
      spring.datasource.url=jdbc:h2:mem:pessoasdb
      spring.datasource.driverClassName=org.h2.Driver
      spring.datasource.username=sa
      spring.datasource.password=password
      spring.h2.console.enabled=true
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
      spring.jpa.hibernate.ddl-auto=update
      ```

3. Instale as dependências e compile o projeto com Maven:

    ```bash
    mvn clean install
    ```

## Execução

Para executar a aplicação, utilize o comando:

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

Você também pode acessar o console do banco de dados H2 em `http://localhost:8080/h2-console` usando as configurações padrão do H2 fornecidas no arquivo `application.properties`.

## Endpoints da API

### Criar uma nova pessoa

- **URL:** `/pessoas`
- **Método:** `POST`
- **Corpo da Requisição:**
  ```json
  {
    "name": "Thiago",
    "age": 41,
    "weight": 65,
    "height": 1.75
  }
  ```

### Obter todas as pessoas

- **URL:** `/pessoas`
- **Método:** `GET`

### Obter uma pessoa pelo ID

- **URL:** `/pessoas/{id}`
- **Método:** `GET`

### Atualizar uma pessoa pelo ID

- **URL:** `/pessoas/{id}`
- **Método:** `PUT`
- **Corpo da Requisição:**
  ```json
  {
    "name": "Thiago Atualizado",
    "age": 42,
    "weight": 70,
    "height": 1.75
  }
  ```

### Deletar uma pessoa pelo ID

- **URL:** `/pessoas/{id}`
- **Método:** `DELETE`

## Contribuindo

Se você deseja contribuir com este projeto, por favor, siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Comite suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.
```

Este README fornece uma visão clara e detalhada sobre como configurar, executar e contribuir para o projeto, destacando o uso do banco de dados H2 para simplificar a configuração inicial.
