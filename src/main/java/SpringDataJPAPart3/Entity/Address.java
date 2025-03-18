package SpringDataJPAPart3.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private Integer streetNumber;
    private String location;
    private String state;
}
