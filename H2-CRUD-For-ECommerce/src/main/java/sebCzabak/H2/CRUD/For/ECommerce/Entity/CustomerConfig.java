package sebCzabak.H2.CRUD.For.ECommerce.Entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer test0 = new Customer(
                    "TestCustomer",
                    "testOne@example.com",
                    LocalDate.of(1979, Month.AUGUST,19),
                    29
            );
            Customer test1 = new Customer(
                    "JohnDoe",
                    "JohnDoe@example.com",
                    LocalDate.of(1986, Month.APRIL,3),
                    29
            );
            repository.saveAll(List.of(test0,test1));
        };
    }

}
