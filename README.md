# Coesão e Acoplamento em Java / Cohesion and Coupling in Java

> Selecione o idioma / Select your language:
> - [Português](#português)
> - [English](#english)
---

<a id="português"></a>
# 🇧🇷 Português

## Sobre o Projeto

Este projeto demonstra, com exemplos práticos em Java, os conceitos de **coesão** e **acoplamento** — dois dos princípios mais importantes para garantir a qualidade de um software.

---

## Conceitos

### Coesão

Coesão mede o quanto as responsabilidades de uma classe estão relacionadas entre si. Uma classe com **alta coesão** faz uma coisa só e faz bem. Uma classe com **baixa coesão** mistura responsabilidades que não pertencem ao mesmo domínio.

#### Baixa Coesão — [`LowCohesion/Database.java`](LowCohesion/Database.java)

```
Database
├── connect()         → responsabilidade de banco de dados
├── consult(sql)      → responsabilidade de banco de dados
├── saveLog(msg)      → responsabilidade de log
├── formatDate(date)  → responsabilidade de formatação
└── sendAlert(email)  → responsabilidade de e-mail
```

Uma única classe acumula 5 responsabilidades de domínios completamente diferentes. Qualquer mudança em qualquer área (log, e-mail, datas) obriga a modificar essa classe.

#### Alta Coesão — [`HighCohesion/`](HighCohesion/)

| Classe | Responsabilidade única |
|---|---|
| [`MySQLConnection.java`](HighCohesion/MySQLConnection.java) | Gerenciar a conexão com o banco |
| [`LogService.java`](HighCohesion/LogService.java) | Gravar e consultar logs |
| [`EmailService.java`](HighCohesion/EmailService.java) | Enviar alertas por e-mail |
| [`DateFormatter.java`](HighCohesion/DateFormatter.java) | Formatar e obter datas |


---

### Acoplamento

Acoplamento mede o quanto uma classe depende de outra. **Baixo acoplamento** significa que as classes se comunicam por abstrações (interfaces), facilitando trocas e testes. **Alto acoplamento** ocorre quando uma classe conhece os detalhes concretos de outra, criando dependências rígidas.

#### Alto Acoplamento — [`HighCoupling/Order.java`](HighCoupling/Order.java)

```java
public class Order {
    private MySQLRepository db    = new MySQLRepository(); // concreto
    private SmtpEmail       email = new SmtpEmail();       // concreto

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
```

`Order` instancia diretamente as classes concretas. Para trocar o banco por PostgreSQL ou o e-mail por SendGrid, é preciso **editar** a classe `Order`. Testes sem banco real são impossíveis sem alterar o código.

#### Baixo Acoplamento — [`LowCoupling/Order.java`](LowCoupling/Order.java)

```java
public class Order {
    private final DatabaseRepositoryInterface db;
    private final EmailRepositoryInterface    email;

    public Order(DatabaseRepositoryInterface db, EmailRepositoryInterface email) {
        this.db    = db;
        this.email = email;
    }

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
```

`Order` depende apenas de interfaces. A implementação concreta é **injetada de fora** (Dependency Injection). Para trocar o banco ou o e-mail, basta passar uma nova implementação — `Order` não precisa ser modificada.

---


### Comparativo

| | Baixa Coesão | Alta Coesão |
|---|---|---|
| Responsabilidades | Muitas, misturadas | Uma por classe |
| Manutenção | Difícil — uma mudança afeta tudo | Fácil — mudanças isoladas |
| Reuso | Baixo | Alto |

| | Alto Acoplamento | Baixo Acoplamento |
|---|---|---|
| Dependência | Classes concretas (`new X()`) | Interfaces / Injeção |
| Testabilidade | Difícil (precisa do real) | Fácil (usa mocks) |
| Flexibilidade | Rígido | Flexível |


## Exercício — [`Exercise/`](Exercise/)

### Classe analisada: [`LowEmployee.java`](Exercise/LowEmployee.java)

```java
public class LowEmployee {
    private String name;
    private double baseSalary;
    private int    extraHours;
    private String payStubFile = "C:\\holertes\\holerite.pdf";
    private String hrEMail     = "rh@empresa.com";

    public double calculateSalary()   { ... }
    public void   generatePayStupPDF(){ ... }
    public void   sendPayStupEmail()  { ... }
    public String formatReport()      { ... }
}
```

### Perguntas e respostas — [`Exercise/README.md`](Exercise/README.md)

**1. Quantas responsabilidades diferentes você encontra nesta classe?**
> **4 responsabilidades:** calcular salário · gerar PDF · enviar e-mail · formatar relatório

**2. A coesão é alta ou baixa?**
> **Baixa coesão:** uma única classe acumula 4 responsabilidades de domínios distintos.

**3. Estime o CBO — quais classes externas ela usa?**
> **CBO estimado ≥ 4:** FileWriter/PDF, SmtpClient, SimpleDateFormat, e outras dependências implícitas.

**4. Refatore! Divida em classes menores — dê nome e liste os métodos de cada**

| Classe | Atributos | Métodos |
|---|---|---|
| `Funcionario` | `nome`, `salarioBase`, `horasExtras` | `calcularSalario()` |
| `HoleriteService` | — | `gerarPDF(Funcionario f)` |
| `EmailService` | — | `enviarHolerite(Funcionario f)` |
| `RelatorioFormatter` | — | `formatar(Funcionario f)` |

---

## Estrutura do Projeto

```
ExercicioCoesao/
├── LowCohesion/
│   └── Database.java           ← exemplo de BAIXA coesão
├── HighCohesion/
│   ├── MySQLConnection.java    ← exemplo de ALTA coesão
│   ├── LogService.java
│   ├── EmailService.java
│   └── DateFormatter.java
├── LowCoupling/
│   ├── Order.java              ← exemplo de ALTO acoplamento
│   ├── MySQLRepository.java
│   └── SmtpEmail.java
├── HighCoupling/
│   ├── Order.java              ← exemplo de BAIXO acoplamento
│   ├── DatabaseRepositoryInterface.java
│   └── EmailRepositoryInterface.java
└── Exercise/
    ├── LowEmployee.java        ← classe para análise
    └── README.md               ← respostas do exercício
```

---
---

<a id="english"></a>
# 🇺🇸 English

## About the Project

This project demonstrates, through practical Java examples, the concepts of **cohesion** and **coupling** — two of the most important principles to assure a software quality

## Concepts

### Cohesion

Cohesion measures how closely related the responsibilities of a class are. A **highly cohesive** class does one thing and does it well. A class with **low cohesion** mixes responsibilities that don't belong to the same domain.

#### Low Cohesion — [`LowCohesion/Database.java`](LowCohesion/Database.java)

```
Database
├── connect()         → database responsibility
├── consult(sql)      → database responsibility
├── saveLog(msg)      → logging responsibility
├── formatDate(date)  → formatting responsibility
└── sendAlert(email)  → email responsibility
```

A single class accumulates 5 responsibilities from completely different domains. Any change in any area (logging, email, dates) forces a modification to this class.


#### High Cohesion — [`HighCohesion/`](HighCohesion/)

| Class | Single Responsibility |
|---|---|
| [`MySQLConnection.java`](HighCohesion/MySQLConnection.java) | Manage the database connection |
| [`LogService.java`](HighCohesion/LogService.java) | Write and query logs |
| [`EmailService.java`](HighCohesion/EmailService.java) | Send email alerts |
| [`DateFormatter.java`](HighCohesion/DateFormatter.java) | Format and retrieve dates |

Each class has a single reason to exist. Changes to logging do not affect email, and vice versa.

---

### Coupling

Coupling measures how much one class depends on another. **Low coupling** means classes communicate through abstractions (interfaces), making swaps and testing easier. **High coupling** occurs when a class knows the concrete details of another, creating rigid dependencies.

#### High Coupling — [`HighCoupling/Order.java`](HighCoupling/Order.java)

```java
public class Order {
    private MySQLRepository db    = new MySQLRepository(); // concrete
    private SmtpEmail       email = new SmtpEmail();       // concrete

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
```

`Order` directly instantiates concrete classes. To switch from MySQL to PostgreSQL or from SMTP to SendGrid, you must **edit** the `Order` class. Writing tests without a real database is impossible without changing the code.

#### Low Coupling — [`LowCoupling/Order.java`](LowCoupling/Order.java)

```java
public class Order {
    private final DatabaseRepositoryInterface db;
    private final EmailRepositoryInterface    email;

    public Order(DatabaseRepositoryInterface db, EmailRepositoryInterface email) {
        this.db    = db;
        this.email = email;
    }

    public void finish() {
        db.save(this);
        email.send(this);
    }
}
```
`Order` depends only on interfaces. The concrete implementation is **injected from outside** (Dependency Injection). To swap the database or email provider, just pass a new implementation — `Order` does not need to change.

---

### Comparison

| | Low Cohesion | High Cohesion |
|---|---|---|
| Responsibilities | Many, mixed together | One per class |
| Maintenance | Hard — one change affects everything | Easy — changes are isolated |
| Reusability | Low | High |

| | High Coupling | Low Coupling |
|---|---|---|
| Dependency | Concrete classes (`new X()`) | Interfaces / Injection |
| Testability | Hard (requires real infrastructure) | Easy (uses mocks) |
| Flexibility | Rigid | Flexible |

---

## Exercise — [`Exercise/`](Exercise/)

### Class under analysis: [`LowEmployee.java`](Exercise/LowEmployee.java)

```java
public class LowEmployee {
    private String name;
    private double baseSalary;
    private int    extraHours;
    private String payStubFile = "C:\\holertes\\holerite.pdf";
    private String hrEMail     = "rh@empresa.com";

    public double calculateSalary()   { ... }
    public void   generatePayStupPDF(){ ... }
    public void   sendPayStupEmail()  { ... }
    public String formatReport()      { ... }
}
```

### Questions and answers — [`Exercise/README.md`](Exercise/README.md)

**1. How many different responsibilities do you find in this class?**
> **4 responsibilities:** calculate salary · generate PDF · send email · format report

**2. Is cohesion high or low?**
> **Low cohesion:** a single class accumulates 4 responsibilities from distinct domains.

**3. Estimate the CBO — what external classes does it use?**
> **Estimated CBO ≥ 4:** FileWriter/PDF, SmtpClient, SimpleDateFormat, and other implicit dependencies.

**4. Refactor! Split into smaller classes — name each and list its methods**

| Class | Attributes | Methods |
|---|---|---|
| `Employee` | `name`, `baseSalary`, `extraHours` | `calculateSalary()` |
| `PayStubService` | — | `generatePDF(Employee e)` |
| `EmailService` | — | `sendPayStub(Employee e)` |
| `ReportFormatter` | — | `format(Employee e)` |

---

## Project Structure

```
ExercicioCoesao/
├── LowCohesion/
│   └── Database.java           ← LOW cohesion example
├── HighCohesion/
│   ├── MySQLConnection.java    ← HIGH cohesion example
│   ├── LogService.java
│   ├── EmailService.java
│   └── DateFormatter.java
├── LowCoupling/
│   ├── Order.java              ← HIGH coupling example
│   ├── MySQLRepository.java
│   └── SmtpEmail.java
├── HighCoupling/
│   ├── Order.java              ← LOW coupling example
│   ├── DatabaseRepositoryInterface.java
│   └── EmailRepositoryInterface.java
└── Exercise/
    ├── LowEmployee.java        ← class for analysis
    └── README.md               ← exercise answers
```

