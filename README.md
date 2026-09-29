# 🏭 Desafio Prático Iniflex

Projeto Java desenvolvido como parte do processo seletivo da **Iniflex**. O objetivo é implementar um sistema de gerenciamento de funcionários de uma indústria, atendendo a todos os requisitos listados no teste prático.

---

## 📋 Descrição do Desafio

Considerando que uma indústria possui as pessoas/funcionários abaixo, foi solicitado o desenvolvimento de um projeto Java com os seguintes requisitos:

| Nome     | Data Nascimento | Salário  | Função        |
|----------|-----------------|----------|---------------|
| Maria    | 18/10/2000      | 2009.44  | Operador      |
| João     | 12/05/1990      | 2284.38  | Operador      |
| Caio     | 02/05/1961      | 9836.14  | Coordenador   |
| Miguel   | 14/10/1988      | 19119.88 | Diretor       |
| Alice    | 05/01/1995      | 2234.68  | Recepcionista |
| Heitor   | 19/11/1999      | 1582.72  | Operador      |
| Arthur   | 31/03/1993      | 4071.84  | Contador      |
| Laura    | 08/07/1994      | 3017.45  | Gerente       |
| Heloísa  | 24/05/2003      | 1606.85  | Eletricista   |
| Helena   | 02/09/1996      | 2799.93  | Gerente       |

---

## ✅ Requisitos Implementados

### 1. Classe Pessoa
- Atributos: `nome` (String) e `dataNascimento` (LocalDate)

### 2. Classe Funcionário
- Estende a classe Pessoa
- Atributos adicionais: `salario` (BigDecimal) e `funcao` (String)

### 3. Classe Principal (executa as ações)

| Item | Ação                                                                 | Status |
|------|----------------------------------------------------------------------|--------|
| 3.1  | Inserir todos os funcionários na ordem da tabela                     | ✅     |
| 3.2  | Remover o funcionário "João" da lista                                | ✅     |
| 3.3  | Imprimir todos os funcionários com formatação de data e salário BR   | ✅     |
| 3.4  | Aplicar aumento de 10% nos salários                                  | ✅     |
| 3.5  | Agrupar os funcionários por função em um `Map`                       | ✅     |
| 3.6  | Imprimir os funcionários agrupados por função                        | ✅     |
| 3.8  | Imprimir aniversariantes dos meses 10 (Outubro) e 12 (Dezembro)      | ✅     |
| 3.9  | Imprimir o funcionário com a maior idade (nome + idade)              | ✅     |
| 3.10 | Imprimir a lista de funcionários em ordem alfabética                 | ✅     |
| 3.11 | Imprimir o total dos salários dos funcionários                       | ✅     |
| 3.12 | Imprimir quantos salários mínimos (R$ 1.212,00) cada um ganha        | ✅     |

> ⚠️ Observação: o enunciado do desafio não possui o item **3.7**, pulando diretamente do 3.6 para o 3.8.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17** (LTS) — versão compatível com o suporte de longo prazo
- **Maven** — gerenciamento de build e dependências
- **LocalDate / ChronoUnit** — API moderna de datas do Java
- **BigDecimal** — manipulação precisa de valores monetários
- **Stream API + Collectors** — agrupamento e operações em coleções
- **IntelliJ IDEA** — IDE recomendada (compatível também com Eclipse e VS Code)

---

## 📁 Estrutura do Projeto

```
Desafio_Pratico_Iniflex/
├── pom.xml                                # Configuração Maven
├── README.md                              # Este arquivo
└── src
    └── main
        └── java
            └── com
                └── iniflex
                    ├── Pessoa.java       # Classe mãe (nome + dataNascimento)
                    ├── Funcionario.java   # Herda Pessoa (+ salario, funcao)
                    └── Principal.java     # Classe main (toda a lógica)
```

---

## 🚀 Como Executar

### Pré-requisitos
- ☕ **JDK 17+** instalado e configurado no PATH
- (Opcional) **Maven 3.8+** — se quiser rodar via Maven

### Opção 1 — Via Terminal (mais rápido, sem IDE)

