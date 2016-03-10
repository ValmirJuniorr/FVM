package fvm.model.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Valmir
 */
public class JPA {
	

    private static JPA controller;
    private static final String PERSISTENCE_UNIT = "FVM";
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private JPA() {
        entityManager = getEntityManeger();
    }

    public static JPA getStance() {
        if (controller == null) {
            controller = new JPA();
            entityManager = getEntityManeger();
        }
        return controller;
    }

    public boolean add(Entidade entidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                System.out.println(" Fez Rolback");
            }
            entityManager.clear();
            closeEntityManagerFactory();
            entityManager = getEntityManeger();
            System.out.println(" Fechou o maneger");
            e.printStackTrace();
            throw new RuntimeException("Erro Ao Atualizar registro no banco de dados");
        }

    }

    public boolean alter(Entidade oldEntidade, Entidade newEntidade) {

        try {
            entityManager.getTransaction().begin();
            oldEntidade.atualizarDados(newEntidade);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {        	
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.clear();
            entityManager.close();
            entityManager = getEntityManeger();
            throw new RuntimeException("Erro Ao Atualizar registro no banco de dados");
        }
    }

    public boolean delete(Entidade entidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entidade);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {        	
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.clear();
            entityManager.close();
            entityManager = getEntityManeger();
            throw new RuntimeException("Erro Ao remover registro no banco de dados");            
        }
    }

    public Query createQuery(String query) {
        try {
            return entityManager.createQuery(query);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar obter registros do banco de dados");
        }
    }

    public static EntityManager getEntityManeger() {
        try {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            }
            if (entityManager == null || !entityManager.isOpen()) {
                entityManager = entityManagerFactory.createEntityManager();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            if (transaction.isActive()) {
                transaction.commit();
            }
            entityManager.close();
        }
    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        entityManagerFactory.close();
    }
    
}
