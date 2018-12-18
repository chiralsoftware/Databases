package chiralsoftware.springdatajpa;

import java.util.stream.Stream;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Access JPA using Spring Data's Repository design
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Stream<Customer> findByAgeGreaterThan(int i, Pageable pageable);
    Stream<Customer> findByAgeGreaterThan(int i);

}
