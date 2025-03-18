package OneToManyMappingUnidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class OneToManyMappingTest {

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testCache() {
        Session session = entityManager.unwrap(Session.class);

        Transaction tx = session.beginTransaction();
        Author author = session.get(Author.class, 1L);

        session.evict(author);
//        Author author2 = session.get(Author.class, 1L);
        tx.commit();
        session.close();
    }

    @Test
    public void test_OneToManyUnidirectionalMapping() {
        Author author1 = new Author(null, "Arundhati Roy", "arundhati.roy@literaturemail.com",
                new Address(42, "Lotus Street", "Delhi"),
                Arrays.asList("Fiction", "Political Commentary", "Environmental Issues"),
                Arrays.asList(
                        new Book("The God of Small Things"),
                        new Book("The Ministry of Utmost Happiness")
                ));

        Author author2 = new Author(null, "Chetan Bhagat", "jhumpa.lahiri@literaryworld.com",
                new Address(88, "Palm Groove Street", "Mumbai"),
                Arrays.asList("Romance", "Youth Fiction", "Social Commentary"),
                Arrays.asList(new Book("Five Point Someone, 2 States")
                ));


        authorRepository.saveAll(Arrays.asList(author1, author2));
    }


   
}
