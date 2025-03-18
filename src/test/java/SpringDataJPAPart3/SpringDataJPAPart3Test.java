package SpringDataJPAPart3;

import SpringDataJPAPart3.Entity.Address;

import SpringDataJPAPart3.Entity.Author;
import SpringDataJPAPart3.Entity.Book;
import SpringDataJPAPart3.Repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SpringDataJPAPart3Test {

    @Autowired
    private AuthorRepository authorRepository;

//	@Test
//	public void saveAuthors(){
//		Author author1 = new Author(null,"Arundhati Roy", "arundhati.roy@literaturemail.com",
//				new Address(42, "Lotus Street", "Delhi"),
//				Arrays.asList("Fiction", "Political Commentary", "Environmental Issues"));
//
//		Author author2 = new Author(null,"Chetan Bhagat", "jhumpa.lahiri@literaryworld.com",
//				new Address(88, "Palm Groove Street", "Mumbai"),
//				Arrays.asList("Romance", "Youth Fiction", "Social Commentary"));
//
//		Author author3 = new Author(null,"Vikram Seth", "vikram.seth@poeticnarratives.com",
//				new Address(28, "Heritage Street, Dehradun", "Uttarakhand"),
//				Arrays.asList("Poetry", "Historical Fiction", "Social Issues"));
//
//		authorRepository.saveAll(Arrays.asList(author1, author2, author3));
//
//	}

    @Test
    public void saveAuthors() {
        Author author1 = new Author(null, "Arundhati Roy", "arundhati.roy@literaturemail.com",
                new Address(42, "Lotus Street", "Delhi"),
                Arrays.asList("Fiction", "Political Commentary", "Environmental Issues"), new Book(null, "The God of Small Things"));

        Author author2 = new Author(null, "Chetan Bhagat", "jhumpa.lahiri@literaryworld.com",
                new Address(88, "Palm Groove Street", "Mumbai"),
                Arrays.asList("Romance", "Youth Fiction", "Social Commentary"), new Book(null, "Five Point Someone, 2 States"));

        Author author3 = new Author(null, "Vikram Seth", "vikram.seth@poeticnarratives.com",
                new Address(28, "Heritage Street, Dehradun", "Uttarakhand"),
                Arrays.asList("Poetry", "Historical Fiction", "Social Issues"), new Book(null, "A Suitable Boy, An Equal Music"));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));

    }


}
