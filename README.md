# SRP Exercise 02 - Order Processing System

A Java application demonstrating the **Single Responsibility Principle (SRP)** from SOLID principles through an order processing system.

## 📋 Table of Contents

- [About](#about)
- [Project Structure](#project-structure)
- [SRP Implementation](#srp-implementation)
- [Documentation](#documentation)
- [Getting Started](#getting-started)
- [Author](#author)
- [Credits](#credits)

## 📖 About

This project is an educational exercise that showcases how to apply the **Single Responsibility Principle (SRP)** in a real-world scenario. The application simulates an e-commerce order processing workflow, including:

- Stock validation
- Tax and shipping calculation
- Order persistence
- Customer notification

Each responsibility is encapsulated in its own dedicated class, making the codebase maintainable, testable, and easy to extend.

## 🗂️ Project Structure

```
src/
└── main/
    ├── java/
    │   └── pablo/tzeliks/
    │       ├── Aplicacao.java                              # Main application entry point
    │       ├── model/
    │       │   └── Pedido.java                             # Order entity (data model)
    │       ├── repository/
    │       │   └── RepositorioDePedido.java                # Data persistence layer
    │       └── service/
    │           ├── CalculadoraDeTaxas.java                 # Tax and shipping calculator
    │           ├── NotificadorDePedido.java                # Customer notification service
    │           ├── ServicoDeProcessamentoDePedido.java     # Order processing orchestrator
    │           └── ValidadorDeEstoque.java                 # Stock validation service
    └── resources/
        └── JavaDoc/                                        # Generated API documentation
```

## 🎯 SRP Implementation

The **Single Responsibility Principle** states that a class should have only one reason to change. This project demonstrates SRP by separating concerns into distinct classes:

| Class | Responsibility | Reason to Change |
|-------|---------------|------------------|
| `Pedido` | Data model for order information | Changes only if order attributes change |
| `ValidadorDeEstoque` | Stock availability validation | Changes only if validation rules change |
| `CalculadoraDeTaxas` | Financial calculations (taxes, shipping) | Changes only if tax rates or shipping rules change |
| `RepositorioDePedido` | Database persistence | Changes only if storage technology changes |
| `NotificadorDePedido` | Customer notifications | Changes only if notification channel changes |
| `ServicoDeProcessamentoDePedido` | Workflow orchestration | Changes only if the processing flow changes |

### Design Patterns Used

- **Service Layer Pattern**: `ServicoDeProcessamentoDePedido` acts as a facade, coordinating the workflow
- **Dependency Injection**: Dependencies are injected via constructor, enabling loose coupling and testability
- **Repository Pattern**: `RepositorioDePedido` abstracts data access operations

### Benefits of This Architecture

1. **Maintainability**: Each class has a single, well-defined purpose
2. **Testability**: Classes can be unit tested in isolation with mock dependencies
3. **Flexibility**: Individual components can be replaced without affecting others
4. **Readability**: Code is organized logically and easy to understand

## 📚 Documentation

This project includes comprehensive **JavaDoc** documentation for all classes and methods. The generated documentation is available at:

```
src/main/resources/JavaDoc/index.html
```

To view the documentation, open `index.html` in your web browser.

### Documentation Highlights

- All public classes and methods are documented
- Each class includes its responsibility and "reason to change"
- Parameters, return values, and exceptions are thoroughly described

## 🚀 Getting Started

### Prerequisites

- **Java 22** or higher
- **Maven 3.6+** (for dependency management and build)

### Building the Project

```bash
# Clone the repository
git clone https://github.com/PabloTzeliks/srp-exercise-02.git
cd srp-exercise-02

# Compile the project
mvn compile

# Run the application
mvn exec:java -Dexec.mainClass="pablo.tzeliks.Aplicacao"
```

### Expected Output

```
--- INICIANDO PROCESSAMENTO DO PEDIDO ---
-> Validação de estoque OK.
-> Frete (R$50.0) e Impostos (R$67.5) calculados.
-> Persistência: Pedido PED-789 salvo no banco de dados.
-> Notificação: Email de confirmação enviado para: lucas.ecom@techstore.com

--- RESULTADO FINAL ---
Status do Pedido PED-789: PAGO
Valor Bruto: R$450.0
Valor Final (com taxas): R$567.5
```

## 👤 Author

**Pablo Ruan Tzeliks**

- GitHub: [@PabloTzeliks](https://github.com/PabloTzeliks)
- Email: arq.pabloo@gmail.com

Responsible for:
- Code refactoring and adjustments
- Complete JavaDoc documentation
- Application of SOLID principles

## 🙏 Credits

The original logic and class structure were developed by:

**Professor Lucas Santos**
- GitHub: [@engineer-lucas](https://github.com/engineer-lucas)

---

## 📄 License

This project is for educational purposes.

---

*This README was created as part of an exercise demonstrating the Single Responsibility Principle (SRP) from SOLID design principles.*
