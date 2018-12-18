package chiralsoftware.javajpa;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Demonstrate the same query using JPA
 */
public final class Jpa {

    private static final Logger LOG = Logger.getLogger(Jpa.class.getName());

    public static void main(String[] args) throws Exception {
        // Create an EntityManager
        // This loads the necessary properties from META-INF/persistence.xml
        final EntityManagerFactory emf = createEntityManagerFactory("jpa-test");
        final EntityManager entityManager = emf.
                createEntityManager();
        // Using a CriteriaBuilder for building queries with type safety
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        // Ready for queries
        final CriteriaQuery<Customer> criteriaQuery = 
                criteriaBuilder.createQuery(Customer.class);
        final Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customerRoot).
                where(criteriaBuilder.greaterThan(customerRoot.get("age"), 25)).
                orderBy(criteriaBuilder.asc(customerRoot.get("age")));
        
        final List<Customer> results = 
                entityManager.createQuery(criteriaQuery).getResultList();
        
        LOG.info("Here are the results: " + results);
        entityManager.close();
        emf.close(); // otherwise a thread will remain and the application will not exit
    }

}
