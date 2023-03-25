package inc.codeman.springcloud.employeeservice.repository;


import inc.codeman.springcloud.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
