package br.com.fiap.checkpoint1;

import br.com.fiap.checkpoint1.model.FuncGerente;
import br.com.fiap.checkpoint1.model.FuncJunior;
import br.com.fiap.checkpoint1.model.FuncSenior;
import br.com.fiap.checkpoint1.model.Funcionario;
import br.com.fiap.checkpoint1.EntityManager.FuncionarioDAO;
import br.com.fiap.checkpoint1.utils.SQLGenerator;

/**
 * Classe principal que demonstra o uso das operações CRUD (Create, Read, Update, Delete)
 * utilizando o FuncionarioDAO para interação com o banco de dados
 */
public class Main {
    public static void main(String[] args) {
        // Demonstra a geração de queries SQL usando reflexão
        SQLGenerator.gerarSelectSQL(Funcionario.class);
        SQLGenerator.gerarInsertSQL(Funcionario.class);
        SQLGenerator.gerarDeleteSQL(Funcionario.class);

        System.out.println("\n=== Operações no Banco de Dados ===");
        
        // Operações de Inserção (Create)
        System.out.println("\n--- INSERT ---");
        // Cria diferentes tipos de funcionários no banco de dados
        FuncionarioDAO.salvar(new Funcionario("Carlos", 40, 50.0));
        FuncionarioDAO.salvar(new FuncSenior("Mariana", 45, 60.0));
        FuncionarioDAO.salvar(new FuncGerente("Roberto", 50, 80.0));

        // Operações de Consulta (Read)
        System.out.println("\n--- SELECT ---");
        // Busca um funcionário pelo ID
        Funcionario funcionario = FuncionarioDAO.buscar(1L);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            funcionario.imprimirInformacao();
        }

        // Operações de Atualização (Update)
        System.out.println("\n--- UPDATE  ---");
        if (funcionario != null) {
            // Atualiza os dados do funcionário
            funcionario.setNome("Carlos Silva");
            funcionario.setIdade(41);
            funcionario.setSalario(55.0);
            // Persiste as alterações no banco de dados
            FuncionarioDAO.atualizar(funcionario);
            System.out.println("Funcionário atualizado:");
            funcionario.imprimirInformacao();
        }

        // Operações de Exclusão (Delete)
        System.out.println("\n--- DELETE  ---");
        // Remove o funcionário do banco de dados
        FuncionarioDAO.deletar(1L);
        System.out.println("Funcionário com ID 1 foi deletado");

        // Verifica se o funcionário foi realmente excluído
        Funcionario funcionarioDeletado = FuncionarioDAO.buscar(1L);
        if (funcionarioDeletado == null) {
            System.out.println("Confirmação: Funcionário não existe mais no banco de dados");
        }
    }
}
