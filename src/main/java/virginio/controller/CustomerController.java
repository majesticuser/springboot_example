package virginio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import virginio.domain.Customer;
import virginio.repository.CustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/create")
    String create() {
        counterService.increment("customers.create.invoked");

        customerRepository.save(new Customer("Virginio", "Carfagno"));
        customerRepository.save(new Customer("Sven", "Welte"));
        customerRepository.save(new Customer("Tobias", "Adam"));

        return "redirect:/index";
    }

    @RequestMapping("/index")
    ModelAndView index(
    ) {
        counterService.increment("customers.index.invoked");
        Iterable<Customer> customers = customerRepository.findAll();

        Map model = new HashMap<>();
        model.put("customers", customers);
        return new ModelAndView("customers/index", model);
    }

    @RequestMapping("/searchByLastName")
    ModelAndView searchByLastName(
        @RequestParam String lastName
    ) {
        counterService.increment("customers.index.invoked");
        List<Customer> customers = customerRepository.findByLastName(lastName);

        Map model = new HashMap<>();
        model.put("customers", customers);
        return new ModelAndView("customers/index", model);
    }

}