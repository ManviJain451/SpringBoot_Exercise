package Spring.Data.JPA.Part1.Repository;

import Spring.Data.JPA.Part1.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    long count();

    Page<Employee> findAllByOrderByAgeAsc(Pageable pageable);

    List<Employee> findByName(String name);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByAgeBetween(int startAge, int endAge);

    

}
