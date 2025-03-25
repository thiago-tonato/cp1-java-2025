package br.com.fiap.checkpoint1.utils;

import br.com.fiap.checkpoint1.annotations.Tabela;
import br.com.fiap.checkpoint1.annotations.Coluna;
import br.com.fiap.checkpoint1.model.Funcionario;

import java.lang.reflect.Field;

/**
 * Classe utilitária que gera queries SQL dinamicamente usando reflexão e anotações.
 * Esta classe demonstra como as queries SQL seriam geradas para operações básicas
 * no banco de dados.
 */
public class SQLGenerator {

    /**
     * Gera uma query SQL SELECT para a classe especificada.
     * A query é gerada baseada nas anotações @Tabela e @Coluna da classe.
     *
     * @param clazz A classe para a qual a query SELECT será gerada
     */
    public static void gerarSelectSQL(Class<?> clazz) {
        // Verifica se a classe possui a anotação @Tabela
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        // Obtém a anotação @Tabela da classe
        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder sql = new StringBuilder("SELECT ");

        // Obtém todos os campos da classe
        Field[] fields = clazz.getDeclaredFields();
        // Itera sobre os campos para construir a query
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Coluna.class)) {
                Coluna coluna = fields[i].getAnnotation(Coluna.class);
                sql.append(coluna.nome());
                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }
        }

        // Completa a query com o nome da tabela
        sql.append(" FROM ").append(tabela.nome());
        System.out.println("SQL Gerado (SELECT): " + sql);
    }

    /**
     * Gera uma query SQL INSERT para a classe especificada.
     * A query é gerada baseada nas anotações @Tabela e @Coluna da classe.
     *
     * @param clazz A classe para a qual a query INSERT será gerada
     */
    public static void gerarInsertSQL(Class<?> clazz) {
        // Verifica se a classe possui a anotação @Tabela
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        // Obtém a anotação @Tabela da classe
        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tabela.nome()).append(" (");
        StringBuilder values = new StringBuilder("VALUES (");

        // Obtém todos os campos da classe
        Field[] fields = clazz.getDeclaredFields();
        // Itera sobre os campos para construir a query
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Coluna.class)) {
                Coluna coluna = fields[i].getAnnotation(Coluna.class);
                sql.append(coluna.nome());
                values.append("?"); // Placeholder para valores
                if (i < fields.length - 1) {
                    sql.append(", ");
                    values.append(", ");
                }
            }
        }

        // Completa a query com os valores
        sql.append(") ").append(values).append(")");
        System.out.println("SQL Gerado (INSERT): " + sql);
    }

    /**
     * Gera uma query SQL DELETE para a classe especificada.
     * A query é gerada baseada na anotação @Tabela da classe.
     *
     * @param clazz A classe para a qual a query DELETE será gerada
     */
    public static void gerarDeleteSQL(Class<?> clazz) {
        // Verifica se a classe possui a anotação @Tabela
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        // Obtém a anotação @Tabela da classe
        Tabela tabela = clazz.getAnnotation(Tabela.class);
        // Gera a query DELETE com condição WHERE para o ID
        StringBuilder sql = new StringBuilder("DELETE FROM ").append(tabela.nome()).append(" WHERE id = ?");

        System.out.println("SQL Gerado (DELETE): " + sql);
    }

    /**
     * Método principal para demonstração da geração de queries SQL.
     * Gera queries SELECT, INSERT e DELETE para a classe Funcionario.
     */
    public static void main(String[] args) {
        gerarSelectSQL(Funcionario.class);
        gerarInsertSQL(Funcionario.class);
        gerarDeleteSQL(Funcionario.class);
    }
}
