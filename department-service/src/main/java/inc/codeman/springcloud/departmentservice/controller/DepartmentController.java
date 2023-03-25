package inc.codeman.springcloud.departmentservice.controller;

import inc.codeman.springcloud.departmentservice.dto.DepartmentDto;
import inc.codeman.springcloud.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
private DepartmentService departmentService;
@PostMapping("create")
public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
    DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
    return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
}
@GetMapping("{department-code}")
public ResponseEntity<DepartmentDto> getDepartmentWithDepartmentCode(@PathVariable("department-code") String code){
    DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
    return ResponseEntity.ok(departmentDto);
}
}
