package inc.codeman.springcloud.departmentservice.controller;

import inc.codeman.springcloud.departmentservice.dto.DepartmentDto;
import inc.codeman.springcloud.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@Tag(name = "CRUD REST APIs for Department Resource",description = "CRUD REST APIs: Create Department, Get Department")
@RequestMapping("api/departments")
public class DepartmentController {
private DepartmentService departmentService;
@PostMapping("create")
@Operation(summary = "Create Department Rest API",description = "Create Department REST API is used to save department details into the database")
@ApiResponse(responseCode = "201",description = "HTTP Status 201 Created")
public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
    DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
    return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
}
@GetMapping("{department-code}")
@Operation(summary = "Get Department by Department-Code Rest API",description = "Get Department by Department-Code REST API is used to retrieve department detail from the database")
@ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
public ResponseEntity<DepartmentDto> getDepartmentWithDepartmentCode(@PathVariable("department-code") String code){
    DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
    return ResponseEntity.ok(departmentDto);
}
}
