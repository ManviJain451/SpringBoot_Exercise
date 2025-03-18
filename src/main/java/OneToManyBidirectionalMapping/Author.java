package OneToManyBidirectionalMapping;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String emailId;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> subjects;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public void setBooks(List<Book> books)
    {
        if(books!=null)
        {
            if(this.books==null) this.books=new ArrayList<>();
            this.books.addAll(books);
            books.forEach(book -> book.setAuthor(this));
        }
    }

    public Author(String name, String emailId, Address address, List<String> subjects, List<Book> books) {
        this.name = name;
        this.emailId = emailId;
        this.address = address;
        this.subjects = subjects;
        this.books = books;
        this.setBooks(books);
    }
}
