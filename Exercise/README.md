# Exercise — Answers / Exercício — Respostas

> Selecione o idioma / Select your language:
> - [Português](#português)
> - [English](#english)

---

<a id="português"></a>
# 🇧🇷 Português

## Classe analisada: `LowEmployee.java`

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

---

### 1. Quantas responsabilidades diferentes você encontra nesta classe?

**4 responsabilidades:**

| # | Responsabilidade |
|---|---|
| 1 | Calcular salário |
| 2 | Gerar PDF do holerite |
| 3 | Enviar e-mail |
| 4 | Formatar relatório |

---

### 2. A coesão é alta ou baixa?

**Baixa coesão** — uma única classe acumula 4 responsabilidades de domínios completamente distintos. Qualquer mudança em qualquer área (PDF, e-mail, relatório) obriga a modificar essa mesma classe.

---

### 3. Estime o CBO — quais classes externas ela usa?

**CBO estimado ≥ 4:**

| Classe externa | Finalidade |
|---|---|
| `FileWriter` / lib PDF | Geração do holerite em PDF |
| `SmtpClient` | Envio de e-mail |
| `SimpleDateFormat` | Formatação de datas |
| Outras dependências implícitas | — |

---

### 4. Refatore! Divida em classes menores

| Classe | Atributos | Métodos |
|---|---|---|
| `Funcionario` | `nome`, `salarioBase`, `horasExtras` | `calcularSalario()` |
| `HoleriteService` | — | `gerarPDF(Funcionario f)` |
| `EmailService` | — | `enviarHolerite(Funcionario f)` |
| `RelatorioFormatter` | — | `formatar(Funcionario f)` |

---
---

<a id="english"></a>
# 🇺🇸 English

## Class under analysis: `LowEmployee.java`

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

---

### 1. How many different responsibilities do you find in this class?

**4 responsibilities:**

| # | Responsibility |
|---|---|
| 1 | Calculate salary |
| 2 | Generate pay stub PDF |
| 3 | Send email |
| 4 | Format report |

---

### 2. Is cohesion high or low?

**Low cohesion** — a single class accumulates 4 responsibilities from completely different domains. Any change in any area (PDF, email, report) forces a modification to this same class.

---

### 3. Estimate the CBO — what external classes does it use?

**Estimated CBO ≥ 4:**

| External Class | Purpose |
|---|---|
| `FileWriter` / PDF lib | Pay stub PDF generation |
| `SmtpClient` | Email sending |
| `SimpleDateFormat` | Date formatting |
| Other implicit dependencies | — |

---

### 4. Refactor! Split into smaller classes

| Class | Attributes | Methods |
|---|---|---|
| `Employee` | `name`, `baseSalary`, `extraHours` | `calculateSalary()` |
| `PayStubService` | — | `generatePDF(Employee e)` |
| `EmailService` | — | `sendPayStub(Employee e)` |
| `ReportFormatter` | — | `format(Employee e)` |
