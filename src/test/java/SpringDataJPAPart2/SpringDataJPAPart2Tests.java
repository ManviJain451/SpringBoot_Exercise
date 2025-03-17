package SpringDataJPAPart2;

import SpringDataJPAPart2.Entity.*;
import SpringDataJPAPart2.Repository.EmployeeRepository2;
import SpringDataJPAPart2.Repository.VehicleRepository;
import SpringDataJPAPart2.Repository.VehicleRepository1;
import SpringDataJPAPart2.Repository.VehicleRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringDataJPAPart2Tests {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleRepository1 vehicleRepository1;

	@Autowired
	private VehicleRepository2 vehicleRepository2;

	@Autowired
	private EmployeeRepository2 employeeRepository2;

	@Test
	public void testCreateVehicleSingleTable() {
		Car car = new Car();
		car.setBrand("Toyota");
		car.setPrice(20000);
		car.setSeatingCapacity(5);
		vehicleRepository.save(car);

		Bike bike = new Bike();
		bike.setBrand("Honda");
		bike.setPrice(1500);
		bike.setHasCarrier(true);
		vehicleRepository.save(bike);


		List<Vehicle> vehicles = vehicleRepository.findAll();

		assertEquals(2, vehicles.size(), "Total number of vehicles should be 2");

		Vehicle v1 = vehicles.get(0);
		Vehicle v2 = vehicles.get(1);

		assertTrue(v1 instanceof Car || v2 instanceof Car);
		assertTrue(v1 instanceof Bike || v2 instanceof Bike);
	}


	@Test
	public void testCreateVehicleJoinedStrategy() {

		Car1 car1 = new Car1();
		car1.setBrand("Tesla");
		car1.setPrice(50000);
		car1.setSeatingCapacity(4);
		vehicleRepository1.save(car1);

		Bike1 bike1 = new Bike1();
		bike1.setBrand("Yamaha");
		bike1.setPrice(1800);
		bike1.setHasCarrier(false);
		vehicleRepository1.save(bike1);

		List<Vehicle1> vehicles = vehicleRepository1.findAll();

		assertEquals(2, vehicles.size(), "Total number of vehicles should be 2");

		Vehicle1 v1 = vehicles.get(0);
		Vehicle1 v2 = vehicles.get(1);

		assertTrue(v1 instanceof Car1 || v2 instanceof Car1);
		assertTrue(v1 instanceof Bike1 || v2 instanceof Bike1);

		if (v1 instanceof Car1) {
			assertEquals(4, ((Car1) v1).getSeatingCapacity(), "Car should have 4 seats");
		}
		if (v2 instanceof Bike1) {
			assertFalse(((Bike1) v2).isHasCarrier(), "Bike should not have a carrier");
		}
	}

	@Test
	public void testCreateVehicleTablePerCLassStrategy() {

		Car2 car2 = new Car2();
		car2.setBrand("Swift");
		car2.setPrice(20000);
		car2.setSeatingCapacity(4);
		vehicleRepository2.save(car2);

		Bike2 bike2= new Bike2();
		bike2.setBrand("Hero");
		bike2.setPrice(1600);
		bike2.setHasCarrier(true);
		vehicleRepository2.save(bike2);

		List<Vehicle2> vehicles = vehicleRepository2.findAll();

		assertEquals(2, vehicles.size(), "Total number of vehicles should be 2");

		Vehicle2 v1 = vehicles.get(0);
		Vehicle2 v2 = vehicles.get(1);

		assertTrue(v1 instanceof Car2 || v2 instanceof Car2);
		assertTrue(v1 instanceof Bike2 || v2 instanceof Bike2);

		if (v1 instanceof Car2) {
			assertEquals(4, ((Car2) v1).getSeatingCapacity(), "Car should have 4 seats");
		}
		if (v2 instanceof Bike2) {
			assertTrue(((Bike2) v2).isHasCarrier(), "Bike should have a carrier");
		}
	}

	@Test
	public void testEmbeddedMapping() {

		SalaryDetails salaryDetails = new SalaryDetails(60000.0, 7000.0, 300.0, 5000.0);


		Employee2 employee = new Employee2(null, "Manvi", "Jain", 28, salaryDetails);
		employeeRepository2.save(employee);

		List<Employee2> employees = employeeRepository2.findAll();

		assertEquals(1, employees.size());

		Employee2 retrievedEmployee = employees.get(0);
		assertEquals("Manvi", retrievedEmployee.getFirstName());
		assertEquals(60000, retrievedEmployee.getSalaryDetails().getBasicSalary());
		assertEquals(7000, retrievedEmployee.getSalaryDetails().getBonusSalary());
	}
}
