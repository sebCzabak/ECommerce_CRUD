package sebCzabak.H2.CRUD.For.ECommerce.Entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void registerNewCustomer(final Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(final Long customerId, final String name, final String email) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("Customer with id " + customerId + " doesn't exists"));
        if (name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
            if (optionalCustomer.isPresent()) {
                throw new IllegalStateException("Email is already taken");
            }
            customer.setEmail(email);
        }
    }

    public void deleteCustomer(final Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("Customer with id "+customerId+" doesn't exists!");
        }
        customerRepository.deleteById(customerId);
    }
}


