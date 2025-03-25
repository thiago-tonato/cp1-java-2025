package br.com.fiap.checkpoint1;

import br.com.fiap.checkpoint1.model.FuncGerente;
import br.com.fiap.checkpoint1.model.FuncSenior;
import br.com.fiap.checkpoint1.model.Funcionario;
import br.com.fiap.checkpoint1.EntityManager.FuncionarioDAO;
import br.com.fiap.checkpoint1.utils.SQLGenerator;

public class Main {
    public static void main(String[] args) {
        SQLGenerator.gerarSelectSQL(Funcionario.class);
        SQLGenerator.gerarInsertSQL(Funcionario.class);
        SQLGenerator.gerarDeleteSQL(Funcionario.class);

        FuncionarioDAO.salvar(new Funcionario("Carlos", 40, 50.0));
        FuncionarioDAO.salvar(new FuncSenior("Mariana", 45, 60.0));
        FuncionarioDAO.salvar(new FuncGerente("Roberto", 50, 80.0));

        Funcionario funcionario = FuncionarioDAO.buscar(1L);
        if (funcionario != null) {
            funcionario.imprimirInformacao();
        }
    }
}
