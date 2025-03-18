package OneToManyMappingUnidirectional;

import SpringDataJPAPart3.Entity.Address;
import SpringDataJPAPart3.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
