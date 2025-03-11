package RestfulAPIs.RestfulAPIs.Controller;

import RestfulAPIs.RestfulAPIs.Entity.Employee;
import RestfulAPIs.RestfulAPIs.Exception.UserNotFoundException;
import RestfulAPIs.RestfulAPIs.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
//        return employeeService.findOneEmployee(id);
        Employee employee = employeeService.findOneEmployee(id);
        if(employee == null){
            throw new UserNotFoundException("Resource Not Found.");
        }
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        if (employeeService.deleteEmployeeById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/employees/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    //    @PostMapping("/employees/create")
//    public Employee saveEmployee(@RequestBody Employee employee){
//        return employeeService.saveEmployee(employee);
//    }

    //    @PostMapping("/employees/create")
//    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
//        employeeService.saveUser(employee);
//        return ResponseEntity.created(null).build();
//    }

    @PostMapping("/employees/create")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .replacePath("/employees/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
//        return savedEmployee;
    }

}