```bash
# 1. Entrar na pasta do projeto
cd Desafio_Pratico_Iniflex

# 2. Compilar os arquivos .java
javac -encoding UTF-8 -d out src/main/java/com/iniflex/*.java

# 3. Executar a classe Principal
java -cp out com.iniflex.Principal
```

### Opção 2 — Via IntelliJ IDEA / Eclipse / VS Code

1. **IntelliJ**: File → Open → selecione a pasta do projeto (o Maven é detectado automaticamente)
2. Abra o arquivo `src/main/java/com/iniflex/Principal.java`
3. Clique com o botão direito → **Run 'Principal.main()'** (ou no ícone ▶️ ao lado do método `main`)

### Opção 3 — Via Maven

```bash
mvn clean package
java -jar target/desafio-pratico-1.0-SNAPSHOT.jar
```

---

## 📊 Saída Esperada (Exemplo)

```
========================================================================================================================
DESAFIO PRÁTICO INIFLEX
========================================================================================================================

>>> 3.1 - Inserindo funcionários da tabela
Total de funcionários inseridos: 10

>>> 3.2 - Removendo o funcionário João...
Total de funcionários após remoção: 9

>>> 3.3 - Imprimindo todos os funcionários com informações formatadas
Nome: Maria      | Data Nascimento: 18/10/2000   | Salário: R$ 2.009,44        | Função: Operador
Nome: Caio       | Data Nascimento: 02/05/1961   | Salário: R$ 9.836,14        | Função: Coordenador
...

>>> 3.8 - Aniversariantes dos meses 10 (Outubro) e 12 (Dezembro)
-> Maria   (18/10/2000)
-> Miguel  (14/10/1988)

>>> 3.9 - Funcionário com a maior idade
Funcionário mais velho: Caio - Idade: 65 anos

>>> 3.11 - Total dos salários dos funcionários
Total de salários (após aumento de 10%): R$ 50.906,82

>>> 3.12 - Quantidade de salários mínimos por funcionário
Maria      ganha 1,82 salários mínimos.
Caio       ganha 8,93 salários mínimos.
...
```

---

## 💡 Conceitos de POO e Java Aplicados

| Conceito               | Onde foi aplicado                                  |
|------------------------|----------------------------------------------------|
| **Herança**            | `Funcionario extends Pessoa`                       |
| **Encapsulamento**     | Atributos `private` + getters/setters              |
| **Polimorfismo**       | `toString()` sobrescrito em Funcionario            |
| **ArrayList**          | Lista mutável de funcionários                      |
| **Map / LinkedHashMap**| Agrupamento por função (mantém ordem de inserção)  |
| **Stream API**         | `Collectors.groupingBy()` no item 3.5              |
| **LocalDate**          | Datas sem timezone (melhor que a antiga java.util.Date) |
| **BigDecimal**         | Precisão exata para valores monetários             |
| **Comparator**         | Ordenação alfabética (item 3.10)                   |
| **Expressões Lambda**  | `removeIf(f -> ...)` e `groupingBy`                |

---

## 🤔 Por que BigDecimal e não double/float?

Os tipos primitivos `double` e `float` usam representação binária de ponto flutuante, o que causa **erros de arredondamento** para valores monetários. Exemplo:

```java
double a = 0.1;
double b = 0.2;
System.out.println(a + b); // Imprime: 0.30000000000000004 (errado!)
```

`BigDecimal` resolve esse problema sendo a classe **recomendada oficialmente pela documentação da Oracle** para valores financeiros.

---

## 📝 Observações

- O item **3.7** não existe no enunciado original do desafio (ele pula do 3.6 para o 3.8).
- A idade do funcionário mais velho é calculada dinamicamente com base na data atual (hoje).
- Todas as formatações seguem o padrão brasileiro:
  - Data: `dd/MM/aaaa`
  - Valores: **ponto (.)** para milhar e **vírgula (,)** para decimal (ex: R$ 19.119,88)
- O salário mínimo utilizado para o cálculo do item 3.12 é de **R$ 1.212,00** (conforme especificado no desafio).

---

## 👨‍💻 Autor

Desenvolvido por **André Chagas** — [GitHub](https://github.com/andre-chagas)
