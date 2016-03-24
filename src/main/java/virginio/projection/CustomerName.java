package virginio.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import virginio.domain.Customer;

@Projection(name = "customerName", types = { Customer.class })
public interface CustomerName {

    String getLastName();
    String getFirstName();

    @Value("#{target.firstName} #{target.lastName}")
    String getFullName();
}
