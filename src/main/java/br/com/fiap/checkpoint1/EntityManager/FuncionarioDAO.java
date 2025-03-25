package br.com.fiap.checkpoint1.EntityManager;

import br.com.fiap.checkpoint1.model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe DAO (Data Access Object) responsável por gerenciar as operações
 * de persistência relacionadas à entidade Funcionario.
 * Utiliza JPA (Java Persistence API) para interação com o banco de dados.
 */
public class FuncionarioDAO {

    // Cria uma fábrica de EntityManager usando a unidade de persistência configurada
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

    /**
     * Salva um novo funcionário no banco de dados.
     * Realiza uma operação de INSERT.
     *
     * @param funcionario O funcionário a ser salvo
     */
    public static void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Busca um funcionário pelo seu ID no banco de dados.
     * Realiza uma operação de SELECT.
     *
     * @param id O ID do funcionário a ser buscado
     * @return O funcionário encontrado ou null se não existir
     */
    public static Funcionario buscar(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     * Realiza uma operação de UPDATE.
     *
     * @param funcionario O funcionário com os dados atualizados
     */
    public static void atualizar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Remove um funcionário do banco de dados pelo seu ID.
     * Realiza uma operação de DELETE.
     *
     * @param id O ID do funcionário a ser removido
     */
    public static void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
}
