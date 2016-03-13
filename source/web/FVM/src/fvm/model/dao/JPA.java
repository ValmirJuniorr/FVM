package fvm.model.dao;




/**
 *
 * @author Valmir
 */
public class JPA {/*
	

    private static JPA jpa;
    private static final String PERSISTENCE_UNIT = "FVM";
    
    @PersistenceContext
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private JPA() {
        entityManager = getEntityManeger();
    }

    public static JPA getStance() {
        if (jpa == null) {
            jpa = new JPA();
            entityManager = getEntityManeger();
        }
        return jpa;    
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
    */
}
