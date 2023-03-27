package inc.codeman.springcloud.employeeservice.service;

import inc.codeman.springcloud.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentWithDepartmentCode(@PathVariable("department-code") String code);
}
