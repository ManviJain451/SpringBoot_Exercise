package Spring.Data.JPA.Part1;

import Spring.Data.JPA.Part1.Entity.Employee;
import Spring.Data.JPA.Part1.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJPAPart1Tests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testSaveEmployee(){
//		Employee employee = new Employee("Manvi", "Noida", 22);
//		employeeRepository.save(employee);
//	}


}
