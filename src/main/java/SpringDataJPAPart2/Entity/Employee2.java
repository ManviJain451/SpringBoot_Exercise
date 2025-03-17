package SpringDataJPAPart2.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private SalaryDetails salaryDetails;
}
