package chiralsoftware.springdatajpa;

import static java.lang.Float.NaN;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.by;

/**
 * This will load JDBC properties from the applications.properties file
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    @Autowired
    private CustomerRepository customerRepository;
    
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
    @Override
    @Transactional // a transaction is required because methods returning a Stream don't fetch results until needed
    public void run(String... args) throws Exception {
        LOG.info("Customers over age 24, sorted by age, paginated:");
        final Stream<Customer> customers = customerRepository.findByAgeGreaterThan(24, of(0, 2,  by("age").ascending())); // page 0 of pages of 2 items
        customers.forEach((c) -> LOG.info("Customer: " + c));
        
        final double average = customerRepository.
                findByAgeGreaterThan(24).
                mapToDouble(Customer::getAge).
                average().
                orElse(NaN);
        LOG.info("Average age of customers over age 24: " + average);
                
    }
}
