# Quantas responsabilidades diferentes você encontra nesta classe?

- 4 responsabilidades: calcular salário · gerar PDF · enviar e-mail · formatar relatório

# A coesão é alta ou baixa? 

- Baixa coesão: tem 4 responsabilidades distintas em uma classe só.

# Estime o CBO: quais classes externas ela usa?

- CBO estimado ≥ 4: FileWriter/PDF, SmtpClient, SimpleDateFormat, etc.

# Refatore! Divida em classes menores — dê nome e liste os métodos de cada

- 

Funcionario → nome, salarioBase, horasExtras, calcularSalario()
HoleriteService → gerarPDF(Funcionario f)
EmailService → enviarHolerite(Funcionario f)
RelatorioFormatter → formatar(Funcionario f)