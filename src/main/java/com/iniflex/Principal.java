package com.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {

        System.out.println("=".repeat(120));
        System.out.println("DESAFIO PRÁTICO INIFLEX");
        System.out.println("=".repeat(120));

        // 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela
        System.out.println("\n>>> 3.1 - Inserindo funcionários da tabela");
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"),  "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990, 5, 12),  new BigDecimal("2284.38"),  "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961, 5, 2),   new BigDecimal("9836.14"),  "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995, 1, 5),   new BigDecimal("2234.68"),  "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),  "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993, 3, 31),  new BigDecimal("4071.84"),  "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994, 7, 8),   new BigDecimal("3017.45"),  "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),  new BigDecimal("1606.85"),  "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),   new BigDecimal("2799.93"),  "Gerente"));
        System.out.println("Total de funcionários inseridos: " + funcionarios.size());

        // 3.2 - Remover o funcionário "João" da lista
        System.out.println("\n>>> 3.2 - Removendo o funcionário João...");
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));
        System.out.println("Total de funcionários após remoção: " + funcionarios.size());

        // 3.3 - Imprimir todos os funcionários com todas suas informações formatadas
        System.out.println("\n>>> 3.3 - Imprimindo todos os funcionários com informações formatadas");
        System.out.println("-".repeat(120));
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
        System.out.println("-".repeat(120));

        // 3.4 - Os funcionários receberam 10% de aumento de salário
        System.out.println("\n>>> 3.4 - Aplicando aumento de 10% nos salários...");
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10")).setScale(2, RoundingMode.HALF_UP);
            f.setSalario(novoSalario);
        }
        System.out.println("Aumento aplicado a todos os funcionários.");

        // 3.5 - Agrupar os funcionários por função em um MAP
        System.out.println("\n>>> 3.5 - Agrupando funcionários por função em Map...");
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao, LinkedHashMap::new, Collectors.toList()));
        System.out.println("Agrupamento concluído.");

        // 3.6 - Imprimir os funcionários, agrupados por função
        System.out.println("\n>>> 3.6 - Imprimindo funcionários agrupados por função");
        System.out.println("-".repeat(120));
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\n  Função: " + entry.getKey().toUpperCase());
            for (Funcionario f : entry.getValue()) {
                System.out.println("    -> " + f.getNome() + " | Salário: R$ " + f.formatarSalario());
            }
        }
        System.out.println("-".repeat(120));

        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\n>>> 3.8 - Aniversariantes dos meses 10 (Outubro) e 12 (Dezembro)");
        System.out.println("-".repeat(120));
        boolean temAniversariante = false;
        for (Funcionario f : funcionarios) {
            Month mes = f.getDataNascimento().getMonth();
            if (mes == Month.OCTOBER || mes == Month.DECEMBER) {
                System.out.println(f);
                temAniversariante = true;
            }
        }
        if (!temAniversariante) {
            System.out.println("Nenhum aniversariante encontrado nesses meses.");
        }
        System.out.println("-".repeat(120));

        // 3.9 - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade
        System.out.println("\n>>> 3.9 - Funcionário com a maior idade");
        System.out.println("-".repeat(120));
        Funcionario maisVelho = null;
        long maiorIdade = -1;
        for (Funcionario f : funcionarios) {
            long idade = f.calcularIdade();
            if (idade > maiorIdade) {
                maiorIdade = idade;
                maisVelho = f;
            }
        }
        if (maisVelho != null) {
            System.out.printf("Funcionário mais velho: %s - Idade: %d anos%n", maisVelho.getNome(), maiorIdade);
        }
        System.out.println("-".repeat(120));

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        System.out.println("\n>>> 3.10 - Funcionários em ordem alfabética");
        System.out.println("-".repeat(120));
        List<Funcionario> ordenados = new ArrayList<>(funcionarios);
        ordenados.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario f : ordenados) {
            System.out.println(f);
        }
        System.out.println("-".repeat(120));

        // 3.11 - Imprimir o total dos salários dos funcionários
        System.out.println("\n>>> 3.11 - Total dos salários dos funcionários");
        System.out.println("-".repeat(120));
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        Funcionario aux = new Funcionario("Aux", LocalDate.now(), totalSalarios, "");
        System.out.println("Total de salários (após aumento de 10%): R$ " + aux.formatarSalario());
        System.out.println("-".repeat(120));

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        System.out.println("\n>>> 3.12 - Quantidade de salários mínimos por funcionário (Salário mínimo: R$ 1.212,00)");
        System.out.println("-".repeat(120));
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.printf("%-10s ganha %s salários mínimos.%n", f.getNome(), qtdSalarios.toString().replace(".", ","));
        }
        System.out.println("-".repeat(120));

        System.out.println("\nFim do desafio! ✔");
    }
}
