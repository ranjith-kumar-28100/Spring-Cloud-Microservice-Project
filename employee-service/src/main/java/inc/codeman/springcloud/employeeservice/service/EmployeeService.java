package inc.codeman.springcloud.employeeservice.service;


import inc.codeman.springcloud.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto save(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long id);

}
