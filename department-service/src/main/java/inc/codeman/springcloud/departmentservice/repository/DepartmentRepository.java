package inc.codeman.springcloud.departmentservice.repository;

import inc.codeman.springcloud.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);
}
