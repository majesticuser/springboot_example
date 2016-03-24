package virginio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import virginio.domain.Customer;

import java.util.List;

//@RepositoryRestResource(excerptProjection = CustomerName.class)
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("name") String name);
    List<Customer> findByFirstName(@Param("name") String name);
}

