package RestfulAPIs.RestfulAPIs.Repository;


import RestfulAPIs.RestfulAPIs.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
