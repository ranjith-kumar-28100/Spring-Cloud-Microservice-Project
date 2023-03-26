package inc.codeman.springcloud.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DepartmentDto Model Information")
public class DepartmentDto {
    private Long id;
    @Schema(description = "Department Name")
    private String departmentName;
    @Schema(description = "Description about Department")
    private String departmentDescription;
    @Schema(description = "Department Code (Unique Identifier)")
    private String departmentCode;
}