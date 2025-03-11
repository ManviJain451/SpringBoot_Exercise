package Spring.Data.JPA.Part1.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees_Details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Employee_Name")
    private String name;

    @Column(name = "Employee_Location")
    private String location;

    @Column(name = "Employee_Age")
    private Integer age;

    public Employee(){}

    public Employee(String name, String location, Integer age){
        this.age = age;
        this.name = name;
        this.location = location;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", age=" + age +
                '}';
    }
}
