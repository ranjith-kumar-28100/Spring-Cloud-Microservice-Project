package inc.codeman.springcloud.departmentservice.service.impl;

import inc.codeman.springcloud.departmentservice.dto.DepartmentDto;
import inc.codeman.springcloud.departmentservice.entity.Department;
import inc.codeman.springcloud.departmentservice.repository.DepartmentRepository;
import inc.codeman.springcloud.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto=new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(),savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = new DepartmentDto(department.getId(),department.getDepartmentName(),department.getDepartmentDescription(),department.getDepartmentCode());
        return departmentDto;
    }
}
