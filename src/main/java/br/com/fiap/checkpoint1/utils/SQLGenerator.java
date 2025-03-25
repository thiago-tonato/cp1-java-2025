package br.com.fiap.checkpoint1.utils;

import br.com.fiap.checkpoint1.annotations.Tabela;
import br.com.fiap.checkpoint1.annotations.Coluna;
import br.com.fiap.checkpoint1.model.Funcionario;

import java.lang.reflect.Field;

public class SQLGenerator {

    public static void gerarSelectSQL(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder sql = new StringBuilder("SELECT ");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Coluna.class)) {
                Coluna coluna = fields[i].getAnnotation(Coluna.class);
                sql.append(coluna.nome());
                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }
        }

        sql.append(" FROM ").append(tabela.nome());
        System.out.println("SQL Gerado (SELECT): " + sql);
    }

    public static void gerarInsertSQL(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tabela.nome()).append(" (");

        StringBuilder values = new StringBuilder("VALUES (");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Coluna.class)) {
                Coluna coluna = fields[i].getAnnotation(Coluna.class);
                sql.append(coluna.nome());
                values.append("?"); // Placeholder for values
                if (i < fields.length - 1) {
                    sql.append(", ");
                    values.append(", ");
                }
            }
        }

        sql.append(") ").append(values).append(")");
        System.out.println("SQL Gerado (INSERT): " + sql);
    }

    public static void gerarDeleteSQL(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            System.out.println("A classe " + clazz.getSimpleName() + " não possui a anotação @Tabela.");
            return;
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        StringBuilder sql = new StringBuilder("DELETE FROM ").append(tabela.nome()).append(" WHERE id = ?");

        System.out.println("SQL Gerado (DELETE): " + sql);
    }

    public static void main(String[] args) {
        gerarSelectSQL(Funcionario.class);
        gerarInsertSQL(Funcionario.class);
        gerarDeleteSQL(Funcionario.class);
    }
}
