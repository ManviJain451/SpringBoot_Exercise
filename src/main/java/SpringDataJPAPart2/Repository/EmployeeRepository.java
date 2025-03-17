package SpringDataJPAPart2.Repository;

import SpringDataJPAPart2.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //JPQL Queries
    @Query("SELECT e.firstName, e.lastName FROM Employee e WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2) ORDER BY e.age ASC, e.salary DESC")
    List<Object[]> getEmployeesWithSalaryAboveAverage();

    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();

    @Modifying
    @Query("UPDATE Employee e SET e.salary = e.salary + :increment WHERE e.salary < :averageSalary")
    void updateSalariesBelowAverage(@Param("increment") double increment, @Param("averageSalary") double averageSalary);

    @Query("SELECT MIN(e.salary) FROM Employee e")
    Double getMinimumSalary();

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.salary = :minimumSalary")
    void deleteEmployeesWithMinSalary(@Param("minimumSalary") double minimumSalary);

    // Native Queries
    @Query(value = "SELECT emp_id, emp_age, emp_first_name FROM employee_table WHERE emp_last_name LIKE '%singh'", nativeQuery = true)
    List<Object[]> getEmployeesWithLastNameSingh();

    @Modifying
    @Query(value = "DELETE FROM employee_table WHERE emp_age > :age", nativeQuery = true)
    void deleteEmployeesOlderThan(@Param("age") int age);
}


