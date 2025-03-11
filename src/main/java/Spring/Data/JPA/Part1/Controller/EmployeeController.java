package Spring.Data.JPA.Part1.Controller;

import Spring.Data.JPA.Part1.Entity.Employee;
import Spring.Data.JPA.Part1.Repository.EmployeeRepository;
import Spring.Data.JPA.Part1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    @PostMapping("/create")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully!";
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    //get count of rows or employees in the table
    @GetMapping("/count")
    public long getTotalEmployeesCount() {
        return employeeRepository.count();
    }

    // Implement Pagination and Sorting based on Employee Age
    @GetMapping("/sortedByAge")
    public Page<Employee> getEmployeesSortedByAge(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return employeeRepository.findAllByOrderByAgeAsc(PageRequest.of(page, size));
    }

    // Find Employee by Name
    @GetMapping("/findByName/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    // Find Employees whose names start with 'A'
    @GetMapping("/findByStartingLetter/{letter}")
    public List<Employee> findEmployeesByNameStartingWith(@PathVariable String letter) {
        return employeeRepository.findByNameStartingWith(letter);
    }

    // Find Employees between age 28 to 32
    @GetMapping("/findByAgeBetween/{startAge}/{endAge}")
    public List<Employee> findEmployeesByAgeBetween(@PathVariable int startAge, @PathVariable int endAge) {
        return employeeRepository.findByAgeBetween(startAge, endAge);
    }

}
