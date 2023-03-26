package inc.codeman.springcloud.employeeservice.service.impl;

import inc.codeman.springcloud.employeeservice.dto.APIResponseDto;
import inc.codeman.springcloud.employeeservice.dto.DepartmentDto;
import inc.codeman.springcloud.employeeservice.dto.EmployeeDto;
import inc.codeman.springcloud.employeeservice.entity.Employee;
import inc.codeman.springcloud.employeeservice.exception.ResourceNotFoundException;
import inc.codeman.springcloud.employeeservice.repository.EmployeeRepository;
import inc.codeman.springcloud.employeeservice.service.APIClient;
import inc.codeman.springcloud.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  EmployeeRepository employeeRepository;

   private ModelMapper modelMapper;
//    private RestTemplate restTemplate;

//    private WebClient webClient;
    private APIClient apiClient;
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
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        //Employee employee = optionalEmployee.get();
        //EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        //DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + employeeDto.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        //ResponseEntity<DepartmentDto> departmentDto = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employeeDto.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = apiClient.getDepartmentWithDepartmentCode(employeeDto.getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto(employeeDto,departmentDto);
        return apiResponseDto;
    }
}
