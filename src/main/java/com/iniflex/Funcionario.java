package com.iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @SuppressWarnings("unused")
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public long calcularIdade() {
        LocalDate hoje = LocalDate.now();
        return ChronoUnit.YEARS.between(this.getDataNascimento(), hoje);
    }

    public String formatarSalario() {
        StringBuilder sb = new StringBuilder();
        String valorStr = this.salario.setScale(2, RoundingMode.HALF_UP).toPlainString();

        String parteInteira;
        String parteDecimal;
        if (valorStr.contains(".")) {
            int idx = valorStr.indexOf(".");
            parteInteira = valorStr.substring(0, idx);
            parteDecimal = valorStr.substring(idx + 1);
        } else {
            parteInteira = valorStr;
            parteDecimal = "00";
        }

        StringBuilder inteiraFormatada = new StringBuilder();
        int count = 0;
        for (int i = parteInteira.length() - 1; i >= 0; i--) {
            if (count == 3) {
                inteiraFormatada.insert(0, ".");
                count = 0;
            }
            inteiraFormatada.insert(0, parteInteira.charAt(i));
            count++;
        }

        sb.append(inteiraFormatada).append(",").append(parteDecimal);
        return sb.toString();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Nome: %-10s | Data Nascimento: %-12s | Salário: R$ %-15s | Função: %s",
                this.getNome(),
                this.getDataNascimento().format(formatter),
                this.formatarSalario(),
                this.funcao);
    }
}
