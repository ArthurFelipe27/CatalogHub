# 🛒 Sistema de Cadastro de Produtos

![GitHub repo size](https://img.shields.io/github/repo-size/ArthurFelipe27/CatalogHub?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/ArthurFelipe27/CatalogHub?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/ArthurFelipe27/CatalogHub?style=for-the-badge)
![License](https://img.shields.io/github/license/ArthurFelipe27/CatalogHub?style=for-the-badge)

> Sistema web para **cadastro e gerenciamento de produtos**, desenvolvido com **Spring Boot e Thymeleaf**, oferecendo operações CRUD completas, filtros por categoria e interface moderna e responsiva.

---

## ✨ Funcionalidades Principais

* 📝 **Cadastro de Produtos**  
  Formulário com validação de dados utilizando **Spring Validation**.

* 📋 **Listagem de Produtos**  
  Exibição dos produtos em tabela organizada, com suporte a filtros.

* ✏️ **Edição de Produtos**  
  Atualização das informações de produtos já cadastrados.

* ❌ **Exclusão com Confirmação**  
  Remoção segura de produtos do sistema.

* 🔍 **Filtro por Categoria**  
  Visualização de produtos por categoria específica via parâmetros de URL.

* ⚡ **Alertas Dinâmicos**  
  Mensagens visuais de sucesso exibidas diretamente nas páginas.

* 📱 **Design Responsivo**  
  Interface moderna construída com **Bootstrap 5**.

---

## 💻 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

* ☕ **Java JDK 17 ou superior**
* 🧰 **Maven** (ou Maven Wrapper incluído)
* 🐬 **MySQL** em execução local

---

## 🚀 Tecnologias Utilizadas

### 🧩 Backend

* ☕ **Java 17**
* ⚙️ **Spring Boot 3**
* 🌐 **Spring Web**
* 🗄️ **Spring Data JPA**
* 🔄 **Hibernate (ORM)**
* ✅ **Spring Validation**

### 🎨 Frontend

* 🧱 **Thymeleaf**
* 💅 **Bootstrap 5**

### 🗃️ Banco de Dados

* 🐬 **MySQL**

### 🔧 Build

* 🧰 **Maven**

---

## ⚙️ Como Executar o Projeto

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

---

### 2️⃣ Configure o Banco de Dados

Crie o banco no MySQL:

```sql
CREATE DATABASE produtosdb;
```

Configure o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/produtosdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=create
```

> ⚠️ Em produção, utilize `spring.jpa.hibernate.ddl-auto=update`.

---

### 3️⃣ Execute a aplicação

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

Ou execute diretamente pela IDE a classe:

```
ExemplosistemaApplication.java
```

---

### 4️⃣ Acesse a aplicação

* 🧾 Cadastro: http://localhost:8080/cadastro  
* 📃 Listagem: http://localhost:8080/listar  

---

## 📂 Estrutura de Pastas

```text
exemplosistema/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/sistema/crud/exemplosistema/
│   │   │   ├── Categoria.java
│   │   │   ├── Produto.java
│   │   │   ├── ProdutoController.java
│   │   │   ├── ProdutoDTO.java
│   │   │   ├── ProdutoMapper.java
│   │   │   ├── ProdutoRepository.java
│   │   │   └── ExemplosistemaApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   ├── listar.html
│   │       │   └── editar.html
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw / mvnw.cmd
├── .gitignore
└── README.md
```

---

## 🛣️ Endpoints da Aplicação

| Método | Endpoint       | Descrição |
|------|---------------|-----------|
| GET  | /cadastro     | Exibe o formulário |
| POST | /cadastro     | Salva um produto |
| GET  | /listar       | Lista produtos |
| GET  | /editar/{id}  | Formulário de edição |
| POST | /editar/{id}  | Atualiza o produto |
| GET  | /excluir/{id} | Exclui o produto |

---

## 📸 Demonstração

<img width="1080" height="720" alt="Tela de Cadastro" src="https://github.com/user-attachments/assets/b6975175-dc16-4ffc-8e90-05b80a3daeab" />

<img width="1080" height="720" alt="Tela de Listagem" src="https://github.com/user-attachments/assets/52fa898c-4cc2-403b-b071-79688aa369ac" />

---

## 🧑‍💻 Autor

**Arthur Felipe**  
📧 Email: arthurfelipedasilvamatosdev@gmail.com  
🌐 GitHub: https://github.com/ArthurFelipe27

---

## 📝 Licença

Este projeto está licenciado sob a **Licença MIT**.

---

💡 Projeto desenvolvido como exemplo de sistema CRUD completo com **Spring Boot e Thymeleaf**.
