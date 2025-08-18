# Microsserviço de Tarefas 📝

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33?style=flat-square&logo=spring-boot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=flat-square&logo=mongodb&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=flat-square&logo=json-web-tokens&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-2C3E50?style=flat-square&logo=lombok&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?style=flat-square&logo=github-actions&logoColor=white)
![Kanban](https://img.shields.io/badge/Kanban-007ACC?style=flat-square&logo=trello&logoColor=white) 


## Visão Geral

Este é o **microsserviço de tarefas**, uma peça central na arquitetura da API de gerenciamento de tarefas. Ele é responsável por toda a lógica de negócio relacionada à criação, consulta, atualização e exclusão de tarefas. Diferentemente do microsserviço de usuários, este serviço utiliza um banco de dados **NoSQL** para garantir flexibilidade e alta performance no gerenciamento de dados de tarefas. A comunicação com o microsserviço de usuários para obter informações de autenticação é feita de forma segura utilizando **JWT**.

-----

## Tecnologias e Ferramentas

* **Java ☕ e Spring Boot:** A base do desenvolvimento, fornecendo um ambiente robusto e ágil.
* **MongoDB:** Banco de dados **NoSQL** ideal para armazenar dados de tarefas de forma flexível, já que a estrutura dos documentos pode variar.
* **MapStruct:** Uma biblioteca de mapeamento de objetos que simplifica a conversão entre entidades de domínio e **DTOs** (Data Transfer Objects), reduzindo o código boilerplate e garantindo um mapeamento seguro e eficiente.
* **Lombok:** Minimiza o código repetitivo (getters, setters, construtores), mantendo o código limpo e conciso.
* **JWT (JSON Web Tokens):** Utilizado para validar a autenticação do usuário em todas as rotas protegidas, garantindo que apenas usuários autorizados possam manipular suas tarefas.
* **Gradle:** Gerenciador de dependências e automação de build para um fluxo de trabalho de desenvolvimento eficiente.
* **FeignClient:** Uma biblioteca de clientes REST declarativos que facilita a comunicação HTTP entre os microsserviços.
-----

## Funcionalidades (Endpoints)

Todos os endpoints listados abaixo exigem um token JWT válido no cabeçalho `Authorization` para serem acessados, garantindo a segurança de todas as operações.

* **`POST /tasks`**: Cria uma nova tarefa para o usuário autenticado.
* **`GET /tasks/events`**: Busca tarefas por um período de tempo específico (`eventAfter` e `eventBefore`) e por status (`status`). Os parâmetros de data devem estar no formato `dd-MM-yyyy HH:mm:ss`.
* **`GET /tasks/search-by-email`**: Obtém todas as tarefas associadas a um e-mail de usuário específico.
* **`DELETE /tasks?id={id}`**: Exclui uma tarefa pelo seu ID.
* **`PATCH /tasks?status={status}&id={id}`**: Atualiza o status de uma tarefa (por exemplo, de PENDENTE para CONCLUÍDA) pelo seu ID.
* **`PUT /tasks?id={id}`**: Atualiza os dados completos de uma tarefa pelo seu ID.

-----

## Comunicação com Outros Microsserviços

Este serviço se comunica com o microsserviço de usuários para autenticação e autorização. A lógica de autenticação é baseada em JWT, garantindo que as operações de criação, atualização e exclusão de tarefas sejam realizadas por usuários válidos e autorizados.

-----

## Próximos Passos

Este microsserviço está preparado para ser a base de novas funcionalidades. As próximas etapas incluem a implementação de um **Cron Job** para notificação de tarefas e a integração com o **BFF (Back-End For Front-End)**.

-----

## Como Executar o Projeto Localmente

**Pré-requisitos:**

* JDK 17 ou superior
* Docker e Docker Compose
* MongoDB instalado ou rodando via Docker

**Passos:**

1.  Clone este repositório:
    ```bash
    git clone git@github.com:DiegoReso/microservice-scheduler.git
    cd microservice-scheduler
    ```
2.  Configure suas variáveis de ambiente, como a URI de conexão com o MongoDB, nas configurações da aplicação.
3.  Execute a aplicação usando Gradle:
    ```bash
    ./gradlew bootRun
    ```
4.  A API estará disponível em `http://localhost:8081` (ou a porta configurada para o serviço).
