package inc.codeman.springcloud.departmentservice.service;

import inc.codeman.springcloud.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
}
