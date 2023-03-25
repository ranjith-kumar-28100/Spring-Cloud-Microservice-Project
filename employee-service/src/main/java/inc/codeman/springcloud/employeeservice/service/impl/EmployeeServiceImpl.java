package inc.codeman.springcloud.employeeservice.service.impl;

import inc.codeman.springcloud.employeeservice.dto.EmployeeDto;
import inc.codeman.springcloud.employeeservice.entity.Employee;
import inc.codeman.springcloud.employeeservice.exception.ResourceNotFoundException;
import inc.codeman.springcloud.employeeservice.repository.EmployeeRepository;
import inc.codeman.springcloud.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        //Employee employee = new Employee(employeeDto.getId(),employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        //EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail());
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        //Employee employee = optionalEmployee.get();
        //EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }
}
