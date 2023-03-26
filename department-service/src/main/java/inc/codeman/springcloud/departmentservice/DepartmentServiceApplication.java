package inc.codeman.springcloud.departmentservice;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@OpenAPIDefinition(info=@Info(title = "Department Microservice Documentation",description = "Spring Boot REST API Documentation for Department Spring Boot Microservice",version = "v1.0",contact = @Contact(name="Codeman",email="codemanrkg@gmail.com",url="https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/")))
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMap(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
