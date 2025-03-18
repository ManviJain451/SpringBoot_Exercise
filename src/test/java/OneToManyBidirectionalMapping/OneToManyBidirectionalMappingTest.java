package OneToManyBidirectionalMapping;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class OneToManyBidirectionalMappingTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void saveAuthors()
    {
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book("The Ministry of Utmost Happiness"));
        books1.add(new Book("The God of Small Things"));
         Address address1 = new Address(42, "Lotus Street", "Delhi");
         Author author1 = new Author("Arundhati Roy",
                   "arundhati.roy@literaturemail.com",
                   address1,
                   Arrays.asList("Fiction", "Political Commentary", "Environmental Issues"),
                   books1);

        authorRepository.save(author1);

        List<Book> books2 = new ArrayList<>();
        books2.add(new Book("Five Point Someone, 2 States"));
         Address address2 = new Address(88, "Palm Groove Street", "Mumbai");
         Author author2 = new Author("Chetan Bhagat", "jhumpa.lahiri@literaryworld.com",
                    address2,
                    Arrays.asList("Romance", "Youth Fiction", "Social Commentary"),
                    books2);

         authorRepository.save(author2);
    }


}
