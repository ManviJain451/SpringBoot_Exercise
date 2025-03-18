package ManyToManyMapping;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> subjects;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "author_book_map",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;
    public Author(String name, String email, Address address, List<String> subjects,  List<Book> books)
    {
        this.name=name;
        this.address=address;
        this.email=email;
        this.subjects=subjects;
        this.books=books;
    }

}