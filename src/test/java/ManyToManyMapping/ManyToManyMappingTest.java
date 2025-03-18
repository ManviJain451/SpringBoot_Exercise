package ManyToManyMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@SpringBootTest
@Rollback (false)
class ManyToManyMappingTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void saveAuthors()
    {
        Book book1 = new Book("The Ministry of Utmost Happiness");
        Book book2 = new Book("The God of Small Things");
        Book book3 = new Book("Five Point Someone, 2 States");
//        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
        Address address1 = new Address(42, "Lotus Street", "Delhi");
        Author author1 = new Author("Arundhati Roy", "arundhati.roy@literaturemail.com",
                address1,
                Arrays.asList("Fiction", "Political Commentary", "Environmental Issues"),
                Arrays.asList(book1,book2));

        authorRepository.save(author1);

        Address address2 = new Address(88, "Palm Groove Street", "Mumbai");
        Author author2 = new Author("Chetan Bhagat", "jhumpa.lahiri@literaryworld.com",
                address2,
                Arrays.asList("Romance", "Youth Fiction", "Social Commentary"),
                Arrays.asList(book1, book2, book3));

        authorRepository.save(author2);
//        authorRepository.saveAll(Arrays.asList(author1, author2));
    }

}
