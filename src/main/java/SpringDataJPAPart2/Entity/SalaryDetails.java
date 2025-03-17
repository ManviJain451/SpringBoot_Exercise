package SpringDataJPAPart2.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SalaryDetails {
    private double basicSalary;
    private double bonusSalary;
    private double taxAmount;
    private double specialAllowanceSalary;

}
