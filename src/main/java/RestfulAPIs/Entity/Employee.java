package RestfulAPIs.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Table(name = "Employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "Employee_Name")
    @NotBlank(message = "Employee name is required")
    @Size(min = 2, max = 50, message = "Employee name must be between 2 and 50 characters")
    public String name;

    @Column(name = "Employee_age")
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Employee must be at least 18 years old")
    @Max(value = 65, message = "Employee must be at most 65 years old")
    public Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee(){

    }
}
