package inc.codeman.springcloud.employeeservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "EmployeeDto Model Information")
public class EmployeeDto {
    private Long id;
    @Schema(description = "First Name of the Employee")
    private String firstName;
    @Schema(description = "Last Name of the Employee")
    private String lastName;
    @Schema(description = "Email Id of the Employee")
    private String email;
    @Schema(description = "Code of the Department Employee belongs to")
    private String departmentCode;
}
