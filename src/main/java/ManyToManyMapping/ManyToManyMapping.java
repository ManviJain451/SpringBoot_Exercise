package ManyToManyMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ManyToManyMapping"})
public class ManyToManyMapping {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMapping.class);
	}
}




