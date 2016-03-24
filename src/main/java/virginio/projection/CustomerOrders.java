package virginio.projection;

import org.springframework.data.rest.core.config.Projection;
import virginio.domain.Customer;
import virginio.domain.Order;

import java.util.List;

@Projection(name = "customerOrders", types = { Customer.class })
public interface CustomerOrders {

    List<Order> getOrders();
}
