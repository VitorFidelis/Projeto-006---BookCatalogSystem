# Projeto-006---BookCatalogSystem

# 📚 API REST - Catálogo de Livros

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
[![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)](https://maven.apache.org/)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?logo=spring)
![Arquitetura](https://img.shields.io/badge/Clean%20Architecture-implementado-blueviolet)
![Status](https://img.shields.io/badge/Projeto-Em%20Desenvolvimento-yellow)


---

## 🧾 Descrição

A **API REST de Catálogo de Livros** é uma aplicação construída com **Java + Spring Boot**, utilizando os princípios da **Clean Architecture** para promover separação de responsabilidades, baixo acoplamento e alta testabilidade.

A API permite realizar operações CRUD completas sobre livros, incluindo cadastro, listagem, consulta por ID, atualização e exclusão.

---

## 🎯 Objetivos

- Aplicar a Clean Architecture em uma API REST
- Separar regras de negócio, persistência e apresentação
- Implementar testes de integração com banco H2
- Utilizar boas práticas com Spring Boot + JPA

---

## 🚀 Funcionalidades

- ✅ Cadastrar um novo livro  
- ✅ Listar todos os livros  
- ✅ Buscar livro por ID  
- ✅ Atualizar informações de um livro  
- ✅ Deletar livro  

---

## 🛠️ Tecnologias e Ferramentas

- Java 21+
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- H2 Database
- JUnit 5

---

## 🧱 Estrutura do Projeto (Clean Architecture)

```text
📁 domain
├── model       → Livro
└── repository  → LivroRepository

📁 application
└── usecase    → CreateLivroUseCase, DeleteLivroUseCase,  UpdateLivroUseCase

📁 infrastructure
├── mapper     → LivroMapper
├── entities   → LivroEntity
└── repository → LivroRepositoryImp, LivroSpringDataRepository

📁 interface
├── controller  → LivroController
└── dto         → SaveLivroDto, UpdateLivroDto
````
---

## 🔗 Endpoints de exemplo

| Método | URL             | Descrição                  |
|--------|------------------|----------------------------|
| GET    | `/livros`        | Lista todos os livros      |
| GET    | `/livros/{id}`   | Busca livro por ID         |
| POST   | `/livros`        | Cadastra novo livro        |
| PUT    | `/livros/{id}`   | Atualiza livro existente   |
| DELETE | `/livros/{id}`   | Remove um livro por ID     |

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/VitorFidelis/Projeto-006---BookCatalogSystem.git
cd catalogo-livros-clean-architecture
````

### 2. Execute o projeto

```bash
./mvnw spring-boot:run
````
A API estará disponível em: http://localhost:8080/livros

---

## 🗄️ Acessar H2 Database (Console Web)

Durante a execução da aplicação, você pode acessar a interface gráfica do banco de dados em memória (H2) através da seguinte URL:

🔗 http://localhost:8080/h2-console

#### ✅ Configurações de acesso

| Campo          | Valor                             |
|----------------|-----------------------------------|
| JDBC URL       | `jdbc:h2:mem:BookCatalogSystem`   |
| User Name      | `root`                            |
| Password       | `123`                             |
| Driver Class   | `org.h2.Driver`                   |


⚠️ O acesso ao console H2 precisa estar habilitado no application.properties:

```bash
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
---

## 📬 Postman – Como Importar a Collection

### 1. Baixar os arquivos necessários

   BookCatalogSystem.postman_collection.json → Collection com os endpoints.
   
### 2. Instalar o Postman (se ainda não tiver)
   
  Acesse o site oficial e baixe o instalador:
   
  🔗 https://www.postman.com/downloads/
   
### 3. Importar a collection

  1. Abra o Postman.
  
  2. Clique em "Import" (no canto superior esquerdo).
  
  3. Vá até a aba "File".
  
  4. Clique em "Upload Files".
  
  5. Selecione o arquivo BookCatalogSystem.postman_collection.json.
  
  6. Clique em "Import".
     
---

## 👨‍💻 Autor

Desenvolvido por Vitor Fidelis
