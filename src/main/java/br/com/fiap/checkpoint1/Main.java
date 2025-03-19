package br.com.fiap.checkpoint1;

import br.com.fiap.checkpoint1.model.FuncGerente;
import br.com.fiap.checkpoint1.model.FuncSenior;
import br.com.fiap.checkpoint1.model.Funcionario;
import br.com.fiap.checkpoint1.utils.SQLGenerator;
import br.com.fiap.checkpoint1.EntityManager.FuncionarioDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManager em = emf.createEntityManager();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(em);

        Funcionario func1 = new Funcionario(1, "Carlos", 40, 50.0);
        FuncSenior func2 = new FuncSenior(2, "Mariana", 45, 60.0);
        FuncGerente func3 = new FuncGerente(3, "Roberto", 50, 80.0);

        System.out.println(func1);
        System.out.println(func2);
        System.out.println(func3);

        SQLGenerator.gerarSQL(Funcionario.class);
        SQLGenerator.gerarSQL(FuncSenior.class);
        SQLGenerator.gerarSQL(FuncGerente.class);

        funcionarioDAO.salvar(func1);
        funcionarioDAO.salvar(func2);
        funcionarioDAO.salvar(func3);

        funcionarioDAO.listarTodos().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
