package Spring.Data.JPA.Part1;

import Spring.Data.JPA.Part1.Controller.EmployeeController;
import Spring.Data.JPA.Part1.Entity.Employee;
import Spring.Data.JPA.Part1.Repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Spring.Data.JPA.Part1"})
public class SpringDataJPAPart1 {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPAPart1.class);
	}
}




