package RestfulAPIs.Service;


import RestfulAPIs.Entity.Employee;
import RestfulAPIs.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findOneEmployee(Integer id) throws NullPointerException {
        return employeeRepository.findAll()
                .stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst().orElse(null);

//        Optional<Employee> optionalEmployee = employeeRepository.findAll()
//                .stream()
//                .filter(emp->emp.getId().equals(id))
//                .findFirst();
//        if(optionalEmployee.isPresent()){
//            Employee employee = optionalEmployee.get();
//            return employee;
//        }else{
//            throw new NullPointerException();
//        }

    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployeeById(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            return employeeRepository.save(employee);
        }).orElse(null);
    }

}
