package com.springBoot.exercise.Questions;

import com.springBoot.exercise.Questions.entity.Employee;
import com.springBoot.exercise.Questions.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionsApplication implements CommandLineRunner {

	@Autowired
	private ShopConfiguration shopConfiguration;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuestionsApplication.class, args);
	}

	@Override
	public void run(String... args){

		System.out.println("Shop Name: " + shopConfiguration.getShopName());
		System.out.println("Shop City: " + shopConfiguration.getShopCity());
		System.out.println("Shop Owner: " + shopConfiguration.getShopOwner());

		employeeRepository.save(new Employee("Manvi", "JVM Trainee"));
		employeeRepository.save(new Employee("Akshat", "Devops Trainee"));
		employeeRepository.save(new Employee("Kunal", "Full Stack Developer"));


		employeeRepository.findAll().forEach(emp ->
				System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getDesignation())
		);
	}
}




