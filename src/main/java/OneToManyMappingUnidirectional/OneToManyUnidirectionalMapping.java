package OneToManyMappingUnidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"OneToManyMappingUnidirectional"})
public class OneToManyUnidirectionalMapping {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyUnidirectionalMapping.class);
	}
}




