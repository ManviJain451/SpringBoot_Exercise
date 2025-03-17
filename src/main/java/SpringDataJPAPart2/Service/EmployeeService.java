package SpringDataJPAPart2.Service;

import SpringDataJPAPart2.Entity.Employee;
import SpringDataJPAPart2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Object[]> getEmployeesWithSalaryAboveAverage() {
        return employeeRepository.getEmployeesWithSalaryAboveAverage();
    }


    @Transactional
    public void updateSalariesBelowAverage(double increment) {
        Double averageSalary = employeeRepository.getAverageSalary();
        if (averageSalary != null) {
            employeeRepository.updateSalariesBelowAverage(increment, averageSalary);
        }
    }

    public void deleteEmployeesWithMinSalary() {
        Double minimumSalary = employeeRepository.getMinimumSalary();
        employeeRepository.deleteEmployeesWithMinSalary(minimumSalary);
    }


    public List<Object[]> getEmployeesWithLastNameSingh() {
        return employeeRepository.getEmployeesWithLastNameSingh();
    }

    public void deleteEmployeesOlderThan(int age) {
        employeeRepository.deleteEmployeesOlderThan(age);
    }
}

