package inc.codeman.springcloud.employeeservice.controller;

import inc.codeman.springcloud.employeeservice.dto.APIResponseDto;
import inc.codeman.springcloud.employeeservice.dto.EmployeeDto;
import inc.codeman.springcloud.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(name = "CRUD REST APIs for Employeee Resource",description = "CRUD REST APIs: Create Employee, Get Employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping("create")
    @Operation(summary = "Create Employee Rest API",description = "Create Employee REST API is used to save employee details into the database")
    @ApiResponse(responseCode = "201",description = "HTTP Status 201 Created")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.save(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("{employee-id}")
    @Operation(summary = "Get Employee by Id Rest API",description = "Get Employee by Id REST API is used to retrieve employee detail from the database")
    @ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
    public ResponseEntity<APIResponseDto> getEmployeeWithId(@PathVariable("employee-id") Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(apiResponseDto);
    }

}
