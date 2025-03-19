package br.com.fiap.checkpoint1.utils;

import br.com.fiap.checkpoint1.annotations.Tabela;
import br.com.fiap.checkpoint1.annotations.Coluna;
import br.com.fiap.checkpoint1.model.Funcionario;

import java.lang.reflect.Field;

public class SQLGenerator {

    public static void gerarSQL(Class<?> clazz) {
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
        System.out.println("SQL Gerado: " + sql);
    }

    public static void main(String[] args) {
        gerarSQL(Funcionario.class);
    }
}

