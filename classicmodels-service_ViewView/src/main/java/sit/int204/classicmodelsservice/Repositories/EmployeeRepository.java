package sit.int204.classicmodelsservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
