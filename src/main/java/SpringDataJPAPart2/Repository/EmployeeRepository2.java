package SpringDataJPAPart2.Repository;

import SpringDataJPAPart2.Entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository2 extends JpaRepository<Employee2, Long> {
}
