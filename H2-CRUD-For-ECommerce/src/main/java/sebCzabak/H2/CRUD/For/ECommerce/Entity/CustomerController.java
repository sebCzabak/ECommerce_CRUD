package sebCzabak.H2.CRUD.For.ECommerce.Entity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void registerNewCustomer(
            @RequestBody Customer customer) {
        customerService.registerNewCustomer(customer);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        customerService.updateCustomer(customerId,name,email);
    }
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId")Long customerId){
        customerService.deleteCustomer(customerId);
    }



}
