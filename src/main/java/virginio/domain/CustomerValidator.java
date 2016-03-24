package virginio.domain;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Customer.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (StringUtils.isEmpty(customer.getLastName())) {
            errors.rejectValue("lastName", "lastNameBlank");
        }
        if (StringUtils.isEmpty(customer.getFirstName())) {
            errors.rejectValue("firstName", "firstNameBlank");
        }
    }
}

