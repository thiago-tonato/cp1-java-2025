package br.com.fiap.checkpoint1.EntityManager;

import br.com.fiap.checkpoint1.model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FuncionarioDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

    public static void salvar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public static Funcionario buscar(Long id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public static void atualizar(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

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
