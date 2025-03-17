package SpringDataJPAPart2.Controller;

import SpringDataJPAPart2.Entity.Employee;
import SpringDataJPAPart2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // JPQL Endpoints

    @GetMapping("/above-average-salary")
    public ResponseEntity<List<Object[]>> getEmployeesWithSalaryAboveAverage() {
        return ResponseEntity.ok(employeeService.getEmployeesWithSalaryAboveAverage());
    }

    @PutMapping("/update-salary")
    public ResponseEntity<String> updateSalariesBelowAverage(@RequestParam double increment) {
        employeeService.updateSalariesBelowAverage(increment);
        return ResponseEntity.ok("Salaries updated successfully!");
    }

    @DeleteMapping("/delete-min-salary")
    public ResponseEntity<String> deleteEmployeesWithMinSalary() {
        employeeService.deleteEmployeesWithMinSalary();
        return ResponseEntity.ok("Employees with minimum salary deleted!");
    }

    // Native Query Endpoints

    @GetMapping("/lastname-singh")
    public ResponseEntity<List<Object[]>> getEmployeesWithLastNameSingh() {
        return ResponseEntity.ok(employeeService.getEmployeesWithLastNameSingh());
    }

    @DeleteMapping("/delete-by-age/{age}")
    public ResponseEntity<String> deleteEmployeesOlderThan(@PathVariable int age) {
        employeeService.deleteEmployeesOlderThan(age);
        return ResponseEntity.ok("Employees older than " + age + " deleted successfully!");
    }
}

