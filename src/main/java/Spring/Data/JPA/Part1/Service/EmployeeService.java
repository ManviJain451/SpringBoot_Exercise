package Spring.Data.JPA.Part1.Service;

import Spring.Data.JPA.Part1.Entity.Employee;
import Spring.Data.JPA.Part1.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public String saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee.toString();
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            employee.setLocation(updatedEmployee.getLocation());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Integer id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

}
