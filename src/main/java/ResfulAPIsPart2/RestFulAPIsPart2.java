package ResfulAPIsPart2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RestFulAPIsPart2 {

	public static void main(String[] args) {
//		SpringApplication.run(RestFulAPIsPart2.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(RestFulAPIsPart2.class);
		System.out.println(context.getBeanDefinitionNames());

	}

}




