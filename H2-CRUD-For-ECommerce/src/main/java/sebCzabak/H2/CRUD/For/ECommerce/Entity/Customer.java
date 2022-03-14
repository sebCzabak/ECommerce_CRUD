package sebCzabak.H2.CRUD.For.ECommerce.Entity;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Customer(final String name, final String email, final LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }


}
