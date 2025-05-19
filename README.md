# ☕ CoffeeBank - Customer Service

O **CoffeeBank** é uma aplicação bancária construída com arquitetura de **microservices**. Este repositório representa o **microserviço de Titular da Conta (Customer Service)**, responsável por gerenciar os dados de clientes e orquestrar a criação de contas bancárias via integração com o **Account Service**.

---

## 📌 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Security
- Spring Data MongoDB
- MapStruct
- Lombok
- Jakarta Bean Validation
- Maven

---

## 🧩 Arquitetura

O CoffeeBank é baseado em uma arquitetura de **microservices** com os seguintes componentes:

- **Gateway**: Responsável por receber as requisições externas e roteá-las para os microservices.
- **Customer Service**: Cria e gerencia os dados dos titulares.
- **Account Service**: Cria contas bancárias vinculadas ao `idCustomer`.


