package ManyToManyMapping;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

    @ManyToMany(mappedBy = "books")
    private List<Author> author;

    public Book(String bookName)
    {
        this.bookName=bookName;
    }
}
