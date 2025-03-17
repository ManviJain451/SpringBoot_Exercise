package SpringDataJPAPart2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employeeTable")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private Long id;

    @Column(name = "empFirstName", nullable = false)
    private String firstName;

    @Column(name = "empLastName", nullable = false)
    private String lastName;

    @Column(name = "empSalary", nullable = false)
    private Double salary;

    @Column(name = "empAge", nullable = false)
    private Integer age;


    public Employee() {}

    public Employee(String firstName, String lastName, Double salary, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

